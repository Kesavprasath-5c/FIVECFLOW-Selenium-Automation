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
 
public class PreRead_CaseActivation extends BaseTest {

    @Test(dataProvider = "getData" )
    public void PreRead_Activation(HashMap<String, String> input ) throws Exception   {
        launchClientApplication(input.get("clientUrl"));
        clientLoginPage.ClientloginApplication(input.get("clientUserName"), input.get("clientPassword"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Verify login success or failure
        WebElement toast = clientLoginPage.verifyLoginTostResult();
        String toastText = toast.getText();

        if (toastText.contains("Logged in successfully")) {
            System.out.println("Login success");

            // Verify toast disappears
            boolean toastDisappeared = wait.until(ExpectedConditions.invisibilityOf(toast));
            if (toastDisappeared) {
                System.out.println("Toast message disappeared successfully");
            }
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
            fillforms.selectPreReadStudy();
            fillforms.history();
            WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
            uploadInput.sendKeys(System.getProperty("user.dir") + "//src//test//resources//UploadFile//screenshot.png");
            Thread.sleep(2000);
            fillforms.upload();
            try {
                fillforms.generalRadiologistPool();
            } catch (Exception e) {
                System.out.println("No General Radiologist Pool Button found");
            }

            fillforms.sendForReporting();

            WebElement toastMessage = clientLoginPage.verifySuccessAppears();

            if (toastMessage.isDisplayed()) {
                System.out.println("Case Activation Status: " + toastMessage.getText());
                clientLoginPage.waitForToastToDisappear(toastMessage);
                fillforms.clickOrdersPage();
                OrderIdFileUtil.stroreOrderId(fillforms.getCaseId());
            } else {
                System.out.println("Failed to Activate case");
            }
        }
    }
    
    @DataProvider
    public Object[][] getData() throws Exception{
        String filepath = System.getProperty("user.dir")+ "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filepath,"clientData");
        return new Object[][] { { data } };
    } 
   
    
    
}

