package com.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DataFile.Clinet_TestData;



public class ClientsPF {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeMethod

    public void clientLogin() {
        ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
        driver.get(com.DataFile.Clinet_TestData.url);  
        driver.manage().window().maximize();
        driver.findElement(By.id("basic_emailId")).sendKeys(Clinet_TestData.email);
		driver.findElement(By.id("basic_password")).sendKeys(Clinet_TestData.password, Keys.ENTER);
        try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),'Welcome, Jeevan Hospital')]")));
			System.out.println("Login Passed");
		}
		catch (Exception e) {
			System.out.println("Login failed");
			
		}
        }
 @Test
public void NormalCaseActivation() throws Exception{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
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
        //  try {
        //      driver.findElement(By.xpath("//span[contains(text(),'General Radiologist Pool')]")).click();
        // } 
		// catch (Exception e) {
        //      System.out.println("No General Radiologist Pool Button found");
        // }
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
        
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Finish')]"))).click();
		//done.
		
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

				}
