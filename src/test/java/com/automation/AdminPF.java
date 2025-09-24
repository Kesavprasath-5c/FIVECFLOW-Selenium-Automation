package com.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DataFile.Admin_TestData;

public class AdminPF {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased timeout
    }

    @BeforeMethod
    public void adminLogin() throws Exception {
        driver.get(Admin_TestData.Admin_url);
        driver.manage().window().maximize();

        WebElement Email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        Email.clear();
        Email.sendKeys(Admin_TestData.Admin_email);

        WebElement Password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        Password.clear();
        Password.sendKeys(Admin_TestData.Admin_password, Keys.ENTER);

        WebElement logoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Logout')]")));
        if (!logoutBtn.isDisplayed()) {
            throw new Exception("Login failed: Logout button not visible.");
        }
        System.out.println(" Admin Login Passed");
    }

    @Test
    public void Rad_case_Assignment() throws Exception {
	    wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Logout']")));
		driver.findElement(By.xpath("(//span[text()='Case Studies'])[position()=1]")).click();
		WebElement casestudies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Case Studies']")));
		if(casestudies.isDisplayed()) {
		WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='icon_search']")));
		search.click();
		Thread.sleep(1000);
		File fi = new File("/Users/Kesav/Documents/caseid/id.txt");
    	FileReader FR = new FileReader(fi);
		BufferedReader BR = new BufferedReader(FR);
		String caseid =BR.readLine();
		driver.findElement(By.xpath("//span[text()='Order Id']/preceding-sibling::input[1]")).sendKeys(caseid);
		driver.findElement(By.xpath("//button[text()='Go']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@alt='icon_chevron-bottom']")).click();
		try {
		driver.switchTo().activeElement().sendKeys("irad");
        
        System.out.println("case asssiged successfully");
		}
		catch (Exception e) {
			System.out.println("The rad you are looking for in the list is not present.");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Dr. Irad 1  (1722)']")).click();
	    try {
   	    	driver.findElement(By.xpath("//button[contains(text(),'assign anyway')]")).click();
	    	Thread.sleep(2000);	
	  
	    }
	    catch(Exception e) {
	    	  	 
	   }
		}
		else {
			System.out.println("case study page is not dispalyed");
		}
    }
	@Test
   public void OQC_Case_Assignment() throws Exception{
      WebElement logout =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Logout']")));
      if(logout.isDisplayed()){
		System.out.println("Admin Login Success");
		 WebElement QcCoordinator= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/qc/coordinator')]")));
		 QcCoordinator.click();
        WebElement QcStudies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='QC Studies']")));
		if(QcStudies.isDisplayed()){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='icon_search']"))).click();

			File fi = new File("/Users/Kesav/Documents/caseid/id.txt");
		 	FileReader FR = new FileReader(fi);
		 	BufferedReader BR = new BufferedReader(FR);
    	 	String caseid =BR.readLine();
		 	System.out.println(caseid);
		 	Thread.sleep(1000);
			driver.findElement(By.xpath("//span[text()='Order Id']/preceding-sibling::input[1]")).sendKeys(caseid);
			driver.findElement(By.xpath("//button[text()='Go']")).click();
			WebElement eles = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='icon_chevron-bottom']")));
		    eles.click();
			driver.switchTo().activeElement().sendKeys("kesav");
			WebElement qcname = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Kesav']")));
		    qcname.click();
			WebElement status = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[contains(text(),'ASSIGNED')])[last()]")));
			
			if(status.isDisplayed()){
				System.out.println("case assigned to qc successfully");
			}
			else {
				System.out.println("QA Agent Searchin for is not Avaliable");
			}

		}
	    else {
			System.out.println("QcStudies page is not dispalyed");

		}
		
		
		
		
		
		}
	  else{
		System.out.println("Admin Login Failed");
	  
	  }

   }
	
}
