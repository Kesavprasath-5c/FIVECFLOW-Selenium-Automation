package com.Java_Logical_practice;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VegAddToCart {
    
    @Test
    public void addtocart() throws Exception{
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String [] veglist  = {"Cauliflower","Beans","Pumpkin"};
        driver.manage().window().maximize();
        Thread.sleep(3000);
           List<WebElement> vegCarts  = driver.findElements(By.className("product-name"));
           System.out.println(vegCarts.size());
           for(int i =0;i<vegCarts.size();i++){
          

            String[] namelist = vegCarts.get(i).getText().split("-");
               String vegname = namelist[0].trim();
              List ai = Arrays.asList(veglist);
              int j=0;
               if(ai.contains(vegname)){
                //driver.findElements(By.xpath("//div[text()='ADD TO CART']")).get(i).click();
                driver.findElements(By.className("product-action")).get(i).click();
                j++;
                if (j==3) {
                  break;
                }
               }
         

            }
           }

      
    }

