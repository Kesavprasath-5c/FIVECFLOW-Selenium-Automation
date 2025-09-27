package com.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.DataFile.Clinet_TestData;


@Listeners ({ItestListenersClass.class})
public class ClientsPF extends BaseClass{
   
  
 

   @BeforeMethod
    public void clientLogin() throws Exception {
        LaunchBrowser();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get(com.DataFile.Clinet_TestData.url); 
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_emailId")));
		username.sendKeys(com.DataFile.Clinet_TestData.email);
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_password")));
		password.sendKeys(Clinet_TestData.password, Keys.ENTER);
        try {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Welcome, Jeevan Hospital')]")));
			System.out.println("Login Passed");
		}
		catch (Exception e) {
			System.out.println("Login failed");
			
		}
        }
 @Test
    public void NormalCaseActivation() throws Exception{
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']"))).click();
    	try {
    		WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    		shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']"))).click();
    	}
		catch (Exception e) {
             
					}
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Draft')]"))).click();
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Clear All')]"))).click();
		WebElement lastDiv = wait.until(ExpectedConditions.elementToBeClickable( By.xpath("//tbody//tr[2]/td[last()]//div[contains(@class,'ant-space-item')][last()]")));
        lastDiv.click();
		wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Merge Functionality')]/parent::div/preceding-sibling::span[@aria-label='close']")))).click();
		WebElement EnterName = driver.findElement(By.id("nest-messages_user_Tname"));
		EnterName.sendKeys("Ken");
 		driver.findElement(By.id("nest-messages_user_Tphone")).sendKeys("1234567890");
 		driver.findElement(By.id("nest-messages_user_Tage")).sendKeys("27");
 		driver.findElement(By.id("nest-messages_user_TreferringPhysician")).sendKeys("ken");
 		List<WebElement> ee = driver.findElements(By.cssSelector(".ant-select-selection-search-input"));
		WebElement elem = ee.get(2);
 		elem.sendKeys("CT 3D");
		elem.sendKeys(Keys.ENTER);
		driver.findElement(By.id("nest-messages_user_clinical")).sendKeys("testing");
         try {
             driver.findElement(By.xpath("//span[contains(text(),'General Radiologist Pool')]")).click();
        } 
		catch (Exception e) {
             System.out.println("No General Radiologist Pool Button found");
        }
        driver.findElement(By.xpath("//button[contains(text(),'Send for Reporting')]")).click();
        		
 		try {
 			WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Clear All')]")));
 			System.out.println("Case Activated successfully");
 		}
		catch (Exception e) {
 			System.out.println("Failed to Activate case");
 		}
	}
		

	 @Test
      public void get_CaseId() throws Exception {
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Finish')]"))).click();

		
		try {
    		WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
    		shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']"))).click();
    	}
		catch (Exception e) {
             
					}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Orders')]"))).click();
    	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close-circle']"))).click();

		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Clear All')]"))).click();
		Thread.sleep(2000);
    	WebElement firstOrderIdElem = driver.findElement(By.xpath("(//tbody[contains(@class,'ant-table-tbody')]/tr[not(@aria-hidden=\"true\")]/td[1]//div[contains(@class,'ant-typography-single-line')])[1]"));

		String id = firstOrderIdElem.getText();
		File ff = new File("/Users/Kesav/Documents/caseid/id.txt");
		try {
			FileWriter FW = new FileWriter(ff);
			BufferedWriter BW = new BufferedWriter(FW);
			BW.write(id);
			BW.flush();
			BW.close();
			System.out.println("case id successfully written to the file.");
			System.out.println("Case id :" + id);
		} 
		catch (Exception e) {
			System.out.println("specified location is not exist");
		
		}
}
    

    @AfterMethod
    public void tearDown() {
     //   closeBrowser();
				}

	}
