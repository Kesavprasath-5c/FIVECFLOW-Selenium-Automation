package com.FiveC_flow_Test;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.ClientFormFilling;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.OrderIdFileUtil;

public class IradClientCaseActivation extends BaseTest {
   
  @Test  (dataProvider = "getData")
 public void iradCaseActivation(HashMap<String,String> input) throws Exception{
    launchClientApplication(input.get("clientUrl"));
   clientLoginPage.ClientloginApplication(input.get("clientUserName"), input.get("clientPassword"));
   WebElement tostmsg = clientLoginPage.verifyLoginTostResult();
        String msg = tostmsg.getText();
        Assert.assertTrue(msg.contains("Logged in successfully"), "Login Failed");
        System.out.println("Login Success");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean msg1 = wait.until(ExpectedConditions.invisibilityOf(tostmsg));
        Assert.assertTrue(msg1);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']")))
                    .click();
        } catch (Exception e) {
            System.out.println("Pop are all handled");
        }
        ClientFormFilling fillforms = new ClientFormFilling(driver);
        fillforms.draftClick();
        fillforms.clearAll();
        fillforms.viewForm();
        fillforms.closeMerge();
        fillforms.name();
        fillforms.phone();
        fillforms.age();
        fillforms.referringPhysician();
        try {
            fillforms.AuraButtonClose();
        } catch (Exception e) {
            System.out.println("Aura close button not found or already Disabled");
        }
        fillforms.selectIradStudy();
        fillforms.history();
        try {
            fillforms.generalRadiologistPool();
        } catch (Exception e) {
            System.out.println("No General Radiologist Pool Button found");
        }
        fillforms.sendForReporting();
        WebElement toastMessage = clientLoginPage.verifySuccessAppears();
        Assert.assertTrue(toastMessage.isDisplayed(), "Case Activation Failed");
        String caseActivationtostmsg = toastMessage.getText();
        System.out.println(caseActivationtostmsg);
        clientLoginPage.waitForToastToDisappear(toastMessage);
        fillforms.clickOrdersPage();
        fillforms.getCaseId();
        OrderIdFileUtil.stroreOrderId(fillforms.getCaseId());
        System.out.println(OrderIdFileUtil.get_orderId());
        



  }

  @Test  (dataProvider = "getData1")
 public void iradAdminCaseAssign(HashMap<String,String> input) throws Exception{
        launchClientApplication(input.get("clientUrl"));
        clientLoginPage.ClientloginApplication(input.get("clientUserName"), input.get("clientPassword"));
        WebElement tostmsg = clientLoginPage.verifyLoginTostResult();
        String orderID = OrderIdFileUtil.get_orderId();
        String msg = tostmsg.getText();
        Assert.assertTrue(msg.contains("Logged in successfully"), "Login Failed");
        System.out.println("Login Success");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean msg1 = wait.until(ExpectedConditions.invisibilityOf(tostmsg));
        Assert.assertTrue(msg1);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']")))
                    .click();
        } catch (Exception e) {
            System.out.println("Pop are all handled");
        }
        ClientFormFilling fillforms = new ClientFormFilling(driver);
        fillforms.clickOrdersPage();
        fillforms.searchCaseId(orderID);
        Assert.assertTrue(fillforms.isOrderIdDisplayedInTable(orderID),"Order ID should be displayed in table");
        System.out.println("Activated iRAD Case is present inside the admin orders page");
        fillforms.ClickDropDown();
        fillforms.radSearchFeildClick();
        fillforms.selectIRad();
        Assert.assertTrue(fillforms.radNameIsDisplayed(),"Global irad clinet unable to assign case to irad");
        System.out.println("Irad_case is assigned to Global irad");

    }

 @DataProvider
 public Object[][] getData() throws Exception{
    String filePath =System.getProperty("user.dir") +"//src//test//java//com//FiveC_flow_data//loginData.json";
    HashMap<String,String> data =  getJsontoMap(filePath,"globalIradClient");
    return new Object[][] { { data } };
 }

@DataProvider
public Object[][] getData1() throws Exception{
String filePath = System.getProperty("user.dir")+ "//src//test//java//com//FiveC_flow_data//loginData.json";
HashMap<String,String> data2 = getJsontoMap(filePath, "globalIradAdminClient");
return new Object[][]{{data2}};
}


 }