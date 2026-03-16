package com.FiveCResources;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendRepor {

    /*
    Add Extend report Dependencies in POM.xml (extentreports dependencies)
    Each run gets a unique report: reports/index_yyyy-MM-dd_HH-mm-ss.html
    */
    public static ExtentReports getExtendReportObject() {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        String path = System.getProperty("user.dir") + "/reports/index_" + timestamp + ".html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("FiveCReport");
        reporter.config().setDocumentTitle("FiveCFlow");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "kesav");
        return extent;
      
    }
}
