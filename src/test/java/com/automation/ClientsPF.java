package com.automation;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;





@Listeners ({ItestListenersClass.class})
public class ClientsPF extends BaseClass{
   

   @BeforeMethod
    public void clientLogin() throws Exception {
        LaunchBrowser();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.get(com.automation.DataFile.Clinet_TestData.url); 
		driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.SECONDS);
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_emailId")));
		username.sendKeys(com.automation.DataFile.Clinet_TestData.email);
		//com.DataFile.Clinet_TestData.email
        WebElement userpassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("basic_password")));
		userpassword.sendKeys(com.automation.DataFile.Clinet_TestData.password, Keys.ENTER);
       
			WebElement confirm_text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Finish')]")));
			if(confirm_text.isDisplayed()){
				System.out.println("Login Passed");
			}
		    
		   else {
			System.out.println("Login failed");
			
		}
		  
        }

		
    @Test 
    public void NormalCaseActivation()throws Exception{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
    	try {

    		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']"))).click();
    	}
		catch (Exception e) {
             System.out.println("Pop are all handled");
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
		WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
        uploadInput.sendKeys("/Users/Kesav/Desktop/automation-projects/FIVECFLOW-Selenium-Automation/src/test/resources/UploadFile/screenshot.png");
		Thread.sleep(3000);
		WebElement uploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[contains(text(),'Upload')])[2]")));
        uploadButton.click();
         try { 
			WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'General Radiologist Pool')]"))).click();
        } 
		catch (Exception e) {
             System.out.println("No General Radiologist Pool Button found");
        }
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Send for Reporting')]"))).click();

		// Most efficient locator for toast message validation
		By toastLocator = By.xpath("//div[contains(@class,'ant-message-notice-content')]//span[contains(text(),'Cases Activated Successfully')]");
		WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		
		if(toastMessage.isDisplayed()) {
			System.out.println("Case Activated successfully - Toast validated");
			System.out.println("Toast message: " + toastMessage.getText());
		}
		else {
			System.out.println("Failed to Activate case - Toast not displayed");
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
     
    @Test
    public void qr_verification() throws Exception{
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Finish')]"))).click();
	WebElement action = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button' and contains(@class,'ant-btn')])[1]")));
     Actions ac = new Actions(driver);
	 ac.moveToElement(action).click(). perform();
	 Thread.sleep(1000);
	 WebElement tooltipText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Mobile App Login QR']")));
     if (tooltipText.isDisplayed()) {
            System.out.println("✅ Tooltip is displayed after hover: " + tooltipText.getText());
        } else {
            System.out.println("❌ Tooltip is NOT displayed after hover.");
        }
	}

    @AfterMethod
    public void tearDown() {
       closeBrowser();
				}

	}
