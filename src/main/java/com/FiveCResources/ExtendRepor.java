package com.FiveCResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendRepor {

    /*
    Add Extend report Dependencies in POM.xml
    There are 2 classes in ExtendReport 
    1. ExtentReports--> This is the main class responsible to driver all the reports 
    It manages:
    Test creation
    Logging steps (PASS / FAIL / INFO)
    Attaching screenshots
    Flushing data from the report
    Think of it as the brain of the reporting system 
    2. ExtentSparkReporter --> this responsible to generates a beautiful HTML report and can made some configurations in that report
    This 2 classes are used to generate the report
    NOte: System.getProperty("user.dir") this will give the project path dynamically
     */
    public static ExtentReports getExtendReportObject() {
        String path = System.getProperty("user.dir") + "/reports/index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("FiveCReport");
        reporter.config().setDocumentTitle("FiveCFlow");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "kesav");
        return extent;
      
    }
}
