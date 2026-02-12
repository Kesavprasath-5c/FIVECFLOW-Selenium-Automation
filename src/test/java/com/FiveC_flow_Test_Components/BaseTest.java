package com.FiveC_flow_Test_Components;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.FiveCPageObject.POMAdminLogInPage;
import com.FiveCPageObject.POMClientLoginPage;
import com.FiveCPageObject.POMRadLoginPage;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {
  public WebDriver driver;
  public POMClientLoginPage clientLoginPage;
  public POMAdminLogInPage adminLogInPage;
  public POMRadLoginPage radLoginPage;

  public WebDriver initializeDriver() throws Exception {
    // This is one of the way to get the value present in the Global.properties file
    Properties prop = new Properties();
    // This fileInputStream reads the file data in Bytes instead of reading directly as Text Format
    FileInputStream file = new FileInputStream(
    System.getProperty("user.dir") + "//src//main//java//com//FiveCResources//Global.properties");
    prop.load(file);
    // Below line is a Ternary operator saying that if System.getProperty("browser") is not null then use that value given by the user 
    // this System.getPropery("browser") is used to read the paramater given by user via terminal
     // else use global property value declared in the properties file
    String browserName = System.getProperty("browser")!= null ?  System.getProperty("browser"):prop.getProperty("browser");
    

    if (browserName.equalsIgnoreCase("chrome")) {
      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-notifications");

      HashMap<String, Object> prefs = new HashMap<String, Object>();
      prefs.put("profile.default_content_setting_values.clipboard", 1);
      prefs.put("profile.default_content_setting_values.clipboard-read", 1);
      prefs.put("profile.default_content_setting_values.clipboard-write", 1);
      options.setExperimentalOption("prefs", prefs);

      driver = new ChromeDriver(options);

    } else if (browserName.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    }
    driver.manage().window().maximize();
    return driver;
  }

  public HashMap<String, String> getJsontoMap(String FilePath, String dataSetName) throws Exception {
    // convert Json file to String first
    String jsonContent = FileUtils.readFileToString(new File(FilePath), StandardCharsets.UTF_8);
    // convert String to Map
    // To convert String to Map we need to use the jackson Databind dependency
    ObjectMapper mapper = new ObjectMapper();
    HashMap<String, HashMap<String, String>> data = mapper.readValue(jsonContent,new TypeReference<HashMap<String, HashMap<String, String>>>() {});
    return data.get(dataSetName);
  }

  public String getScreenShot(String testName, WebDriver driver) throws Exception {
    TakesScreenshot ts = (TakesScreenshot) driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    File file = new File(System.getProperty("user.dir") + "//reports//" + testName + ".png");
    FileUtils.copyFile(source, file);

    return System.getProperty("user.dir") + "//reports//" + testName + ".png";
  }

  @BeforeMethod
  public void configureDriver() throws Exception {
  driver = initializeDriver();

  }

  public POMClientLoginPage launchClientApplication(String clientUrl) {
    clientLoginPage = new POMClientLoginPage(driver);
    clientLoginPage.GoToClientApplication(clientUrl);
    return clientLoginPage;

  }

  public POMAdminLogInPage launchAdminApplication(String adminUrl) {
    adminLogInPage = new POMAdminLogInPage(driver);
    adminLogInPage.GoToAdminApplication(adminUrl);
    return adminLogInPage;
  }

  public POMRadLoginPage launchRadApplication(String radurl) {
    radLoginPage = new POMRadLoginPage(driver);
    radLoginPage.GotToRadApplication(radurl);
    return radLoginPage;
  }

  @AfterMethod
  public void tearDown() {
 // driver.quit();
  }
}
