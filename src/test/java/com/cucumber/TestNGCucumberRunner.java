package com.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//This is the class where need to give the information about which cucumber feature file need to run
//We can't run the feature file directly into our runner class we need to provide some Cucumber options to run
@CucumberOptions(
        // am telling this Runner class to which feature file need to run.
        // and also Step Defination needs to be mapped with feature file for that we use
        // the glue
        // OutPut of the result will not be in readable to rsolve this we need to add
        // monochrome
        // monochrome reslove this issue.
        // ByDefault Cucumber cannot scane the TestNG assertion or TestNG Libraries to
        // overcome this issue TestNG intorduced this AbstractTestNGCucumberTests

        // mvn test -Dtest=TestNGCucumberRunner  this is the command to run the feature file

        features = "src/test/java/com/cucumber/stepExecution.feature", glue = { "com.stepDefination" }, 
        tags = "@tag4",

        plugin = {
                "pretty",
                "html:target/cucumber-reports/CucumberReport.html"
        }, monochrome = true)
public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
}
