package com.FiveCPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FiveCAbstaractComponent.AbstractComponent;

public class POMCaseAssignToHil extends AbstractComponent {
    WebDriver driver;
    public POMCaseAssignToHil(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    
    }
   
    @FindBy(xpath = "//span[text()='Logout']")
    WebElement logoutButton;
    @FindBy(xpath = "//a[@href='/ai']")
    WebElement aiCaseListPage;
    @FindBy(xpath = "//span[contains(text(),'AI Studies')]")
    WebElement textIsDisplayed;
    @FindBy(xpath = "//img[@alt='icon_search']")
    WebElement searchicone;
 // Target the input (not the label) - input in same container as "Order Id" label to avoid click intercepted
    @FindBy(xpath = "//span[text()='Order Id']/ancestor::*[.//input][1]//input")
    WebElement OrderID_inputfield;
    @FindBy(xpath = "//button[contains(text(),'Go')]")
    WebElement goButton;
    @FindBy(xpath = "//div[contains(@class,'PatientNameContainer')]//span[2]")
    WebElement caseidDisplayed;
    @FindBy(xpath = "//img[@alt='icon_chevron-bottom']")
    WebElement dropDown;
    @FindBy(xpath = "//span[text()='Kesav']")
    WebElement qcName;
    @FindBy(xpath = "//div[contains(@class,'ai__TableBodyRow')]//span[contains(text(),'ASSIGNED')]")
    WebElement assignedText;
    @FindBy (xpath = "//button[contains(text(),'Start Reporting')]")
    WebElement startReporting;

  By logoutButtonBy = By.xpath("//span[text()='Logout']");
  By byaiCaseListPage = By.xpath("//a[@href='/ai']");
  By bytextIsDisplayed = By.xpath("//span[contains(text(),'AI Studies')]");
  By byOrderID_inputfield = By.xpath("//span[text()='Order Id']/ancestor::*[.//input][1]//input");
  By bygoButton = By.xpath("//button[contains(text(),'Go')]");
  By bycaseidDisplayed = By.xpath("//div[contains(@class,'PatientNameContainer')]//span[2]");
  By bydropDown = By.xpath("//img[@alt='icon_chevron-bottom']");
  By qcNameBy = By.xpath("//span[text()='Kesav']");
  By assignedTextBy = By.xpath("//div[contains(@class,'ai__TableBodyRow')]//span[contains(text(),'ASSIGNED')]");
  By bystartReporting = By.xpath("//button[contains(text(),'Start Reporting')]");

  
  public Boolean logOutButtonIsDisplayed() {
    waitForWebElementToAppearBy(logoutButtonBy);
    return logoutButton.isDisplayed();
   }
  public void clickAiCaseListPage(){
    waitForWebElementToAppearBy(byaiCaseListPage);
    aiCaseListPage.click();
  }
  public boolean AI_StudiesText(){
    waitForWebElementToAppearBy(bytextIsDisplayed);
    return textIsDisplayed.isDisplayed();
  }
  public void searchButtonClick(){
    searchicone.click();
  }
 public void enterTheOrderId(String orderID) {
    waitForWebElementToAppearBy(byOrderID_inputfield);
    OrderID_inputfield.sendKeys(orderID);
  }
  public void ClickGo(){
    waitForWebElementToAppearBy(bygoButton);
    goButton.click();

  }
  public String getCaseIDText() {
    waitForWebElementToAppearBy(bycaseidDisplayed);
    return caseidDisplayed.getText();
}
public void ClickDropDown(){
    waitForWebElementToAppearBy(bydropDown);
    dropDown.click();
}
public void AssignCaseToQcAgent() {
    waitForWebElementToAppearBy(qcNameBy);
    qcName.click();
}
public Boolean assignedTextIsDisplayed() {
    waitForWebElementToAppearBy(assignedTextBy);
    return assignedText.isDisplayed();
}   
public void ClickStartReporting(){
  waitForWebElementToAppearBy(bystartReporting);
  startReporting.click();

}

}
