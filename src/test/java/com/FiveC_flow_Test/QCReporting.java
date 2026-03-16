package com.FiveC_flow_Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FiveCPageObject.POMHilReporting;
import com.FiveCPageObject.POMQCReporting;
import com.FiveC_flow_Test_Components.BaseTest;
import com.FiveC_flow_data.ImageUtil;
import com.FiveC_flow_data.OrderIdFileUtil;

public class QCReporting extends BaseTest {

    @Test(dataProvider = "getData")
    public void qcCaseReporting(HashMap<String, String> input) throws Exception {
        launchAdminApplication(input.get("qcUrl"));
        adminLogInPage.AdminloginApplication(input.get("qcUserName"), input.get("qcPassword"));
        POMQCReporting qcReporting = new POMQCReporting(driver);
        Boolean result = qcReporting.logOutButtonIsDisplayed();
        if (Boolean.TRUE.equals(result)) {
            Boolean caseStudiesText = qcReporting.caseStudiesTextIsDisplayed();
            if (Boolean.TRUE.equals(caseStudiesText)) {
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
            } else {
                Assert.fail("Case Studies Page is not displayed");
            }
        } else {
            Assert.fail("Admin Login Failed");
        }
    }

    @Test(dataProvider = "getData")
    public void preRead_Reporting(HashMap<String, String> input) throws Exception {
        launchAdminApplication(input.get("qcUrl"));
        adminLogInPage.AdminloginApplication(input.get("qcUserName"), input.get("qcPassword"));
        POMQCReporting qcReporting = new POMQCReporting(driver);
        Boolean result = qcReporting.logOutButtonIsDisplayed();
        if (Boolean.TRUE.equals(result)) {
            qcReporting.ClieckQCReportingPage();
            Boolean caseStudiesText = qcReporting.caseStudiesTextIsDisplayed();
            if (Boolean.TRUE.equals(caseStudiesText)) {
                qcReporting.clickViewCase();
                qcReporting.switchToChildWindow();
                try {
                    qcReporting.clickStartReportingButton();
                } catch (Exception e) {
                    qcReporting.clickStartReportingButton2();
                }
                String content = "I have a cure for insomnia. It's probably worth millions of dollars but I'm giving it to you free. It isn't warm milk or chamomile tea. It's list making";
                qcReporting.clickEditIcon();
                Thread.sleep(2000);
                qcReporting.clickEditReport();
                qcReporting.protocolSection(content);
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("window.scrollBy(0,500)");
                Thread.sleep(2000);
                qcReporting.observationsSection(content);
                String imagePath = System.getProperty("user.dir") + "//src//test//resources//UploadFile//Dicom-img.jpeg";
                ImageUtil.copyImageToClipboard(imagePath);
                qcReporting.clickInsertImageButton();
                Assert.assertTrue(qcReporting.saveTextIsDisplayed(), "Saved text is NOT displayed");
                Thread.sleep(2000);
                qcReporting.clickTkeBreakCheckBox();
                Thread.sleep(2000);
                qcReporting.clickSaveReport();
                Thread.sleep(2000);
                qcReporting.clickReportableButton();
                qcReporting.clickContinueWithoutMergingIfVisible();
                Thread.sleep(3000);
            } else {
                Assert.fail("Case Studies Page is not displayed");
            }
        } else {
            Assert.fail("Admin Login Failed");
        }
    }

    @Test(dataProvider = "getData")
    public void HilReporting(HashMap<String, String> input) throws Exception {
        launchAdminApplication(input.get("qcUrl"));
        adminLogInPage.AdminloginApplication(input.get("qcUserName"), input.get("qcPassword"));
        POMHilReporting hil = new POMHilReporting(driver);
        Assert.assertTrue(hil.logOutButtonIsDisplayed(), "Login failed");
        hil.ClickAiCaseListPage();
        Assert.assertTrue(hil.AI_StudiesTextIsDispalyed(), "AI Studies page is Not displayed");
        hil.clickSearchButton();
        String orderID = OrderIdFileUtil.get_orderId();
        hil.enterTheOrderId(orderID);
        hil.clickGoButton();
        Assert.assertTrue(hil.orderIdIsDisplayed(), "Order Id is not matched with order id in search bar");
        hil.viewTheCase();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String> windows = new ArrayList<>(windowHandles);
        driver.switchTo().window(windows.get(1));
        hil.clickStart_Reporting();
        hil.cliclGenerateReporting();
        Thread.sleep(1000);
        String defaultText = "No acute fracture or dislocation.";
        Assert.assertTrue(hil.getThirdSectionSiblingContainingText(defaultText), "Default report generation content is not loaded");
        hil.clickEditButton();
        Assert.assertTrue(hil.observationSectionIsDisplayed(), "Report is not loaded");
        String content = "Test content";
        hil.editObservationSection(content);
        Assert.assertTrue(hil.waitUntilEditorContentLoaded(content, 10), "Typed content should be loaded in the editor");
        hil.clickSaveButton();
        hil.clickReportableButton();
        hil.waitUntilChildWindowClosedAndSwitchToParent(15);
        driver.navigate().refresh();
        Assert.assertTrue(hil.statusIsCompleted(), "case is not completed");
    }

    @DataProvider
    public Object[][] getData() throws Exception {
        String filePath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
        HashMap<String, String> data = getJsontoMap(filePath, "qcData");
        return new Object[][] { { data } };
    }
}
