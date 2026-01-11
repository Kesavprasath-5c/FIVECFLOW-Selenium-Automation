package com.FiveCPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FiveCAbstaractComponent.AbstractComponent;



public class POMClientLoginPage extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public POMClientLoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "basic_emailId")
    WebElement ClientEmailId;

    @FindBy(id = "basic_password")
    WebElement ClientPassword;

    
   By clientEmailIdBy = By.id("basic_emailId");

    public void GoToClientApplication(String clientUrl) {
        driver.get(clientUrl);
    }

    public void ClientloginApplication(String clientUserName, String clientPassword) {
        // Wait for elements to be visible before interacting with the elements
        waitForWebElementToAppearBy(clientEmailIdBy);
        ClientEmailId.sendKeys(clientUserName);
        ClientPassword.sendKeys(clientPassword,Keys.ENTER);
        
      
       
    }

 



}
