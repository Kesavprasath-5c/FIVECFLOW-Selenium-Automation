package com.Java_Logical_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WindowHandel {
    
    @Test
    public void windows(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> window    = driver.getWindowHandles();
        List<String> windowlist = new ArrayList<>(window);
        driver.switchTo().window(windowlist.get(1));
     String text1 = driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText();
        System.out.println(text1);
        driver.switchTo().window(windowlist.get(0));
        String text2 = driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText();
        System.out.println(text2);

        
       // driver.switchTo().window(null);
    }
}
