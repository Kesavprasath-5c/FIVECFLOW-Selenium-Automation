package com.stepDefination;

import java.util.HashMap;

import com.FiveC_flow_Test.CaseActivationPage;
import com.FiveC_flow_Test.CaseAssignToQC;
import com.FiveC_flow_Test.CaseAssignToRad;
import com.FiveC_flow_Test.PreRead_CaseActivation;
import com.FiveC_flow_Test.QCReporting;
import com.FiveC_flow_Test.RadReporting;
import com.FiveC_flow_Test_Components.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class StepDefinationoi extends BaseTest {

        @Before
        public void setup() throws Exception {
                if (driver == null) {
                        driver = initializeDriver();
                        System.out.println("Driver initialized successfully");
                }
        }

        @After
        public void tearDown(Scenario scenario) throws Exception {
                if (scenario.isFailed()) {
                        String screenshotPath = getScreenShot(scenario.getName(), driver);
                        //cucumber cannot directly read the png file so we need to convert it into byte array
                        byte[] fileContent = FileUtils.readFileToByteArray(new File(screenshotPath));
                        scenario.attach(fileContent, "image/png", "Failed_Screenshot");
                }
                driver.quit();
        }

        @Given("Login to Client Page and acivate the case and get the order_ID")
        public void Login_to_Client_Page_and_activate_the_case_and_get_the_order_ID() throws Exception {
                // Get your data
                String filePath = System.getProperty("user.dir")
                                + "//src//test//java//com//FiveC_flow_data//loginData.json";
                HashMap<String, String> clientData = getJsontoMap(filePath, "clientData");
                // 2. Call the method from CaseActivationPage class instead of re-defining it
                CaseActivationPage activation = new CaseActivationPage();
                activation.driver = this.driver; // IMPORTANT: Pass the driver instance
                activation.verifyCaseActivation(clientData);
        }

        @Given("Login to Client Page and acivate a preRead case and get the order_ID")
        public void Login_to_Client_Page_and_acivate_a_preRead_case_and_get_the_order_ID() throws Exception{
                // Ensure driver is initialized
                if (driver == null) {
                        driver = initializeDriver();
                        System.out.println("Driver initialized in step definition");
                }
                
                // Verify driver is not null
                if (driver == null) {
                        throw new Exception("Driver is still null after initialization!");
                }
                
                String filePath = System.getProperty("user.dir") + "//src//test//java//com//FiveC_flow_data//loginData.json";
                HashMap<String,String> clientData = getJsontoMap(filePath, "clientData");
                
                PreRead_CaseActivation preread = new PreRead_CaseActivation();
                preread.driver = this.driver;  // Pass the initialized driver
                
                // Verify driver was set
                if (preread.driver == null) {
                        throw new Exception("Failed to set driver in PreRead_CaseActivation instance!");
                }
                
                System.out.println("Calling PreRead_Activation with driver: " + (preread.driver != null ? "Initialized" : "NULL"));
                preread.PreRead_Activation(clientData);
        }

        @When("Assign the case to rad")
        public void Assign_the_case_to_rad() throws Exception {
                String filePath = System.getProperty("user.dir")
                                + "//src//test//java//com//FiveC_flow_data//loginData.json";
                HashMap<String, String> adminData = getJsontoMap(filePath, "adminData");
                CaseAssignToRad assignToRad = new CaseAssignToRad();
                assignToRad.driver = this.driver;
                assignToRad.caseAssignToRad(adminData);
        }

        @And("Report the case by raddiologits")
        public void Report_the_case_by_raddiologits() throws Exception {
                String filePath = System.getProperty("user.dir")
                                + "//src//test//java//com//FiveC_flow_data//loginData.json";
                HashMap<String, String> radData = getJsontoMap(filePath, "radData");
                RadReporting reporting = new RadReporting();
                reporting.driver = this.driver;
                reporting.normalCaseReporting(radData);
        }

        @And("Now assign the case to QC agent")
        public void Now_assign_the_case_to_QC_agent() throws Exception {
                String filePath = System.getProperty("user.dir")
                                + "//src//test//java//com//FiveC_flow_data//loginData.json";
                HashMap<String, String> adminData = getJsontoMap(filePath, "adminData");
                CaseAssignToQC assignToQC = new CaseAssignToQC();
                assignToQC.driver = this.driver;
                assignToQC.assignToQC(adminData);
        }

        @Then("Submit the case via QC agent")
        public void Submit_the_case_via_QC_agent() throws Exception {
                String filePath = System.getProperty("user.dir")
                                + "//src//test//java//com//FiveC_flow_data//loginData.json";
                HashMap<String, String> qcData = getJsontoMap(filePath, "qcData");
                QCReporting qcReporting = new QCReporting();
                qcReporting.driver = this.driver;
                qcReporting.qcCaseReporting(qcData);
        }

}