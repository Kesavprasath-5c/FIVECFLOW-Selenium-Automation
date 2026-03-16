package com.FiveC_flow_Test_Components;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.FiveCResources.ExtendRepor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import java.util.List;
import java.util.Map;

public class Listener extends BaseTest implements ITestListener {
   ExtentReports extent;
   ExtentTest test;

   // This Listener class will not simply deducted by xml file whil running the we
   // need explicity tell by declering the Listeners tag , then suit will
   // understand that before executing the meth0d we need first go and check what
   // the listeners says
   public Listener() {
      // Initialize here or inside methods to avoid static load issues
      try {
         extent = ExtendRepor.getExtendReportObject();
      } catch (Exception e) {
         System.out.println("Extent Report failed to initialize: " + e.getMessage());
      }
   }

   // for every Test method this result varibale is automatcally passed
   // This results will holds the information about which test going to execute
   // so using this result we can get methdo name which is going to executed
   @Override
   public void onTestStart(ITestResult result) {
      if (extent != null) {
         test = extent.createTest(result.getMethod().getMethodName());
      }
      TestLogCapture.startCapture();
   }

   @Override
   public void onTestSuccess(ITestResult result) {
      test.log(Status.PASS, "Test Passed");
      attachTestLogs();
   }

   @Override
   public void onTestFailure(ITestResult result) {
      WebDriver driver = null;
      try {
         // Get driver from test instance
         driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
      } catch (NoSuchFieldException e) {
         // This is expected for Cucumber runners or classes without a direct driver
         // field
         System.out.println("No 'driver' field found in class " + result.getTestClass().getRealClass().getName()
               + ". Skipping listener screenshot.");
      } catch (Exception e) {
         System.out.println("Could not retrieve driver for screenshot: " + e.getMessage());
      }

      // this test.fail will add the failure details in the report like it will throw
      // the error msg

      test.fail(result.getThrowable());
      test.log(Status.FAIL, "Test Failed");
      attachTestLogs();

      if (driver != null) {
         try {
            // Use BaseTest's getScreenShot method to avoid code duplication
            String filepath = getScreenShot(result.getMethod().getMethodName(), driver);
            // Attach screenshot to Extent Report first agr setting the path and second arg
            // where setting how we need to name the screenshot
            test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());

            // Add failed APIs from Chrome Network tab (4xx, 5xx, loading failed)
            List<Map<String, String>> failedApis = NetworkLogUtil.getFailedApis(driver);
            if (!failedApis.isEmpty()) {
               String[][] tableData = new String[failedApis.size() + 1][4];
               tableData[0] = new String[] { "Method", "Status", "URL", "Error" };
               int i = 1;
               for (Map<String, String> row : failedApis) {
                  String url = row.getOrDefault("url", "");
                  if (url.length() > 100) url = url.substring(0, 97) + "...";
                  tableData[i++] = new String[] {
                     row.getOrDefault("method", ""),
                     row.getOrDefault("status", ""),
                     url,
                     row.getOrDefault("error", "")
                  };
               }
               test.log(Status.INFO, MarkupHelper.createTable(tableData));
            }
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

   private void attachTestLogs() {
      String logs = TestLogCapture.getAndClearLogs();
      if (!logs.isEmpty()) {
         test.log(Status.INFO, MarkupHelper.createCodeBlock(logs));
      }
   }

   @Override
   public void onFinish(ITestContext context) {
      extent.flush();
   }
}
