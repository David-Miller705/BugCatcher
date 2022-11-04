package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static com.revature.runners.BasicRunner.loginPageURL;

public class LoginSteps {

    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        BasicRunner.driver.get(loginPageURL);
    }

    @When("The employee types in {string} into the username input")
    public void the_employee_types_in_string_into_the_username_input(String username) {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.usernameInput));
        BasicRunner.loginPage.usernameInput.sendKeys(username);
    }

    @When("The employee types in {string} into the password input")
    public void the_employee_types_in_string_into_the_password_input(String password) {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.loginPage.passwordInput));
        BasicRunner.loginPage.passwordInput.sendKeys(password);
    }

    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(BasicRunner.loginPage.loginButton));
        BasicRunner.loginPage.loginButton.click();
    }

    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
        String alert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alert, "Wrong password for User");
    }

    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
        String alert = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(alert, "Username not found");
    }

    @Then("the employee should be on the {string} page")
    public void the_employee_should_be_on_the_role_page(String role) {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(loginPageURL)));
        String currentURL = BasicRunner.driver.getCurrentUrl();
        if (role.equals("Manager")) {
            Assert.assertEquals(currentURL, BasicRunner.managerHomePageURL);
        }
        if (role.equals("Tester")) {
            Assert.assertEquals(currentURL, BasicRunner.testerHomePageURL);
        }
    }

    @Then("The employee should see their name {string} {string} on the home page")
    public void the_employee_should_see_their_name_patty_pastiche_on_the_home_page(String firstName, String lastName) {
        //WebDriverWait webDriverWait = new WebDriverWait(BasicRunner.driver, Duration.ofSeconds(10));
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.managerHomePage.greeting));
        String greeting = BasicRunner.managerHomePage.greeting.getText();
        Assert.assertTrue(greeting.contains(firstName));
        Assert.assertTrue(greeting.contains(lastName));
    }

}
