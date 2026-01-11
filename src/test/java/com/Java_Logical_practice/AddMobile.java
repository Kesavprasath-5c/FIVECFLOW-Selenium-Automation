package com.Java_Logical_practice;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class AddMobile {

    
    @Test
    public void login() throws InterruptedException{
    ChromeOptions options = new ChromeOptions();
options.addArguments("--disable-notifications");
options.addArguments("--disable-infobars");
options.addArguments("--disable-save-password-bubble");
options.addArguments("--disable-features=PasswordManagerOnboarding,PasswordManagerEnableMigration");

// Disable password manager and autofill entirely
java.util.Map<String, Object> prefs = new java.util.HashMap<>();
prefs.put("credentials_enable_service", false);
prefs.put("profile.password_manager_enabled", false);
prefs.put("password_manager_enabled", false);
prefs.put("profile.default_content_setting_values.notifications", 2);
prefs.put("profile.default_content_setting_values.autofill", 2);
prefs.put("autofill.profile_enabled", false);
prefs.put("autofill.credit_card_enabled", false);

options.setExperimentalOption("prefs", prefs);

     WebDriver driver = new ChromeDriver(options);

     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

     driver.get("https://rahulshettyacademy.com/loginpagePractise/");
     driver.manage().window().maximize();
     driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
     driver.findElement(By.id("password")).sendKeys("learning");
     driver.findElement(By.xpath("//span[contains(text(),' User')]")).click();
     wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn"))).click();
     driver.findElement(By.id("terms")).click();
     driver.findElement(By.id("signInBtn")).click();
     Thread.sleep(2000);
   
   

    }
}
