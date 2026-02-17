package com.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/com/cucumber/preRead.feature",
    glue = {"com.stepDefination"},
    tags = "@tag",
    plugin = {
        "pretty",
        "html:target/cucumber-reports/CucumberPreReadReport.html"
    },
    monochrome = true
)
public class TestNGPreReadRunner extends AbstractTestNGCucumberTests {
}
