package com.FiveCPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FiveCAbstaractComponent.AbstractComponent;

public class POMRadReporting extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public POMRadReporting(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Logout']")
    WebElement RadlogoutButton;
    @FindBy(xpath = "//img[@alt='icon_search']")
    WebElement searchIcon;
    @FindBy(className = "mdc-text-field__input")
    WebElement orderIdInput;
    @FindBy(xpath = "//button[text()='Go']")
    WebElement clickGoButton;
    @FindBy(xpath = "//div[contains(@class, 'TableBodyRow')]/div[2]/span")
    WebElement GetDisplaycaseId;
    @FindBy(xpath = "//img[@alt='icon_case-view']")
    WebElement caseViewIcon;
    @FindBy(xpath = "//button[text()='Start Reporting']")
    WebElement startReportingButton;
    @FindBy(xpath = "//button[text()='Start Reporting >']")
    WebElement startReportingButton2;
    @FindBy(xpath = "//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span")
    WebElement protocol;
    @FindBy(xpath = "//span[text()='Observations']/ancestor::span[3]/following-sibling::span")
    WebElement observations;
    @FindBy(xpath = "//span[text()='Saved']")
    WebElement saved;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement submitButton;
    @FindBy(xpath = "//button[contains(text(),'Submit & stop reporting')]")
    WebElement submitTakeBreak;
    @FindBy(id = "toggle--Completedlabel")
    WebElement completedCheckbox;
    @FindBy(xpath = "//img[@alt='icon_insert-image']")
    WebElement insertImageButton;
    @FindBy(xpath = "//span[text()='REPORTED']")
    WebElement reported;

    By logoutButtonBy = By.xpath("//span[text()='Logout']");
    By searchIconBy = By.xpath("//img[@alt='icon_search']");
    By orderIdInputBy = By.className("mdc-text-field__input");
    By clickGoButtonBy = By.xpath("//button[text()='Go']");
    By GetDisplaycaseIdBy = By.xpath("//div[contains(@class, 'TableBodyRow')]/div[2]/span");
    By caseViewIconBy = By.xpath("//img[@alt='icon_case-view']");
    By startReportingButtonBy = By.xpath("//button[text()='Start Reporting']");
    By startReportingButton2By = By.xpath("//button[text()='Start Reporting >']");
    By protocolBy = By.xpath("//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span");
    By observationsBy = By.xpath("//span[text()='Observations']/ancestor::span[3]/following-sibling::span");
    By savedBy = By.xpath("//span[text()='Saved']");
    By submitButtonBy = By.xpath("//button[text()='Submit']");
    By submitTakeBreakBy = By.xpath("//button[contains(text(),'Submit & stop reporting')]");
    By completedCheckboxBy = By.id("toggle--Completedlabel");
    By insertImageButtonBy = By.xpath("//img[@alt='icon_insert-image']");
    By reportedBy = By.xpath("//span[text()='REPORTED']");

    public Boolean isLogoutButtonDisplayed() {
        waitForWebElementToAppearBy(logoutButtonBy);
        return RadlogoutButton.isDisplayed();
    }

    public void clickSearchIcon() {
        waitForWebElementToAppearBy(searchIconBy);
        searchIcon.click();
    }

    public void orderIdInput(String orderId) {
        waitForWebElementToAppearBy(orderIdInputBy);
        orderIdInput.sendKeys(orderId);
    }

    public void clickGoButton() {
        waitForWebElementToAppearBy(clickGoButtonBy);
        clickGoButton.click();
    }

    public String GetcaseIdDisplayed() {
        waitForWebElementToAppearBy(GetDisplaycaseIdBy);
        return GetDisplaycaseId.getText();
    }

    public void clickCaseViewIcon() {
        waitForWebElementToAppearBy(caseViewIconBy);
        caseViewIcon.click();
    }

    public void switchToChildWindow() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> lst = new ArrayList<>(allWindows);
        driver.switchTo().window(lst.get(1));
    }

    public void clickStartReportingButton() {
        waitForWebElementToAppearBy(startReportingButtonBy);
        startReportingButton.click();
    }

    public void clickStartReportingButton2() {
        waitForWebElementToAppearBy(startReportingButton2By);
        startReportingButton2.click();
    }

    public void protocolSection(String content) throws Exception {
        waitForWebElementToAppearBy(protocolBy);
        Thread.sleep(1000);
        protocol.click();
        protocol.sendKeys(content);

    }

    public void observationsSection(String content) throws Exception {
        waitForWebElementToAppearBy(observationsBy);
        observations.click();
        Thread.sleep(1000);
        observations.sendKeys(content);
    }

    public Boolean savedtextDisplayed() {
        waitForWebElementToAppearBy(savedBy);
        return saved.isDisplayed();
    }

    public void clickSubmitButton() {

        waitForWebElementToAppearBy(submitButtonBy);
        submitButton.click();
        waitForLoaderToDisappear();
    }

    public void clickSubmitTakeBreakButton() {
        waitForWebElementToAppearBy(submitTakeBreakBy);
        submitTakeBreak.click();
        waitForLoaderToDisappear();
    }

    public void switchToParentWindow() {
        Set<String> allWindows = driver.getWindowHandles();
        List<String> lst = new ArrayList<>(allWindows);
        driver.switchTo().window(lst.get(0));
    }

    public void clickCompletedCheckbox() {
        waitForWebElementToAppearBy(completedCheckboxBy);
        completedCheckbox.click();
    }

    public void clickInsertImageButton() {
        waitForWebElementToAppearBy(insertImageButtonBy);
        insertImageButton.click();
    }

    public Boolean reportedtextDisplayed() {
        waitForWebElementToAppearBy(reportedBy);
        return reported.isDisplayed();
    }

}
