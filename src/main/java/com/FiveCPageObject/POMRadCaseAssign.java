package com.FiveCPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FiveCAbstaractComponent.AbstractComponent;

public class POMRadCaseAssign extends AbstractComponent {

    WebDriver driver;
    WebDriverWait wait;

    public POMRadCaseAssign(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//img[@alt='icon_cases-light']")
    WebElement caseButton;
    @FindBy(xpath = "//img[@alt='icon_search']")
    WebElement searchButton;
    @FindBy(xpath = "//span[text()='Order Id']/preceding-sibling::input[1]")
    WebElement orderIdInput;
    @FindBy(xpath = "//button[text()='Go']")
    WebElement clickGoButton;
    @FindBy(xpath = "(//div[contains(@class, 'cases__TableBodyCell')])[1]//span")
    WebElement caseId;
    @FindBy(xpath = "//img[@alt='icon_chevron-bottom']")
    WebElement caseIdDropdown;
    @FindBy(xpath = "//span[text()='Dr. Irad 1  (1722)']")
    WebElement radName;
    @FindBy(xpath = "//button[contains(text(),'assign anyway')]")
    WebElement assignAnywayButton;
    @FindBy(xpath = "//div[contains(@class,'Toastify__toast-body')]//span[contains(text(),'Radiologist updated successfully')]")
    WebElement radiologistUpdatedToast;
    @FindBy(xpath = "//span[contains(text(),'Dr. Irad 1')]")
    WebElement radNameDisplayed;
   

    By logOutButtonBy = By.xpath("//span[text()='Logout']");
    By caseButtonBy = By.xpath("//img[@alt='icon_cases-light']");
    By searchButtonBy = By.xpath("//img[@alt='icon_search']");
    By orderIdInputBy = By.xpath("//span[text()='Order Id']/preceding-sibling::input[1]");
    By clickGoButtonBy = By.xpath("//button[text()='Go']");
    By caseIdBy = By.xpath("(//div[contains(@class, 'cases__TableBodyCell')])[1]//span");
    By caseIdDropdownBy = By.xpath("//img[@alt='icon_chevron-bottom']");
    By radNameBy = By.xpath("//span[text()='Dr. Irad 1  (1722)']");
    By assignAnywayButtonBy = By.xpath("//button[contains(text(),'assign anyway')]");
    By radiologistUpdatedToastBy = By.xpath("//div[contains(@class,'Toastify__toast-body')]//span[contains(text(),'Radiologist updated successfully')]");
    By radNameDisplayedBy = By.xpath("//span[contains(text(),'Dr. Irad 1')]");

    public boolean logOutTextIsDisplayed() {
        waitForWebElementToAppearBy(logOutButtonBy);
        return logoutButton.isDisplayed();

    }

    public void caseButtonClick() {
        waitForWebElementToAppearBy(caseButtonBy);
        caseButton.click();
    }

    public void searchButtonClick() {
        waitForWebElementToAppearBy(searchButtonBy);
        searchButton.click();
    }

    public void orderIdInput(String orderId) {
        waitForWebElementToAppearBy(orderIdInputBy);
        orderIdInput.sendKeys(orderId);
    }

    public void clickGoButtonClick() {
        waitForWebElementToAppearBy(clickGoButtonBy);
        clickGoButton.click();
    }

    public String caseIdDisplayed() {
        waitForWebElementToAppearBy(caseIdBy);
        return caseId.getText();
    }

    public void caseIdDropdownClick() {
        waitForWebElementToAppearBy(caseIdDropdownBy);
        caseIdDropdown.click();
    }

    public void radNameClick() {
        waitForWebElementToAppearBy(radNameBy);
        radName.click();
    }

    public void assignAnywayButtonClick() {
        waitForWebElementToAppearBy(assignAnywayButtonBy);
        assignAnywayButton.click();
    }
    public void waitForRadiologistUpdatedToast() {
        waitForWebElementToAppearBy(radiologistUpdatedToastBy);
        waitForToastToDisappear(radiologistUpdatedToast);
    }

    public String getToastMessage() {
        waitForWebElementToAppearBy(radiologistUpdatedToastBy);
        return radiologistUpdatedToast.getText();
    }
    public Boolean getRadNameDisplayed() {
        waitForWebElementToAppearBy(radNameDisplayedBy);
        return radNameDisplayed.isDisplayed();
    }

}
