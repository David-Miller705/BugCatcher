package com.revature.runners;

import com.revature.pages.LoginPage;
import com.revature.pages.ManagerHomePage;
import com.revature.pages.TesterHomePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.logging.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

@CucumberOptions(features = "classpath:features", glue = "com.revature.stepimplementations")
public class BasicRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static ManagerHomePage managerHomePage;
    public static TesterHomePage testerHomePage;



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
    }

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
