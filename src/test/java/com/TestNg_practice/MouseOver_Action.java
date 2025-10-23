package com.TestNg_practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class MouseOver_Action {
    WebDriver driver;
 
    @Test
    public void mouseActions() throws Exception{
     
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");   
    driver = new ChromeDriver(options);
    driver.get("https://demo.guru99.com/test/link.html");
    driver.manage().window().maximize();
    Thread.sleep(2000);

    List<WebElement> links =  driver.findElements(By.tagName("a"));
    
    System.out.println("Size of the linke is : " +links.size());

    for (WebElement link : links) {
       String linkURL = link.getAttribute("href");
       URL url = new URL(linkURL);
       URLConnection urlconnect = url.openConnection();
       HttpURLConnection httpURLconnect = (HttpURLConnection)urlconnect;
       httpURLconnect.connect();


        
    }
    
    }
}
