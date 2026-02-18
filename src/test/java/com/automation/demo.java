package com.automation;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class demo {

    @Test
    public void link() throws Exception {
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssert = new SoftAssert();
        driver.get("https://www.5cnetwork.com/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Accept')]"))).click();
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println(links.size());
        for (WebElement link : links) {
            String linkurl = link.getAttribute("href");
            
            if (!linkurl.startsWith("http")) {
                continue;
            }
            HttpURLConnection connection = (HttpURLConnection) new URI(linkurl).toURL().openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            if (connection.getResponseCode() >= 400)
                softAssert.assertTrue(connection.getResponseCode() >= 400, "The link text = " + link.getText()
                        + " and the response code is " + connection.getResponseCode() + " is broken");
        }
        softAssert.assertAll();
    }
}
