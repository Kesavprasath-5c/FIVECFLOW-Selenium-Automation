package com.automation;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class BaseClass {
    protected static WebDriver driver; 

    public void LaunchBrowser(){
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);  
        driver.manage().window().maximize();


    }

      public void closeBrowser() {
       
            driver.quit();
      }

      public void ScreenShot(String filename){
      TakesScreenshot tr = (TakesScreenshot)driver;
      File Sourcefile = tr.getScreenshotAs(OutputType.FILE);
      File distenefile = new File("/Users/Kesav/Desktop/automation-projects/FIVECFLOW-Selenium-Automation/src/test/resources/screenshotfloder/"+ filename);

       try {
        FileUtils.copyFile(Sourcefile, distenefile);
    } catch (IOException e) {
        System.out.println("issue in ScreenShot");
   
    }
    

      }

}
