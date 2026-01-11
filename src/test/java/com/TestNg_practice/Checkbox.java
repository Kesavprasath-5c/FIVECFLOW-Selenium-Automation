package com.TestNg_practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Checkbox {
    
    @Test
public void checkboxselect(){
  WebDriver driver = new ChromeDriver();
  driver.get("https://rahulshettyacademy.com/AutomationPractice/");
  driver.manage().window().maximize();
   List<WebElement> checkboxlist =   driver.findElements(By.xpath("//input[@type='checkbox']"));
   System.out.println(checkboxlist.size());
  
}
}
