package com.FiveCPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FiveCAbstaractComponent.AbstractComponent;

public class ClientFormFilling extends AbstractComponent {
    WebDriver driver;

    public ClientFormFilling(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Client Form Filling
    @FindBy(xpath = "//a[contains(text(),'Draft')]")
    WebElement draftClick;
    @FindBy(xpath = "//button[contains(text(),'Clear All')]")
    WebElement clearAll;
    @FindBy(xpath = "//tbody//tr[2]/td[last()]//div[contains(@class,'ant-space-item')][last()]")
    WebElement viewForm;
    @FindBy(xpath = "//div[contains(text(),'Merge Functionality')]/parent::div/preceding-sibling::span[@aria-label='close']")
    WebElement closeMerge;
    @FindBy(id = "nest-messages_user_Tname")
    WebElement name;
    @FindBy(id = "nest-messages_user_Tphone")
    WebElement phone;
    @FindBy(id = "nest-messages_user_Tage")
    WebElement age;
    @FindBy(id = "nest-messages_user_TreferringPhysician")
    WebElement referringPhysician;
    @FindBy(id = "nest-messages_user_clinical")
    WebElement history;
    @FindBy(xpath = "(//button[contains(text(),'Upload')])[2]")
    WebElement upload;
    @FindBy(xpath = "//span[contains(text(),'General Radiologist Pool')]")
    WebElement generalRadiologistPool;
    @FindBy(xpath = "//button[contains(text(),'Send for Reporting')]")
    WebElement sendForReporting;
    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    WebElement ordersPage;
    @FindBy(xpath="(//tbody[contains(@class,'ant-table-tbody')]/tr[not(@aria-hidden=\"true\")]/td[1]//div[contains(@class,'ant-typography-single-line')])[1]")
    WebElement caseid;

    //Assig case to Radiologist
    //This by locator is not supported by PageFactory
    //So by locator cannot be used in pageFactory
    

    By draftClickBy = By.xpath("//a[contains(text(),'Draft')]");
    By clearAllBy = By.xpath("//button[contains(text(),'Clear All')]");
    By viewFormBy = By.xpath("//tbody//tr[2]/td[last()]//div[contains(@class,'ant-space-item')][last()]");
    By closeMergeBy = By.xpath("//div[contains(text(),'Merge Functionality')]/parent::div/preceding-sibling::span[@aria-label='close']");
    By referringPhysicianBy = By.id("nest-messages_user_TreferringPhysician");
    By dropDownListBy = By.cssSelector(".ant-select-selection-search-input");
    By uploadBy = By.xpath("(//button[contains(text(),'Upload')])[2]");
    By generalRadiologistPoolBy = By.xpath("//span[contains(text(),'General Radiologist Pool')]");
    By sendForReportingBy = By.xpath("//button[contains(text(),'Send for Reporting')]");
    By ordersPageBy = By.xpath("//a[contains(text(),'Orders')]");
    By caseIdBy = By.xpath("(//tbody[contains(@class,'ant-table-tbody')]/tr[not(@aria-hidden=\"true\")]/td[1]//div[contains(@class,'ant-typography-single-line')])[1]");
   
    //Assig case to Radiologist

 

    public void draftClick() {
        waitForWebElementToAppearBy(draftClickBy);
        draftClick.click();
    }

    public void clearAll() {
        waitForWebElementToAppearBy(clearAllBy);
        clearAll.click();
    }

    public void viewForm() {
        waitForWebElementToAppearBy(viewFormBy);
        viewForm.click();
    }

    public void closeMerge() {
        waitForWebElementToAppearBy(closeMergeBy);
        closeMerge.click();
    }

    public void name() {
       
        name.sendKeys("ken");
    }

    public void phone() {
    
        phone.sendKeys("1234567890");
    }

    public void age() {
       
        age.sendKeys("27");
    }

    public void referringPhysician() {
      
        referringPhysician.sendKeys("ken");
    }

    public void upload() {
       waitForWebElementToAppearBy(uploadBy);
        upload.click();
    }

    public void history() {
       
        history.sendKeys("Testing");
    }

    public void generalRadiologistPool() {
        waitForWebElementToAppearBy(generalRadiologistPoolBy);
        generalRadiologistPool.click();
    }

    public void selectStudy() throws Exception {
        List<WebElement> dropdownElements = driver.findElements(dropDownListBy);
        WebElement studyDropdown = dropdownElements.get(2);
        studyDropdown.click();
        Thread.sleep(1000);
        studyDropdown.sendKeys("CT 3D");
        Thread.sleep(1000);
        studyDropdown.sendKeys(Keys.ENTER);
    }
    public void selectPreReadStudy() throws Exception {
        List<WebElement> dropdownElements = driver.findElements(dropDownListBy);
        WebElement studyDropdown = dropdownElements.get(2);
        studyDropdown.click();
        Thread.sleep(1000);
        studyDropdown.sendKeys("CT PNS");
        Thread.sleep(1000);
        studyDropdown.sendKeys(Keys.ENTER);
    }


    public void sendForReporting() {
        sendForReporting.click();
        waitForLoaderToDisappear();
    }
    public WebElement clickOrdersPage(){
        waitForWebElementToAppearBy(ordersPageBy);
        ordersPage.click();
        return ordersPage;
    }

    public String getCaseId(){
        waitForWebElementToAppearBy(caseIdBy);
        String orderId =caseid.getText();
        return orderId;
        
       
    }

}//Assig case to Radiologist
