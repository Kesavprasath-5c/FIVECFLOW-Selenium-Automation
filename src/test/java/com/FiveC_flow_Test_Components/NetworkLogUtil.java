package com.FiveC_flow_Test_Components;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Captures Chrome performance logs and builds an HTML table of network requests
 * for inclusion in the Extent report.
 */
public final class NetworkLogUtil {

    private static final int MAX_REQUESTS = 100;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    private NetworkLogUtil() {}

    /**
     * Returns HTML fragment (table) of network requests for the given driver, or empty string if not available.
     * Only works with Chrome when performance logging is enabled.
     */
    public static String getNetworkLogsHtml(WebDriver driver) {
        if (driver == null) return "";
        try {
            LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);
            if (logs == null) return "";
            List<Map<String, String>> rows = parsePerformanceLogs(logs);
            return buildHtmlTable(rows);
        } catch (Exception e) {
            return "<p>Network logs not available: " + escapeHtml(e.getMessage()) + "</p>";
        }
    }

    /**
     * Returns list of failed request rows (4xx, 5xx, or loading failed) for use with MarkupHelper or HTML.
     */
    public static List<Map<String, String>> getFailedApis(WebDriver driver) {
        if (driver == null) return List.of();
        try {
            LogEntries logs = driver.manage().logs().get(LogType.PERFORMANCE);
            if (logs == null) return List.of();
            List<Map<String, String>> allRows = parsePerformanceLogs(logs);
            List<Map<String, String>> failedOnly = new ArrayList<>();
            for (Map<String, String> row : allRows) {
                String statusStr = row.getOrDefault("status", "");
                if ("-".equals(statusStr) || statusStr.isEmpty() || "Failed".equals(statusStr)) {
                    if (!row.containsKey("error")) row.put("error", "No response / Canceled");
                    failedOnly.add(row);
                } else {
                    try {
                        int status = Integer.parseInt(statusStr);
                        if (status >= 400) failedOnly.add(row);
                    } catch (NumberFormatException ignored) {}
                }
            }
            return failedOnly;
        } catch (Exception e) {
            return List.of();
        }
    }

    /**
     * Returns HTML table of only FAILED network requests (4xx, 5xx, or loading failed).
     * Use this in the report when a test fails to show which APIs failed.
     */
    public static String getFailedApisHtml(WebDriver driver) {
        List<Map<String, String>> failedOnly = getFailedApis(driver);
        if (failedOnly.isEmpty()) return "";
        return buildHtmlTable(failedOnly, true);
    }

    private static List<Map<String, String>> parsePerformanceLogs(LogEntries entries) {
        Map<String, Map<String, String>> byRequestId = new LinkedHashMap<>();
        for (LogEntry entry : entries.getAll()) {
            if (entry.getLevel() != Level.INFO) continue;
            String msg = entry.getMessage();
            try {
                JsonNode root = MAPPER.readTree(msg);
                JsonNode message = root.path("message");
                String method = message.path("method").asText("");
                JsonNode params = message.path("params");

                if ("Network.requestWillBeSent".equals(method)) {
                    String requestId = params.path("requestId").asText("");
                    String url = params.path("request").path("url").asText("");
                    String httpMethod = params.path("request").path("method").asText("GET");
                    byRequestId.putIfAbsent(requestId, new LinkedHashMap<String, String>());
                    byRequestId.get(requestId).put("url", url);
                    byRequestId.get(requestId).put("method", httpMethod);
                } else if ("Network.loadingFinished".equals(method) || "Network.responseReceived".equals(method)) {
                    String requestId = params.path("requestId").asText("");
                    if (byRequestId.containsKey(requestId)) {
                        if (params.has("response")) {
                            int status = params.path("response").path("status").asInt(-1);
                            byRequestId.get(requestId).put("status", status > 0 ? String.valueOf(status) : "Failed");
                        }
                    }
                } else if ("Network.loadingFailed".equals(method)) {
                    String requestId = params.path("requestId").asText("");
                    String errorText = params.path("errorText").asText("Failed");
                    if (byRequestId.containsKey(requestId)) {
                        byRequestId.get(requestId).put("status", "Failed");
                        byRequestId.get(requestId).put("error", errorText);
                    }
                }
            } catch (Exception ignored) {
                // skip malformed entries
            }
        }

        List<Map<String, String>> rows = new ArrayList<>();
        int count = 0;
        for (Map<String, String> row : byRequestId.values()) {
            if (count >= MAX_REQUESTS) break;
            if (row.containsKey("url") && !row.get("url").isEmpty()) {
                rows.add(row);
                count++;
            }
        }
        return rows;
    }

    private static String buildHtmlTable(List<Map<String, String>> rows) {
        return buildHtmlTable(rows, false);
    }

    private static String buildHtmlTable(List<Map<String, String>> rows, boolean includeError) {
        if (rows.isEmpty()) return "<p>No failed network requests captured.</p>";
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='network-logs'><h5>Failed APIs (Network)</h5>");
        sb.append("<table class='table table-sm'><thead><tr>");
        sb.append("<th>Method</th><th>Status</th><th>URL</th>");
        if (includeError) sb.append("<th>Error</th>");
        sb.append("</tr></thead><tbody>");
        for (Map<String, String> row : rows) {
            String method = row.getOrDefault("method", "");
            String status = row.getOrDefault("status", "-");
            String url = row.getOrDefault("url", "");
            if (url.length() > 120) url = url.substring(0, 117) + "...";
            sb.append("<tr><td>").append(escapeHtml(method)).append("</td><td>").append(escapeHtml(status))
              .append("</td><td>").append(escapeHtml(url)).append("</td>");
            if (includeError && row.containsKey("error"))
                sb.append("<td>").append(escapeHtml(row.get("error"))).append("</td>");
            sb.append("</tr>");
        }
        sb.append("</tbody></table></div>");
        return sb.toString();
    }

    private static String escapeHtml(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
    }
}
