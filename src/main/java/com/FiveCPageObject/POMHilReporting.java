package com.FiveCPageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.FiveCAbstaractComponent.AbstractComponent;

public class POMHilReporting extends AbstractComponent{
    
    WebDriver driver;
    public  POMHilReporting(WebDriver driver){
    super(driver);
    this.driver= driver;
    PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//a[contains(@href,'/ai')]")
    WebElement aiCaseListPage;
    @FindBy(xpath = "//span[contains(text(),'AI Studies')]")
    WebElement aiStudiesText;
    @FindBy(xpath="//img[contains(@alt,'icon_search')]")
    WebElement clickSearchIcone;
    @FindBy(xpath = "//span[text()='Order Id']/ancestor::*[.//input][1]//input")
    WebElement OrderID_inputfield;
    @FindBy(xpath = "//button[contains(text(),'Go')]")
    WebElement GoButton;
    @FindBy(xpath = "//div[contains(@class,'PatientNameContainer')]//span[2]")
    WebElement OrderIdIsDisplayed;
    @FindBy(xpath = "//img[contains(@alt,'icon_case-view')]")
    WebElement viewTheCase;
    @FindBy(xpath = "//button[contains(text(),'Start Reporting')]")
    WebElement Start_Reporting;
    @FindBy(xpath = "//button[contains(text(),'Generate Report')]")
    WebElement clickGenerateReport;
    @FindBy(xpath = "//button[contains(text(),'Edit Report')]")
    WebElement editButton;
    @FindBy(xpath = "//span[contains(text(),'Observations')]")
    WebElement observationIsDisplayed;
    @FindBy(xpath = "//span[contains(text(),'Observations')]/ancestor::span/following-sibling::span")
    WebElement ObservationsEditor;
    @FindBy(xpath = "//button[contains(text(),'Save Report')]")
    WebElement clickSaveButton;
    @FindBy(xpath = "//button[contains(text(),'Reportable')]")
    WebElement clickReportableButton;
    @FindBy(xpath = "//span[contains(text(),'COMPLETED')]")
    WebElement status;


    By logoutButtonBy = By.xpath("//span[text()='Logout']");
    By byAiCaseListPage = By.xpath("//a[contains(@href,'/ai')]");
    By byAiStudyText = By.xpath("//span[contains(text(),'AI Studies')]");
    By byOrderID_inputfield = By.xpath("//span[text()='Order Id']/ancestor::*[.//input][1]//input");
    By byGoButton = By.xpath("//button[contains(text(),'Go')]");
    By byOrderIdIsDisplayed = By.xpath("//div[contains(@class,'PatientNameContainer')]//span[2]");
    By byStart_Reporting = By.xpath("//button[contains(text(),'Start Reporting')]");
    By byclickGenerateReport = By.xpath("//button[contains(text(),'Generate Report')]");
    // Match div that has "Elements__Section" in its text (or in a child) or in its class
    By byElementsSections = By.xpath("//div[contains(., 'Elements__Section') or contains(@class, 'Elements__Section')]");
    By byclickEditButton = By.xpath("//button[contains(text(),'Edit Report')]");
    By byobservationIsDisplayed = By.xpath("//span[contains(text(),'Observations')]");
    By byObservationsEditor = By.xpath("//span[contains(text(),'Observations')]/ancestor::span/following-sibling::span");
    By byclickSaveButton = By.xpath("//button[contains(text(),'Save Report')]");
    By byclickReportableButton =By.xpath("//button[contains(text(),'Reportable')]");
    By bystatus = By.xpath("//span[contains(text(),'COMPLETED')]");

    public Boolean logOutButtonIsDisplayed() {
        waitForWebElementToAppearBy(logoutButtonBy);
        return logoutButton.isDisplayed();
    }
    public void ClickAiCaseListPage(){
        waitForWebElementToAppearBy(byAiCaseListPage);
        aiCaseListPage.click();
    }
    public boolean AI_StudiesTextIsDispalyed(){
        waitForWebElementToAppearBy(byAiStudyText);
        return aiStudiesText.isDisplayed() ;
        
    }
    public void clickSearchButton(){
        clickSearchIcone.click();
    }
    public void enterTheOrderId(String orderID){
        waitForWebElementToAppearBy(byOrderID_inputfield);
        OrderID_inputfield.sendKeys(orderID);
    }
    public void clickGoButton(){
        waitForWebElementToAppearBy(byGoButton);
        GoButton.click();
        
    }
    public boolean orderIdIsDisplayed(){
    waitForWebElementToAppearBy(byOrderIdIsDisplayed);
     return  OrderIdIsDisplayed.isDisplayed();

    }
    public void viewTheCase(){
        viewTheCase.click();
    }
    public void clickStart_Reporting(){
    waitForWebElementToAppearBy(byStart_Reporting);
    Start_Reporting.click();

    }
    public void cliclGenerateReporting() {
        waitForWebElementToAppearBy(byclickGenerateReport);
        clickGenerateReport.click();
    }

    /**
     * PageFactory-style: get the following sibling of the 3rd Elements__Section that contains the given text.
     * Uses By locators and driver from this page object.
     */
    public boolean getThirdSectionSiblingContainingText(String text) {
        // Report may take time to render; wait up to 30 seconds for at least 3 sections
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(d -> {
            List<WebElement> sections = d.findElements(byElementsSections);
            return sections.size() >= 3 && sections.get(2).isDisplayed();
        });
        List<WebElement> listofSections = driver.findElements(byElementsSections);
        WebElement thirdSection = listofSections.get(2);
        return thirdSection.findElement(By.xpath("./following-sibling::*[contains(., '" + text + "')]")).isDisplayed();
    }
    
    public void clickEditButton(){
        waitForWebElementToAppearBy(byclickEditButton);
        editButton.click();
    }
    public boolean observationSectionIsDisplayed(){
        waitForWebElementToAppearBy(byobservationIsDisplayed);
        return observationIsDisplayed.isDisplayed();
    } 
    public void editObservationSection(String content) throws Exception {
        waitForWebElementToAppearBy(byObservationsEditor);
        ObservationsEditor.click();
        Thread.sleep(2000);
        ObservationsEditor.sendKeys(content);
        Thread.sleep(2000);
    }

    /** Returns the current text in the Observations editor (for assertion). */
    public String getObservationsEditorText() {
        waitForWebElementToAppearBy(byObservationsEditor);
        return ObservationsEditor.getText();
    }

    /**
     * Waits until the typed content appears in the editor (up to timeoutSeconds).
     * Use after editObservationSection to ensure content is loaded before asserting.
     */
    public boolean waitUntilEditorContentLoaded(String expectedContent, int timeoutSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(d -> {
                String editorText = d.findElement(byObservationsEditor).getText();
                return editorText != null && editorText.contains(expectedContent);
            });
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSaveButton(){
        waitForWebElementToAppearBy(byclickSaveButton);
        clickSaveButton.click();
    }
    public void clickReportableButton() {
        waitForWebElementToAppearBy(byclickReportableButton);
        clickReportableButton.click();
    }

    /**
     * Waits until the child window is closed (only one window handle left), then switches driver to that window.
     * Call this after clickReportableButton() since the child closes with a delay.
     */
    public void waitUntilChildWindowClosedAndSwitchToParent(int timeoutSeconds) {
        new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds)).until(d -> d.getWindowHandles().size() == 1);
        String parentHandle = driver.getWindowHandles().iterator().next();
        driver.switchTo().window(parentHandle);
    }

    public boolean statusIsCompleted() {
        waitForWebElementToAppearBy(bystatus);
        return status.isDisplayed();
    }
}
