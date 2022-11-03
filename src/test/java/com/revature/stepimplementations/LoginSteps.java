package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    public static String loginPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=5";
    public static String managerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome";
    public static String testerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/testerhome";


    // LOGIN
    //login-negative
    // wrong password
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        BasicRunner.driver.get(loginPageURL);
    }

    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.usernameInput));
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }

    @When("The employee types in chomp! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.passwordInput));
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(BasicRunner.loginPage.loginButton));
        BasicRunner.loginPage.loginButton.click();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String alert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alert, "Wrong password for User");
    }

    //login-negative
    //wrong username
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.usernameInput));
        BasicRunner.loginPage.usernameInput.sendKeys("sicEmDawgs");
    }

    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.passwordInput));
        BasicRunner.loginPage.passwordInput.sendKeys("natchamps");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
        String alert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alert, "Username not found");
    }

    // login-positive
    @When("The employee types g8tor into username input")
    public void the_employee_types_g8tor_into_username_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.usernameInput));
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }

    @When("The employee types chomp! into password input")
    public void the_employee_types_chomp_into_password_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.passwordInput));
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }

    @Then("the employee should be on the Manager page")
    public void the_employee_should_be_on_the_manager_page() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(BasicRunner.loginPageURL)));
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, managerHomePageURL);
    }

    @Then("The employee should see their name Patty Pastiche on the home page")
    public void the_employee_should_see_their_name_patty_pastiche_on_the_home_page() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.managerHomePage.greeting));
        String greeting = BasicRunner.managerHomePage.greeting.getText();
        Assert.assertTrue(greeting.contains("Patty"));
        Assert.assertTrue(greeting.contains("Pastiche"));
    }

    //login-positive
    @When("The employee types ryeGuy into username input")
    public void the_employee_types_rye_guy_into_username_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.usernameInput));
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
    }

    @When("The employee types coolbeans into password input")
    public void the_employee_types_coolbeans_into_password_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.passwordInput));
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
    }

    @Then("the employee should be on the Tester page")
    public void the_employee_should_be_on_the_tester_page() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(BasicRunner.loginPageURL)));
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, testerHomePageURL);
    }

    @Then("The employee should see their name Fakey McFakeFace on the home page")
    public void the_employee_should_see_their_name_fakey_mc_fake_face_on_the_home_page() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.testerHomePage.greeting));
        String greeting = BasicRunner.testerHomePage.greeting.getText();
        Assert.assertTrue(greeting.contains("Fakey"));
        Assert.assertTrue(greeting.contains("McFakeFace"));

    }

    //login-positive
    @When("The employee types cavalier89 into username input")
    public void the_employee_types_cavalier89_into_username_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.usernameInput));

        BasicRunner.loginPage.usernameInput.sendKeys("cavalier89");
    }

    @When("The employee types alucard into password input")
    public void the_employee_types_alucard_into_password_input() {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.passwordInput));

        BasicRunner.loginPage.passwordInput.sendKeys("alucard");
    }

    @Then("The employee should see their name Dracula Fangs on the home page")
    public void the_employee_should_see_their_name_dracula_fangs_on_the_home_page() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.testerHomePage.greeting));
        String greeting = BasicRunner.testerHomePage.greeting.getText();
        Assert.assertTrue(greeting.contains("Dracula"));
        Assert.assertTrue(greeting.contains("Fangs"));
    }

}
