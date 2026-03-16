package com.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class test1 {
    
    @Test
    public void e2e(){
        WebDriver driver = new ChromeDriver();
     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
     driver.get("https://www.amazon.in/");
     WebElement Searchbar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@name,'field-keywords')]")));
     Searchbar.click();
     Searchbar.sendKeys("OnePlus",Keys.ENTER);
     wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Add to cart')])[1]"))).click();
     wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-cart-count"))).click();
    }
}
