package com.FiveC_flow_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.POMRadLoginPage;
import com.FiveCPageObject.POMRadReporting;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.ImageUtil;
import com.FiveC_flow_data.OrderIdFileUtil;

import java.util.HashMap;
import org.testng.Assert;

public class RadReporting extends BaseTest {

    @Test(dataProvider = "getData")
    public void normalCaseReporting(HashMap<String, String> input) throws Exception {
        launchRadApplication(input.get("radUrl"));
        POMRadLoginPage radLoginPage = new POMRadLoginPage(driver);
        radLoginPage.RadloginApplication(input.get("radUserName"), input.get("radPassword"));
        POMRadReporting pomRadReporting = new POMRadReporting(driver);

        if (pomRadReporting.isLogoutButtonDisplayed()) {
            System.out.println("Rad Login Success");
          //  pomRadReporting.HotKeyClose();
            pomRadReporting.clickSearchIcon();
            String orderID = OrderIdFileUtil.get_orderId();
            pomRadReporting.orderIdInput(orderID);
            pomRadReporting.clickGoButton();
            String ExpectedcaseId = pomRadReporting.GetcaseIdDisplayed();
            System.out.println("Displayed caseId is :" + ExpectedcaseId);
            // String getorderID = OrderIdFileUtil.get_orderId();
            Assert.assertEquals(orderID, ExpectedcaseId);
            System.out.println("Case ID matched: Case is in the RAD pool");
            pomRadReporting.clickCaseViewIcon();
            Thread.sleep(2000);
            pomRadReporting.switchToChildWindow();
            try {
                pomRadReporting.clickStartReportingButton();
            } catch (Exception e) {
                pomRadReporting.clickStartReportingButton2();
            }
            String content = "I have a cure for insomnia. It’s probably worth millions of dollars but I’m giving it to you free. It isn’t warm milk or chamomile tea. It’s list making";
            pomRadReporting.protocolSection(content);
            Thread.sleep(1000);
            pomRadReporting.observationsSection(content);
            if (pomRadReporting.savedtextDisplayed()) {
                System.out.println("Protocol and Observations are saved");
            } else {
                Assert.fail("Protocol and Observations are not saved");
            }
            Thread.sleep(2000);
            String imagePath = System.getProperty("user.dir") + "//src//test//resources//UploadFile//Dicom-img.jpeg";
            ImageUtil.copyImageToClipboard(imagePath);
            pomRadReporting.clickInsertImageButton();
            Thread.sleep(2000);
           
            pomRadReporting.clickSubmitButton();
            pomRadReporting.clickSubmitTakeBreakButton();
            pomRadReporting.switchToParentWindow();
            pomRadReporting.clickSearchIcon();
            pomRadReporting.clickCompletedCheckbox();
            pomRadReporting.clickGoButton();
            if (pomRadReporting.reportedtextDisplayed()) {
                System.out.println("Case is reported by rad Successfully");
            } else {
                System.out.println("Reported text is not displayed");

            }
        } 
        else {
            System.out.println("Rad Login Failed");
        }
    }

       @Test(dataProvider = "getData2")
        public void iradCaseReporting(HashMap<String, String> input) throws Exception {
            launchRadApplication(input.get("radUrl"));
            POMRadLoginPage radLoginPage = new POMRadLoginPage(driver);
            radLoginPage.RadloginApplication(input.get("radUserName"), input.get("radPassword"));
            POMRadReporting pomRadReporting = new POMRadReporting(driver);
    
            if (pomRadReporting.isLogoutButtonDisplayed()) {
                System.out.println("Rad Login Success");
              //  pomRadReporting.HotKeyClose();
                pomRadReporting.clickSearchIcon();
                String orderID = OrderIdFileUtil.get_orderId();
                pomRadReporting.orderIdInput(orderID);
                pomRadReporting.clickGoButton();
                String ExpectedcaseId = pomRadReporting.GetcaseIdDisplayed();
                System.out.println("Displayed caseId is :" + ExpectedcaseId);
                // String getorderID = OrderIdFileUtil.get_orderId();
                Assert.assertEquals(orderID, ExpectedcaseId);
                System.out.println("Case ID matched: Case is in the RAD pool");
                pomRadReporting.clickCaseViewIcon();
                Thread.sleep(2000);
                pomRadReporting.switchToChildWindow();
                try {
                    pomRadReporting.clickStartReportingButton();
                } catch (Exception e) {
                    pomRadReporting.clickStartReportingButton2();
                }
                if (pomRadReporting.isIradClientTemplateLoaded(10)) {
                    System.out.println("Client Template is loaded");
                } else {
                    System.out.println("Client Template is not loaded");
                }
                String content = "normal report";
                pomRadReporting.typeNormalReportInObservations(content);
                Assert.assertTrue(pomRadReporting.isTypedContentDisplayedInEditor(content, 10), "Typed content should be displayed in the editor");
                System.out.println("Typed content is displayed in the Observations Section editor");
                pomRadReporting.typeNormalReportInImpresión(content);
                Assert.assertTrue(pomRadReporting.isTypedContentDisplayedInEditor(content, 10), "Typed content should be displayed in the editor");
                System.out.println("Typed content is displayed in the Observations Section editor");
                pomRadReporting.iRadSubmitButton();
                pomRadReporting.clickSubmitTakeBreakButton();
                pomRadReporting.switchToParentWindow();
                pomRadReporting.clickSearchIcon();
                pomRadReporting.clickCompletedCheckbox();
                pomRadReporting.clickGoButton();
                if (pomRadReporting.iradcompletedtextDisplayed()) {
                    System.out.println("Case is reported by rad Successfully");
                } else {
                    System.out.println("Reported text is not displayed");
    
                }

            }
            else {
                System.out.println("Rad Login Failed");
            }

         }


    @DataProvider
    public Object[][] getData() throws Exception {
        String filePath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filePath, "radData");
        return new Object[][] { { data } };
    }
    @DataProvider
    public Object[][] getData2() throws Exception {
        String filePath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filePath, "iradData");
        return new Object[][] { { data } };
    }


}
