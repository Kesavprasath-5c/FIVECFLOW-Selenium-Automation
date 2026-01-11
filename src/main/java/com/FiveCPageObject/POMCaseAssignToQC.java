package com.FiveCPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FiveCAbstaractComponent.AbstractComponent;

public class POMCaseAssignToQC extends AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;

    public POMCaseAssignToQC(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//a[@href='/qc/coordinator']")
    WebElement qcCoordinator;
    @FindBy(xpath = "//span[text()='QC Studies']")
    WebElement QCStudiesText;
    @FindBy(xpath = "//img[@alt='icon_search']")
    WebElement searchIcon;
    @FindBy(className = "mdc-text-field__input")
    WebElement orderIdInput;
    @FindBy(xpath = "//button[text()='Go']")
    WebElement clickGoButton;
    @FindBy(xpath = "//div[contains(@class,'PatientNameContainer')]//span[2]")
    WebElement caseidDisplayed;
    @FindBy(xpath = "//img[@alt='icon_chevron-bottom']")
    WebElement caseIdDropdown;
    @FindBy(xpath = "//span[text()='Kesav']")
    WebElement qcName;
    @FindBy(xpath = "//div[contains(@class,'coordinator__TableBodyRow')]//span[contains(text(),'ASSIGNED')]")
    WebElement assignedText;

    By logoutButtonBy = By.xpath("//span[text()='Logout']");
    By QCStudiesTextBy = By.xpath("//span[text()='QC Studies']");
    By orderIdInputBy = By.className("mdc-text-field__input");
    By clickGoButtonBy = By.xpath("//button[text()='Go']");
    By caseidDisplayedBy = By.xpath("(//div[contains(@class,'PatientNameContainer')])[1]//span");
    By caseIdDropdownBy = By.xpath("//img[@alt='icon_chevron-bottom']");
    By qcNameBy = By.xpath("//span[text()='Kesav']");
    By assignedTextBy = By.xpath("//div[contains(@class,'coordinator__TableBodyRow')]//span[contains(text(),'ASSIGNED')]");

    public Boolean logOutButtonIsDisplayed() {
        waitForWebElementToAppearBy(logoutButtonBy);
        return logoutButton.isDisplayed();
    }

    public void clickQcCoordinator() {

        qcCoordinator.click();
    }

    public Boolean QCStudiesTextIsDisplayed() {
        waitForWebElementToAppearBy(QCStudiesTextBy);
        return QCStudiesText.isDisplayed();
    }

    public void clickSearchIcon() {

        searchIcon.click();
    }

    public void searchInput(String orderId) {
        waitForWebElementToAppearBy(orderIdInputBy);
        orderIdInput.sendKeys(orderId);
    }

    public void clickGoButton() {
        waitForWebElementToAppearBy(clickGoButtonBy);
        clickGoButton.click();
    }

    public String getCaseIDText() {
        waitForWebElementToAppearBy(caseidDisplayedBy);
        return caseidDisplayed.getText();
    }
    public void caseIdDropdownClick() {
        waitForWebElementToAppearBy(caseIdDropdownBy);
        caseIdDropdown.click();
    }
    public void qcNameClick() {
        waitForWebElementToAppearBy(qcNameBy);
        qcName.click();
    }
    public Boolean assignedTextIsDisplayed() {
        waitForWebElementToAppearBy(assignedTextBy);
        return assignedText.isDisplayed();
    }   

}
