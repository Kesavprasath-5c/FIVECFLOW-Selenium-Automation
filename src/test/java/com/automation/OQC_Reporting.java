package com.automation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.DataFile.QC_TestData;

public class OQC_Reporting {

WebDriver driver ;
WebDriverWait wait;
@BeforeTest
public void oqc_Login()
{
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get(DataFile.QC_TestData.url);
    driver.findElement(By.id("email")).sendKeys(QC_TestData.email);
    driver.findElement(By.id("password")).sendKeys(QC_TestData.password, Keys.ENTER);

}
    
    @Test
    public void OQC_Submit() throws Exception{

        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        File fi = new File("/Users/Kesav/Documents/caseid/id.txt");
    	FileReader FR = new FileReader(fi);
		BufferedReader BR = new BufferedReader(FR);
		String caseid =BR.readLine();
        System.out.println(caseid);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='icon_expand-sidebar-small']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='QC Case List']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + caseid + "']//following::img[contains(@alt,'chevron-right-small-white')]"))).click();
        Set<String> handles  = driver.getWindowHandles();
        System.out.println(handles);
        List<String> handel = new ArrayList<String>(handles);
        driver.switchTo().window(handel.get(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Start Reporting >']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt= \"icon_edit\"]"))).click();
        WebElement textConfirm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Observations']")));
        if(textConfirm.isDisplayed()){
        WebElement Protocol = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span")));
        Protocol.click();
        Protocol.sendKeys("normal####");
        
        Thread.sleep(1000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='icon_file-check']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='icon_circle-check']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Accept Case')]"))).click();
            
        }
        else{
            System.err.println("not dispayed");
        }







    }
}
