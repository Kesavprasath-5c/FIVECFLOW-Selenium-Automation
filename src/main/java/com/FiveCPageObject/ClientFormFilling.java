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
    @FindBy(xpath = "//div[contains(text(),'Payment Overdue')]")
    WebElement paymentPopupHeader;
    @FindBy(xpath ="//button[contains(@class,'ant-modal-close')]")
    WebElement closeThePaymentPopUp;
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
    @FindBy(xpath = "//input[@type='file']")
    WebElement uploads;
    @FindBy(xpath = "//button[contains(@class,'ant-btn-dangerou')]//following-sibling::button")
    WebElement confirmUploadButton;
    @FindBy(xpath = "(//span[contains(@class,'ant-select-selection-placeholder')])[2]")
    WebElement selectStudy;
    @FindBy(css = ".anticon.anticon-close-circle")
    WebElement auraCloseButton;
    @FindBy(xpath = "//span[contains(text(),'Left')]")
    WebElement left;
    @FindBy(xpath="//span[contains(text(),'LAT')]")
    WebElement LAT;
    @FindBy(id = "nest-messages_user_clinical")
    WebElement history;
   
    @FindBy(xpath = "//span[contains(text(),'General Radiologist Pool')]")
    WebElement generalRadiologistPool;
    @FindBy(xpath = "//button[contains(text(),'Send for Reporting')]")
    WebElement sendForReporting;
    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    WebElement ordersPage;
    @FindBy(xpath = "(//tbody[contains(@class,'ant-table-tbody')]/tr[not(@aria-hidden='true')]/td[1]//div[contains(@class,'ant-typography-single-line')])[1]")
    WebElement caseid;

    //globalIradLocators
    @FindBy(xpath = "//input[contains(@placeholder,'Search by Order ID')]")
    WebElement searchfeild;
    @FindBy(xpath = "(//tr[contains(@class,'ant-table-row')]/td[4]//button)[1]")
    WebElement dropDown;
    @FindBy(xpath = "//input[contains(@placeholder,'Search Radiologist')]")
    WebElement radSearchFeild;
    @FindBy(xpath = "//div[contains(text(),'Dr. Irad 2')]")
    WebElement selectIrad;
    @FindBy(xpath = "//div[contains(text(),'Irad 2 ')]")
    WebElement radname;
    
   


    By paymentPopupHeaderby = By.xpath("//div[contains(text(),'Payment Overdue')]");
    By draftClickBy = By.xpath("//a[contains(text(),'Draft')]");
    By clearAllBy = By.xpath("//button[contains(text(),'Clear All')]");
    By viewFormBy = By.xpath("//tbody//tr[2]/td[last()]//div[contains(@class,'ant-space-item')][last()]");
    By closeMergeBy = By.xpath(
            "//div[contains(text(),'Merge Functionality')]/parent::div/preceding-sibling::span[@aria-label='close']");
    By referringPhysicianBy = By.id("nest-messages_user_TreferringPhysician");
    By dropDownListBy = By.cssSelector(".ant-select-selection-search-input");
    By uploadBy = By.xpath("//input[@type='file']");
    By confirmUploadButtonby = By.xpath("//button[contains(@class,'ant-btn-dangerou')]//following-sibling::button");
    By generalRadiologistPoolBy = By.xpath("//span[contains(text(),'General Radiologist Pool')]");
    By sendForReportingBy = By.xpath("//button[contains(text(),'Send for Reporting')]");
    By ordersPageBy = By.xpath("//a[contains(text(),'Orders')]");
    By caseIdBy = By.xpath(
            "(//tbody[contains(@class,'ant-table-tbody')]/tr[not(@aria-hidden='true')]/td[1]//div[contains(@class,'ant-typography-single-line')])[1]");
    
   //globalIradLocators
    By bysearchfeild = By.xpath("//input[contains(@placeholder,'Search by Order ID')]");
    By bydropDown = By.xpath("(//tr[contains(@class,'ant-table-row')]/td[4]//button)[1]");
    By byradSearchFeild = By.xpath("//input[contains(@placeholder,'Search Radiologist')]");
    By bySelecIrad = By.xpath("//div[contains(text(),'Dr. Irad 2')]");
    By byradName = By.xpath("//div[contains(text(),'Irad 2 ')]");
    
    


    public void dismissPaymentPopupIfPresent() {
        try {
          waitForWebElementToAppearBy(paymentPopupHeaderby);
           
    
            // Try normal click first, then JS fallback
            try {
                closeThePaymentPopUp.click();
            } catch (Exception e) {
                clickWithJS(closeThePaymentPopUp);
            }
    
            System.out.println("Payment popup dismissed");
        } catch (org.openqa.selenium.TimeoutException e) {
            // Popup did not appear – ignore and continue
        }
    }

    public void draftClick() {
        waitForWebElementToAppearBy(draftClickBy);
        draftClick.click();
    }

    public void clearAll() {
        waitForWebElementToAppearBy(clearAllBy);
        waitForElementToBeClickable(clearAllBy);
        try {
            clearAll.click();
        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
            clickWithJS(clearAll);
        }
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

    public void upload() throws Exception {
        waitForWebElementToAppearBy(uploadBy);
        
            //uploads.click();
        uploads.sendKeys(System.getProperty("user.dir") + "//src//test//resources//UploadFile//screenshot.png");
        Thread.sleep(2000);
        
    }
    
    public void clickUploadConfirmButton(){
        waitForWebElementToAppearBy(confirmUploadButtonby);
        confirmUploadButton.click();
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
    public void AuraButtonClose(){
        auraCloseButton.click();
    }

    public void selectHilStudy() throws Exception{
        List<WebElement> dropdownElements = driver.findElements(dropDownListBy);
        WebElement studyDropdown = dropdownElements.get(2);
        studyDropdown.click();
        Thread.sleep(1000);
        studyDropdown.sendKeys("XRAY Radiograph Arm");
        Thread.sleep(1000);
        studyDropdown.sendKeys(Keys.ENTER);
        left.click();
        LAT.click();
           }
     public void selectIradStudy() throws InterruptedException{
        List<WebElement> dropdownElements = driver.findElements(dropDownListBy);
        WebElement studyDropdown = dropdownElements.get(2);
        studyDropdown.click();
        Thread.sleep(1000);
        studyDropdown.sendKeys("Peru CT3D");
        Thread.sleep(1000);
        studyDropdown.sendKeys(Keys.ENTER);

     }      

           
    public void sendForReporting() {
        sendForReporting.click();
        waitForLoaderToDisappear();
    }

    public WebElement clickOrdersPage() {
        waitForWebElementToAppearBy(ordersPageBy);
        ordersPage.click();
        return ordersPage;
    }

    public String getCaseId() {
        waitForWebElementToAppearBy(caseIdBy);
        String orderId = caseid.getText();
        return orderId;

    }

    /** Search by dynamic order ID (e.g. from getCaseId() or OrderIdFileUtil). */
    public void searchCaseId(String orderId) {
        waitForWebElementToAppearBy(bysearchfeild);
        searchfeild.click();
        searchfeild.sendKeys(orderId, Keys.ENTER);
    }

    /**
     * Verifies that the given order ID is displayed in the Orders table (first column, ant-typography cell).
     * Use after searchCaseId(orderId) to confirm the order appears. Order ID is dynamic each run.
     */
    public boolean isOrderIdDisplayedInTable(String orderId) {
        if (orderId == null || orderId.isEmpty()) return false;
        By orderIdInTableBy = By.xpath(
                "//tbody[contains(@class,'ant-table-tbody')]//div[contains(@class,'ant-typography-single-line') and contains(., '" + orderId + "')]");
        try {
            waitForWebElementToAppearBy(orderIdInTableBy);
            return driver.findElement(orderIdInTableBy).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void ClickDropDown(){
        waitForWebElementToAppearBy(bydropDown);
        dropDown.click();
    }
    public void radSearchFeildClick() throws Exception{
        waitForWebElementToAppearBy(byradSearchFeild);
        WebElement searchField = driver.findElement(byradSearchFeild);
        searchField.click();
        Thread.sleep(1000);
        searchField.sendKeys("Dr. Irad 2");
    }
    public void selectIRad(){
        waitForWebElementToAppearBy(bySelecIrad);
        selectIrad.click();
    }
    public boolean radNameIsDisplayed(){
        waitForWebElementToAppearBy(byradName);
      return  radname.isDisplayed();
    }
}// Assig case to Radiologist
