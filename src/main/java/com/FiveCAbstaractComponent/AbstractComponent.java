package com.FiveCAbstaractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
    WebDriver driver;

    public AbstractComponent(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[@class='ant-message-notice-content']//span[text()='Logged in successfully' or text()='login failed !']")
    WebElement loginResultToast;
    @FindBy(xpath = "//div[contains(@class,'ant-message-notice-content')]//span[contains(text(),'Activated Successfully')]")
    WebElement caseActivationSuccessTost;
    @FindBy(xpath = "//span[contains(@class, 'anticon-loading') or @aria-label='loading']")
    WebElement loadingSpinner;

    public WebElement waitForWebElementToAppear(WebElement adminUserName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        return wait.until(ExpectedConditions.visibilityOf(adminUserName));
    }

    public void waitForWebElementToAppearBy(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForToastToDisappear(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement verifyLoginTostResult() {
        return waitForWebElementToAppear(loginResultToast);
    }

    public WebElement verifySuccessAppears() {
        return waitForWebElementToAppear(caseActivationSuccessTost);
    }

    public WebElement waitForLoaderToDisappear() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            shortWait.until(ExpectedConditions.visibilityOf(loadingSpinner));

            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
            longWait.until(ExpectedConditions.invisibilityOf(loadingSpinner));
            return loadingSpinner;
        } catch (Exception e) {
            // Loader appeared/disappeared too fast or wasn't found
            System.out.println("Loader not displayed or disappeared quickly");
            return loadingSpinner;

        }

    }


}
