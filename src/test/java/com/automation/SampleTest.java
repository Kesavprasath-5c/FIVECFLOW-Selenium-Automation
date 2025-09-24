package com.automation;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTest {
    @Test
    public void testLaunch() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println("Title: " + driver.getTitle());
        driver.manage().window().maximize();
        
        driver.quit();
    }
}
