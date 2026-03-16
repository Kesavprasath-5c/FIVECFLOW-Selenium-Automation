package com.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/com/cucumber/Hil.feature", glue = "com.stepDefination", plugin = {
        "pretty",
        "html:target/cucumber-reports/CucumberHilReport.html"
}, monochrome = true, tags = "@tag1")
public class TestNGHilRunner extends AbstractTestNGCucumberTests {

}
