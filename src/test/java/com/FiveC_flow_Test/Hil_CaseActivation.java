package com.FiveC_flow_Test;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.ClientFormFilling;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.OrderIdFileUtil;

import org.testng.Assert;

public class Hil_CaseActivation extends BaseTest {

    @Test(dataProvider = "getJsonData")
    public void Hil_CaseActivations(HashMap<String, String> input) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        launchClientApplication(input.get("clientUrl"));
        clientLoginPage.ClientloginApplication(input.get("clientUserName"), input.get("clientPassword"));
        WebElement tostmsg = clientLoginPage.verifyLoginTostResult();
        String msg = tostmsg.getText();
        if (msg.contains("Logged in successfully")) {
            System.out.println("Login Success");
            boolean msg1 = wait.until(ExpectedConditions.invisibilityOf(tostmsg));
            Assert.assertTrue(msg1);
            try {

                wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@aria-label='close']")))
                        .click();
            } catch (Exception e) {
                System.out.println("Pop are all handled");
            }
             ClientFormFilling fillforms = new ClientFormFilling(driver);
            // ClientFormFilling fillforms = new ClientFormFilling(driver);
            fillforms.dismissPaymentPopupIfPresent();
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
     
            fillforms.selectHilStudy();
           
            fillforms.history();
             try {
                fillforms.generalRadiologistPool();
            } catch (Exception e) {
                System.out.println("No General Radiologist Pool Button found");
            }

            fillforms.sendForReporting();
            WebElement toastMessage= clientLoginPage.verifySuccessAppears();
            if(toastMessage.isDisplayed()){
                 String caseActivationtostmsg = toastMessage.getText();
                 System.out.println(caseActivationtostmsg);
                 clientLoginPage.waitForToastToDisappear(toastMessage);
                 fillforms.clickOrdersPage();
                 fillforms.getCaseId();
                 OrderIdFileUtil.stroreOrderId(fillforms.getCaseId());
                System.out.println(OrderIdFileUtil.get_orderId());
   
            }
            else{
                System.out.println("Case Activation Failed");
            }

             

          }
            
           
             

     
        else {
            System.out.println("Login Failed");
        }

       

    }
    


    @DataProvider
    public Object[][] getJsonData() throws Exception {
        String filepath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filepath, "clientData");
        return new Object[][] { { data } };
    }
}

