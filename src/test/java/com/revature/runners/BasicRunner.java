package com.revature.runners;

import com.revature.pages.*;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

@CucumberOptions(features = "classpath:features/defect", glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {
    public static String loginPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=5";
    public static String managerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome";
    public static String testerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome";
    public static String defectReporterPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/defectreporter";
    public static String testcasesPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/testcases";


    public static WebDriver driver;
    public static LoginPage loginPage;
    public static Page page;
    public static ManagerHomePage managerHomePage;
    public static TesterHomePage testerHomePage;
    public static MatricesPage matricesPage;
    public static TestcasesPage testcasesPage;
    public static TestcasesEditPage testcasesEditPage;
    public static DefectReporterPage defectReporterPage;
    public static DefectOverviewPage defectOverviewPage;

    public static WebDriverWait webDriverWait;

    public static Actions actions;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        page = new Page(driver);
        managerHomePage = new ManagerHomePage(driver);
        testerHomePage = new TesterHomePage(driver);
        matricesPage = new MatricesPage(driver);
        testcasesPage = new TestcasesPage(driver);
        testcasesEditPage = new TestcasesEditPage(driver);
        defectOverviewPage = new DefectOverviewPage(driver);
        defectReporterPage = new DefectReporterPage(driver);
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

    public static void login(String username, String password) {
        BasicRunner.driver.get(loginPageURL);
        webDriverWait.until(ExpectedConditions.urlToBe(loginPageURL));
        BasicRunner.loginPage.usernameInput.sendKeys(username);
        BasicRunner.loginPage.passwordInput.sendKeys(password);
        BasicRunner.loginPage.loginButton.click();
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(loginPageURL)));
    }
}
