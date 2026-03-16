package com.FiveCPageObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    @FindBy(xpath = "//button[contains(text(),'Edit Report')]")
    WebElement ClickEditRepor;
    @FindBy(xpath = "//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span")
    WebElement protocol;
    @FindBy(xpath = "//span[contains(text(),'Observations')]/ancestor::span[3]/following-sibling::span")
    WebElement observations;
    @FindBy(xpath = "//button[contains(text(),'Switch to editor')]")
    WebElement editIcon;
    @FindBy(xpath = "//img[@alt='icon_insert-image']")
    WebElement insertImageButton;
    @FindBy(xpath = "//label[contains(text(),'Take break after this case')]")
    WebElement takeBreakCheckBox;
    @FindBy(xpath = "//span[contains(text(),'Saved')]")
    WebElement saveTextisDisplayed;
    @FindBy(xpath = "//img[@alt='icon_file-check']")
    WebElement saveButton;
    @FindBy(xpath = "//div[contains(@class,'Icon__IconContainer')]//img[@alt='icon_circle-check']")
    WebElement approveButton;
    @FindBy(xpath = "//button[contains(text(),'Accept Case')]")
    WebElement acceptCaseButton;
    @FindBy(xpath = "//button[contains(text(),'Submit & take break')]")
    WebElement submitButton;
    @FindBy(xpath = "//div[contains(@class,'Toastify__toast-body')]//span[text()='Report Edited Successfully']")
    WebElement reportEditedSuccessToast;
    @FindBy(xpath = "//div[contains(@class,'Toastify__toast-body')]//span[text()='Study accepted successfully']")
    WebElement StudyAcceptedSuccess;
    @FindBy(xpath = "//button[text()='Reportable']")
    WebElement reportable;
    @FindBy(xpath = "//button[text()='Save Report']")
    WebElement repSave;
    @FindBy(xpath = "//div[contains(@class,'Toastify__toast-body')]//*[text()='Marked as Reportable']")
    WebElement markedAsReportableToast;
    @FindBy(xpath = "//button[contains(text(),'continue without merging')]")
    WebElement continueWithoutMerging;

    By logoutButtonBy = By.xpath("//span[text()='Logout']");
    By QCReportingPageBy = By.xpath("//img[@alt='icon_cases-light']");
    By caseStudiesBy = By.xpath("//span[contains(text(),'Case Studies')]");
    By caseIdsBy = By.xpath("//div[contains(@class,'PatientNameContainer')]//span[2]");
    By viewCaseBy = By.xpath("//img[@alt='chevron-right-small-white']");
    By startReportingButtonBy = By.xpath("//button[text()='Start Reporting']");
    By startReportingButton2By = By.xpath("//button[text()='Start Reporting >']");
    By ClickEditReport = By.xpath("//button[contains(text(),'Edit Report')]");
    By takeBreakCheckBoxBy = By.xpath("//label[contains(text(),'Take break after this case')]");
    By protocolBy = By.xpath("//span[contains(text(),'Protocol')]/ancestor::span/following-sibling::span");
    By observationsBy = By.xpath("//span[contains(text(),'Observations')]/ancestor::span[3]/following-sibling::span");
    By insertImageButtonBy = By.xpath("//img[@alt='icon_insert-image']");
    By saveTextisDisplayedBy = By.xpath("//span[contains(text(),'Saved')]");
    By editIconBy = By.xpath("//button[contains(text(),'Switch to editor')]");
    By approveButtonBy = By.xpath("//div[contains(@class,'Icon__IconContainer')]//img[@alt='icon_circle-check']");
    By acceptCaseButtonBy = By.xpath("//button[contains(text(),'Accept Case')]");
    By submitButtonBy = By.xpath("//button[contains(text(),'Submit & take break')]");
    By reportEditedSuccessToastBy = By
            .xpath("//div[contains(@class,'Toastify__toast-body')]//span[text()='Report Edited Successfully']");
    By StudyAcceptedSuccessBy = By
            .xpath("//div[contains(@class,'Toastify__toast-body')]//span[text()='Study accepted successfully']");
    By reportableBy = By.xpath("//button[text()='Reportable']");
    By markedAsReportableToastBy = By
            .xpath("//div[contains(@class,'Toastify__toast-body')]//*[text()='Marked as Reportable']");
    By continueWithoutMergingBy = By.xpath("//button[contains(text(),'continue without merging')]");

    //preRead - Save Report button (use exact text; if UI uses "Save" only, change to contains(text(),'Save'))
    By repsaveButtonby = By.xpath("//button[text()='Save Report']");

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
   public void clickEditReport(){
    waitForWebElementToAppearBy(ClickEditReport);
    ClickEditRepor.click();
    
   }
    public void clickTkeBreakCheckBox() {
        waitForWebElementToAppearBy(takeBreakCheckBoxBy);
        takeBreakCheckBox.click();
    }

    public void protocolSection(String content) throws Exception {
        waitForWebElementToAppearBy(protocolBy);
        try {
            protocol.click();
        } catch (Exception e) {
            clickWithJS(protocol);
        }
        protocol.sendKeys(content);
    }

    public void observationsSection(String content) throws Exception {
        waitForWebElementToAppearBy(observationsBy);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", observations);
        Thread.sleep(1000);
        try {
            observations.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].click();", observations);
        }
        observations.sendKeys(content);
    }

    public Boolean saveTextIsDisplayed() {
        waitForWebElementToAppearBy(saveTextisDisplayedBy);
        return saveTextisDisplayed.isDisplayed();
    }

    public void clickSaveButton() {
        waitForLoaderToDisappear();
        try {
            saveButton.click();
        } catch (Exception e) {
            clickWithJS(saveButton);
        }
    }

    public void clickApproveButton() {
        waitForWebElementToAppearBy(approveButtonBy);
        try {
            approveButton.click();
        } catch (Exception e) {
            clickWithJS(approveButton);
        }
    }

    public void clickAcceptCaseButton() {
        waitForWebElementToAppearBy(acceptCaseButtonBy);
        try {
            acceptCaseButton.click();
        } catch (Exception e) {
            clickWithJS(acceptCaseButton);
        }
    }

    public void clickSubmitButtonAndTakeBreak() {
        waitForWebElementToAppearBy(submitButtonBy);
        try {
            submitButton.click();
        } catch (Exception e) {
            clickWithJS(submitButton);
        }
    }

    public void verifyReportEditedSuccessfully() {
        waitForWebElementToAppearBy(reportEditedSuccessToastBy);
        waitForToastToDisappear(reportEditedSuccessToast);
    }

    public String getStudyAcceptedToastText() {
        waitForWebElementToAppearBy(StudyAcceptedSuccessBy);
        return StudyAcceptedSuccess.getText();
    }

    public void clickReportableButton() {
        waitForWebElementToAppearBy(reportableBy);
        try {
            reportable.click();
        } catch (Exception e) {
            clickWithJS(reportable);
        }
    }

    public void clickContinueWithoutMergingIfVisible() {
        try {
            waitForWebElementToAppearBy(continueWithoutMergingBy);
            continueWithoutMerging.click();
            System.out.println("Handled optional 'Continue without merging' popup.");
        } catch (Exception e) {
            System.out.println("'Continue without merging' popup not displayed. Skipping.");
        }
    }

    public void clickInsertImageButton() {
        waitForWebElementToAppearBy(insertImageButtonBy);
        try {
            insertImageButton.click();
        } catch (Exception e) {
            clickWithJS(insertImageButton);
        }
    }

    public String getMarkedAsReportableToastText() {
        waitForWebElementToAppearBy(markedAsReportableToastBy);
        return markedAsReportableToast.getText();
    }

    //preRead
    public void clickSaveReport(){
        waitForWebElementToAppearBy(repsaveButtonby);
        WebElement saveBtn = driver.findElement(repsaveButtonby);
        try {
            saveBtn.click();
        } catch (Exception e) {
            clickWithJS(saveBtn);
        }
    }
}
