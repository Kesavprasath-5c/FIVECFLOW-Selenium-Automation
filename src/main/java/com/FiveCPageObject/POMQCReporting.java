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

public class POMQCReporting extends AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    public POMQCReporting(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//img[@alt='icon_cases-light']")
    WebElement QCReportingPage;
    @FindBy(xpath = "//span[contains(text(),'Case Studies')]")
    WebElement caseStudiesText;
    @FindBy(xpath = "//div[contains(@class,'PatientNameContainer')]//span[2]")
    List<WebElement> caseIds;
    @FindBy(xpath = "//div[contains(@class,'qc__TableBodyRow')]//img[@alt='chevron-right-small-white']")
    WebElement viewcase;
    @FindBy(xpath = "//button[text()='Start Reporting']")
    WebElement startReportingButton;
    @FindBy(xpath = "//button[text()='Start Reporting >']")
    WebElement startReportingButton2;
    @FindBy(xpath = "//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span")
    WebElement protocol;
    @FindBy(xpath = "//img[@alt='icon_edit']")
    WebElement editIcon;
    @FindBy(xpath = "//img[@alt='icon_file-check']")
    WebElement saveButton;
    @FindBy(xpath = "//div[contains(@class,'Icon__IconContainer')]//img[@alt='icon_circle-check']")
    WebElement approveButton;
    @FindBy(xpath = "//button[contains(text(),'Accept Case')]")
    WebElement acceptCaseButton;
    @FindBy(xpath = "//button[contains(text(),'Submit & take break')]")
    WebElement submitButton;
    @FindBy(xpath ="//div[contains(@class,'Toastify__toast-body')]//span[text()='Report Edited Successfully']")
    WebElement reportEditedSuccessToast;
    @FindBy(xpath = "//div[contains(@class,'Toastify__toast-body')]//span[text()='Study accepted successfully']")
    WebElement StudyAcceptedSuccess;

    By logoutButtonBy = By.xpath("//span[text()='Logout']");
    By QCReportingPageBy = By.xpath("//img[@alt='icon_cases-light']");
    By caseStudiesBy = By.xpath("//span[contains(text(),'Case Studies')]");
    By caseIdsBy = By.xpath("//div[contains(@class,'PatientNameContainer')]//span[2]");
    By viewCaseBy = By.xpath("//img[@alt='chevron-right-small-white']");
    By startReportingButtonBy = By.xpath("//button[text()='Start Reporting']");
    By startReportingButton2By = By.xpath("//button[text()='Start Reporting >']");
    By protocolBy = By.xpath("//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span");
    By editIconBy = By.xpath("//img[@alt='icon_edit']");
    By approveButtonBy = By.xpath("//div[contains(@class,'Icon__IconContainer')]//img[@alt='icon_circle-check']");
    By acceptCaseButtonBy = By.xpath("//button[contains(text(),'Accept Case')]");
    By submitButtonBy = By.xpath("//button[contains(text(),'Submit & take break')]");
    By reportEditedSuccessToastBy = By.xpath("//div[contains(@class,'Toastify__toast-body')]//span[text()='Report Edited Successfully']");
    By StudyAcceptedSuccessBy = By.xpath("//div[contains(@class,'Toastify__toast-body')]//span[text()='Study accepted successfully']");

    public Boolean logOutButtonIsDisplayed() {
        waitForWebElementToAppearBy(logoutButtonBy);
        return logoutButton.isDisplayed();
    }

    public void ClieckQCReportingPage() {
        waitForWebElementToAppearBy(QCReportingPageBy);
        QCReportingPage.click();
    }

    public Boolean caseStudiesTextIsDisplayed() {
        waitForWebElementToAppearBy(caseStudiesBy);
        return caseStudiesText.isDisplayed();
    }

    public List<WebElement> listofcaseid() {
        waitForWebElementToAppearBy(caseIdsBy);
        return driver.findElements(caseIdsBy);

    }

    public void clickViewCase() {
        waitForWebElementToAppearBy(viewCaseBy);
        viewcase.click();
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

    public void clickEditIcon() {
        waitForWebElementToAppearBy(editIconBy);
        editIcon.click();
    }

    public void protocolSection(String content) throws Exception {
        waitForWebElementToAppearBy(protocolBy);
        Thread.sleep(1000);
        protocol.click();
        protocol.sendKeys(content);
    }

    public void clickSaveButton() {
        waitForLoaderToDisappear();
        saveButton.click();
    }

    public void clickApproveButton() {
        waitForWebElementToAppearBy(approveButtonBy);
        approveButton.click();
    }

    public void clickAcceptCaseButton() {
        waitForWebElementToAppearBy(acceptCaseButtonBy);
        acceptCaseButton.click();
    }

    public void clickSubmitButtonAndTakeBreak() {
        waitForWebElementToAppearBy(submitButtonBy);
        submitButton.click();
    }

    public void verifyReportEditedSuccessfully() {
        waitForWebElementToAppearBy(reportEditedSuccessToastBy);
        waitForToastToDisappear(reportEditedSuccessToast);
    }

    public String getStudyAcceptedToastText() {
        waitForWebElementToAppearBy(StudyAcceptedSuccessBy);
        return StudyAcceptedSuccess.getText();
    }

}
