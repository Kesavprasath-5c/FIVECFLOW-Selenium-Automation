package com.FiveCPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FiveCAbstaractComponent.AbstractComponent;

public class POMRadLoginPage extends AbstractComponent {
WebDriver driver;

    public POMRadLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }



    @FindBy(id = "email")
    WebElement RadUserName;
    @FindBy(id = "password")
    WebElement RadPassword;
 
    By radUserNameBy = By.id("email");

public void GotToRadApplication(String url){
    driver.get(url);
}

public void RadloginApplication(String email, String passwords){
    waitForWebElementToAppearBy(radUserNameBy);
    RadUserName.sendKeys(email);
    RadPassword.sendKeys(passwords,Keys.ENTER);
}

}
