package com.FiveC_flow_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.POMRadCaseAssign;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.OrderIdFileUtil;

import java.util.HashMap;
import org.testng.Assert;

public class CaseAssignToRad extends BaseTest {

    @Test(dataProvider = "getData")
    public void caseAssignToRad(HashMap<String, String> input) throws Exception {

        launchAdminApplication(input.get("adminUrl"));
        adminLogInPage.AdminloginApplication(input.get("adminUserName"), input.get("adminPassword"));

        POMRadCaseAssign radCaseAssign = new POMRadCaseAssign(driver);
        Boolean result = radCaseAssign.logOutTextIsDisplayed();

        if (result.equals(true)) {
            System.out.println("Admin Login Success");
            radCaseAssign.searchButtonClick();
            String orderID = OrderIdFileUtil.get_orderId();
            radCaseAssign.orderIdInput(orderID);
            radCaseAssign.clickGoButtonClick();
            String caseId = radCaseAssign.caseIdDisplayed();
            System.out.println("Displayed caseId is :" + caseId);
            String getorderID = OrderIdFileUtil.get_orderId();
            Assert.assertEquals(caseId, getorderID);
            System.out.println("Case ID matched: Case is in the RAD pool");
            radCaseAssign.caseIdDropdownClick();
            driver.switchTo().activeElement().sendKeys("irad");
            try {
                radCaseAssign.radNameClick();
                try {
                    radCaseAssign.assignAnywayButtonClick();
                } catch (Exception e) {
                    System.out.println("Something went wrong while assigining case to rad");
                }
            } catch (Exception e) {
                System.out.println("The rad you are looking for in the list is not present.");
            }
            // radCaseAssign.waitForRadiologistUpdatedToast();
            // String toastMessage = radCaseAssign.getToastMessage();
            // Assert.assertEquals(toastMessage, "Radiologist updated successfully");
            Boolean radNameDisplayed = radCaseAssign.getRadNameDisplayed();
            Assert.assertEquals(radNameDisplayed, true);
            System.out.println("Rad Name Displayed: " + radNameDisplayed);
            System.out.println("Case is assigned to rad successfully");

        } else {
            System.out.println("Admin Login Failed");
        }

        // String toastMessage = radCaseAssign.getToastMessage();
        // System.out.println("Toast Message: " + toastMessage);
        // Assert.assertEquals(toastMessage, "Radiologist updated successfully");

        // System.out.println(get_orderId());
    }

    @DataProvider
    public Object[][] getData() throws Exception {
        String filePath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filePath, "adminData");
        return new Object[][] { { data } };
    }
}
