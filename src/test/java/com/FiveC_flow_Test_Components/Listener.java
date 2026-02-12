package com.FiveC_flow_Test_Components;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;

import com.FiveCResources.ExtendRepor;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;



public class Listener extends BaseTest implements ITestListener {
   ExtentReports extent;
   ExtentTest test;
// This Listener class will not simply deducted by xml file whil running the we need explicity tell by declering the Listeners tag , then suit will understand that before executing the meth0d we need first go and check wht the listeners says
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
   // so using this result we can get  methdo name which is going to executed 
   @Override
   public void onTestStart(ITestResult result) {
      // Basically this "result" will hold the information about the result which is goig to execute  in this method and setting the entry in the report
      if (extent != null) {
         test = extent.createTest(result.getMethod().getMethodName());
     }
   }

   @Override
   public void onTestSuccess(ITestResult result) {
      //This line of code say that if test is passed successfully then below line of code will exectute 
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
      
      // this test.fail will add the failure details in the report like it will throw the error msg 

      test.fail(result.getThrowable()); 
      test.log(Status.FAIL, "Test Failed");
      
      if (driver != null) { 
         try {
            // Use BaseTest's getScreenShot method to avoid code duplication
            String filepath = getScreenShot(result.getMethod().getMethodName(), driver);
            // Attach screenshot to Extent Report first agr setting the path and second arg where setting how we need to name the screenshot
            test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
   
         } 
         catch (Exception e) {
            e.printStackTrace();
         }
      } 
   }

   @Override
   public void onFinish(ITestContext context) {
      // this is responsible to generate the report if we miss this all report creation entry will we done but it will fail to generate the report
      extent.flush();
   }
}
