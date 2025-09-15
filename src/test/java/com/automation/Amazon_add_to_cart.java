package com.automation;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Amazon_add_to_cart {
    
    @Test
    public void search_item() throws InterruptedException{
       
        WebDriver driver = new ChromeDriver();
    
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.redbus.in/");
        driver.manage().window().maximize();
        WebElement From = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='From']")));
        From.click();
        String FromPlace = "Bangalore";
        Thread.sleep(3000); 
        List <WebElement> places = driver.findElements(By.xpath("//div[@class='listHeader___90a8b7']"));
        for (WebElement webElement : places) {
        String cityname =  webElement.getText();
        if (cityname.equals(FromPlace)){
            webElement.click();
        }
        else{
       System.out.println("City Name you Searching for Does Not Exist");
        }

          
            
        }

       
       
        

        


    }
    
        
}
