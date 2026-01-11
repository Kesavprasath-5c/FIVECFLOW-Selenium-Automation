package com.Java_Logical_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FillForm {
    
    @Test
    public void form(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//label[contains(text(),'Name')]/following-sibling::input")).sendKeys("Ken");
        driver.findElement(By.xpath("//label[contains(text(),'Email')]/following-sibling::input")).sendKeys("Ken123@gmail.com");
        driver.findElement(By.xpath("//label[contains(text(),'Password')]/following-sibling::input")).sendKeys("Ken3007");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("26/12/1996");
        driver.findElement(By.xpath("//input[@type='submit']")).click();



       
    }
}
