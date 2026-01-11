package com.FiveCPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FiveCAbstaractComponent.AbstractComponent;


public class POMAdminLogInPage extends AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    public POMAdminLogInPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
         

    }

    @FindBy(id = "email")
    WebElement AdminUserName;
    @FindBy(id = "password")
    WebElement AdminPassword;

    By adminUserNameBy = By.id("email");

    public void GoToAdminApplication(String url) {
        driver.get(url);

    }

    public void AdminloginApplication(String email, String password) {

       waitForWebElementToAppearBy(adminUserNameBy); // Wait for elements to be visible before interacting
      AdminUserName.sendKeys(email);
      AdminPassword.sendKeys(password, Keys.ENTER);
      
    }
    

}
