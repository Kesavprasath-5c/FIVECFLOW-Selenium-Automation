package com.FiveC_flow_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.POMQCReporting;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.OrderIdFileUtil;

import java.util.HashMap;
import org.testng.Assert;

public class QCReporting extends BaseTest {

    @Test(dataProvider = "getData")
    public void qcCaseReporting(HashMap<String, String> input) throws Exception {
        launchAdminApplication(input.get("qcUrl"));
        adminLogInPage.AdminloginApplication(input.get("qcUserName"), input.get("qcPassword"));
        POMQCReporting qcReporting = new POMQCReporting(driver);
        Boolean result = qcReporting.logOutButtonIsDisplayed();
        String orderID = OrderIdFileUtil.get_orderId();
        System.out.println(orderID);
        if (result.equals(true)) {
            System.out.println("Admin Login Success");
            qcReporting.ClieckQCReportingPage();
            Boolean caseStudiesText = qcReporting.caseStudiesTextIsDisplayed();
            if (caseStudiesText.equals(true)) {
                System.out.println("Case Studies Page is displayed");
                qcReporting.clickViewCase();
                qcReporting.switchToChildWindow();
                try {
                    qcReporting.clickStartReportingButton();
                } catch (Exception e) {
                    qcReporting.clickStartReportingButton2();
                }
                qcReporting.clickEditIcon();
                String content = "Tetsing_OQC_Edit";
                qcReporting.protocolSection(content);
                qcReporting.clickSaveButton();
                qcReporting.verifyReportEditedSuccessfully();
                Thread.sleep(2000);
                qcReporting.clickApproveButton();
                Thread.sleep(1000);
                qcReporting.clickAcceptCaseButton();
                qcReporting.clickSubmitButtonAndTakeBreak();
                Thread.sleep(2000);
                // // Capture the toast immediately after the submit click
                // String toastMessage = qcReporting.getStudyAcceptedToastText();
                // Assert.assertEquals(toastMessage, "Study accepted successfully");
                // System.out.println("Toast Message: " + toastMessage);

            } else {
                System.out.println("Case Studies Page is not displayed");
                Assert.fail("Case Studies Page is not displayed");
            }
        } else {
            System.out.println("Admin Login Failed");
            Assert.fail("Admin Login Failed");
        }

    }

    @DataProvider
    public Object[][] getData() throws Exception {
        String filePath = System.getProperty("user.dir")
                + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filePath, "qcData");
        return new Object[][] { { data } };
    }
}
