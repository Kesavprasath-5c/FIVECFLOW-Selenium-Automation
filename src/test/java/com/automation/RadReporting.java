package com.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.DataFile.Rad_TestData;

public class RadReporting {
    WebDriver driver;
    WebDriverWait wait;

@BeforeTest
 public void radLogin() {
     ChromeOptions options = new ChromeOptions();
    HashMap<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("profile.default_content_setting_values.clipboard",1);
    options.setExperimentalOption("prefs", prefs);
   
     driver = new ChromeDriver(options);
    
    
  
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.get(Rad_TestData.Rad_url);
    driver.manage().window().maximize();
    driver.findElement(By.id("email")).sendKeys(Rad_TestData.Rad_email);
    driver.findElement(By.id("password")).sendKeys(Rad_TestData.Rad_password,Keys.ENTER);
    WebElement logout_button  = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Logout')]")));
    if (logout_button.isDisplayed()){
        System.out.println("Rad Login Passed");
    } 
    else {
        System.out.println("Rad Login Failed");
    
        }
 }

 @Test
 public void rad_report_submission() throws Exception{
    
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='icon_search']"))).click();
    File file = new File("/Users/Kesav/Documents/caseid/id.txt");
    FileReader FR = new FileReader(file);
    BufferedReader br = new BufferedReader(FR);
    String caseid = br.readLine();
    System.out.println(caseid);
    Thread.sleep(2000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("mdc-text-field__input"))).sendKeys(caseid);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Go']"))).click();
    WebElement caseClick = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='icon_case-view']")));
    caseClick.click();
    System.out.println(driver.getWindowHandles());
    Set<String> allWindowHandles = driver.getWindowHandles();
    List<String> lst = new ArrayList<>(allWindowHandles);
    driver.switchTo().window(lst.get(1));
    Thread.sleep(2000);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Start Reporting >']"))).click();
    String content="I have a cure for insomnia. It’s probably worth millions of dollars but I’m giving it to you free. It isn’t warm milk or chamomile tea. It’s list making";
    WebElement Protocol = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span")));
    Protocol.click();
    Protocol.sendKeys(content);
    Thread.sleep(1000);
    WebElement Observation =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Observations']/ancestor::span[3]/following-sibling::span")));
	Observation.click();
	Observation.sendKeys(content);
    try {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Saved']"))).isDisplayed();
		}
		catch (Exception e) {
			
		}
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Submit')]"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Submit & stop reporting')]"))).click();  

 }
 

}

