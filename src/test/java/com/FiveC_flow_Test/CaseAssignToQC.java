package com.FiveC_flow_Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.POMCaseAssignToQC;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.OrderIdFileUtil;

import java.util.HashMap;
import org.testng.Assert;

public class CaseAssignToQC extends BaseTest {

    @Test(dataProvider = "getData")
    public void assignToQC(HashMap<String, String> input) throws Exception {
        launchAdminApplication(input.get("adminUrl"));
        adminLogInPage.AdminloginApplication(input.get("adminUserName"), input.get("adminPassword"));
        POMCaseAssignToQC pomCaseAssignToQC = new POMCaseAssignToQC(driver);
        Boolean result = pomCaseAssignToQC.logOutButtonIsDisplayed();

        if (result.equals(true)) {
            System.out.println("Admin Login Success");
            pomCaseAssignToQC.clickQcCoordinator();
            Boolean QCStudiesText = pomCaseAssignToQC.QCStudiesTextIsDisplayed();
            if (QCStudiesText.equals(true)) {
                pomCaseAssignToQC.clickSearchIcon();
                String orderID = OrderIdFileUtil.get_orderId();
                pomCaseAssignToQC.searchInput(orderID);
                pomCaseAssignToQC.clickGoButton();
                Assert.assertEquals(pomCaseAssignToQC.getCaseIDText(), orderID);
                System.out.println("Case ID in QCPool");
                pomCaseAssignToQC.caseIdDropdownClick();
                driver.switchTo().activeElement().sendKeys("kesav");
                pomCaseAssignToQC.qcNameClick();
                Boolean assignedText = pomCaseAssignToQC.assignedTextIsDisplayed();
                if (assignedText.equals(true)) {
                    System.out.println("Case assigned to QC successfully");
                } else {
                    System.out.println("Case not assigned to QC");
                }
            } else {
                System.out.println("QC Studies page is not Displayed");
            }
        } else {
            System.out.println("Admin Login Failed");
        }

    }

    @DataProvider
    public Object[][] getData() throws Exception {
        String filepath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filepath, "adminData");
        return new Object[][] { { data } };
    }

}
