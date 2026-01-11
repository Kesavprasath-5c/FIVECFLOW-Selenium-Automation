package com.FiveC_flow_Test_Components;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.FiveCResources.ExtendRepor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Listener implements ITestListener {
   ExtentReports extent;
   ExtentTest test;

   public Listener() {
       // Initialize here or inside methods to avoid static load issues
       try {
           extent = ExtendRepor.getExtendReportObject();
       } catch (Exception e) {
           System.out.println("Extent Report failed to initialize: " + e.getMessage());
       }
   }

   @Override
   public void onTestStart(ITestResult result) {
      if (extent != null) {
         test = extent.createTest(result.getMethod().getMethodName());
     }
   }

   @Override
   public void onTestSuccess(ITestResult result) {
      test.log(Status.PASS, "Test Passed");
   }

   @Override
   public void onTestFailure(ITestResult result) {
      WebDriver driver = null;
      try {
         // Get driver from test instance
         driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
      } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
         e.printStackTrace();
      }
      
      // this test.fail will add the failure details in the report
      test.fail(result.getThrowable());
      test.log(Status.FAIL, "Test Failed");
      
      String filepath = null;
      if (driver != null) {
         try {
            // Take screenshot directly
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File file = new File(System.getProperty("user.dir") + "//reports//" + result.getMethod().getMethodName() + ".png");
            FileUtils.copyFile(source, file);
            filepath = System.getProperty("user.dir") + "//reports//" + result.getMethod().getMethodName() + ".png";
         } 
         catch (Exception e) {
            e.printStackTrace();
         }
      }

      if (filepath != null) {
         // Here we sending the Screenshot path and saying the test name as the Report name
         test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
      }
   }

   @Override
   public void onFinish(ITestContext context) {
      extent.flush();
   }
}
