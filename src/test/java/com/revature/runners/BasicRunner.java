package com.revature.runners;

import com.revature.pages.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(features = "classpath:features/defect", glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {
    public static String loginPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=5";
    public static String managerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome";
    public static String testerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome";
    public static String defectReporterPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/defectreporter";


    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ManagerHomePage managerHomePage;
    public static TesterHomePage testerHomePage;
    public static MatricesPage matricesPage;
    public static TestCasesPage testCasesPage;
    public static DefectReporterPage defectReporterPage;
    public static DefectOverviewPage defectOverviewPage;



    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        managerHomePage = new ManagerHomePage(driver);
        testerHomePage = new TesterHomePage(driver);
        matricesPage = new MatricesPage(driver);
        testCasesPage = new TestCasesPage(driver);
        defectOverviewPage = new DefectOverviewPage(driver);
        defectReporterPage = new DefectReporterPage(driver);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
