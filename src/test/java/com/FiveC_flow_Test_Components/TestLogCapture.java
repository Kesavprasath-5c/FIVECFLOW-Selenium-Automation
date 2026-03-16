package com.FiveC_flow_Test_Components;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Captures System.out (console logs) per test thread and provides the content
 * for attaching to the Extent report.
 */
public final class TestLogCapture {

    private static final ThreadLocal<StringBuilder> threadLogs = new ThreadLocal<>();
    private static PrintStream originalOut;
    private static volatile boolean installed;

    private TestLogCapture() {}

    /**
     * Start capturing console output for the current thread. Call in onTestStart.
     */
    public static void startCapture() {
        threadLogs.set(new StringBuilder());
        installIfNeeded();
    }

    /**
     * Get captured logs for the current thread and stop capturing. Call in onTestSuccess/onTestFailure.
     */
    public static String getAndClearLogs() {
        StringBuilder sb = threadLogs.get();
        threadLogs.remove();
        return sb != null && sb.length() > 0 ? sb.toString() : "";
    }

    private static synchronized void installIfNeeded() {
        if (installed) return;
        originalOut = System.out;
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                originalOut.write(b);
                StringBuilder sb = threadLogs.get();
                if (sb != null) sb.append((char) b);
            }

            @Override
            public void write(byte[] b, int off, int len) throws IOException {
                originalOut.write(b, off, len);
                StringBuilder sb = threadLogs.get();
                if (sb != null) sb.append(new String(b, off, len, StandardCharsets.UTF_8));
            }
        }, true, StandardCharsets.UTF_8));
        installed = true;
    }
}
