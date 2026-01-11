package com.FiveC_flow_Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class Demo {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    
    
    @Test
    public void  trail(){
       driver.get("https://e2e-qa-admin.5cnetwork.com/");
       driver.manage().window().maximize();
       driver.findElement(By.id("email")).sendKeys("kesavprasath@5cnetwork.com");
       driver.findElement(By.id("password")).sendKeys("Kesav@5C",Keys.ENTER);
       WebElement logOutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Logout')]")));
       if (logOutButton.isDisplayed()) {
        System.out.println("Login Passed");
        driver.findElement(By.xpath("//img[@alt='icon_cases-light']")).click();
        WebElement caseStudiesListText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Case Studies')]")));
        if (caseStudiesListText.isDisplayed()) {
            System.out.println("Case Studies Page is displayed");
           // Set < String > caseidDisplayed = (Set<String>) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'PatientNameContainer')]//span[2]")));
            List<WebElement> allText = driver.findElements(By.xpath("//div[contains(@class,'PatientNameContainer')]//span[2]"));
           for(WebElement text:allText){
            System.out.println("Case ID: " + text.getText());
            if(text.getText().equals("WE28TQUJHP")){
                System.out.println("Case ID matched");
                // Click the view button within the same table row as the matched case id
                WebElement viewButton = text.findElement(By.xpath("./ancestor::div[contains(@class,'qc__TableBodyRow')]//img[@alt='chevron-right-small-white']"));
                wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
                break;

            }
           }
           
        } else {
            System.out.println("Case Studies Page is not displayed");
        }   
       } else {
        System.out.println("Login Failed");
       }

    
    }
}
