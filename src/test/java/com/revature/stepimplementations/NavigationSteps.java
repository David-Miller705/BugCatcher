package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class NavigationSteps {

    // NAVIGATION ***************************************************************************************************
    // Home page links visible

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        Assert.assertTrue(BasicRunner.managerHomePage.matricesLink.isDisplayed());
        Assert.assertTrue(BasicRunner.managerHomePage.testCasesLink.isDisplayed());
        Assert.assertTrue(BasicRunner.managerHomePage.defectReporterLink.isDisplayed());
        Assert.assertTrue(BasicRunner.managerHomePage.defectOverviewLink.isDisplayed());
    }

    // Back Navigation
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        BasicRunner.managerHomePage.matricesLink.click();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        String currentTitle = BasicRunner.driver.getTitle();
        Assert.assertEquals(currentTitle, "Matrix Page");
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        BasicRunner.driver.navigate().back();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.managerHomePageURL);
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Home");
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        BasicRunner.managerHomePage.testCasesLink.click();
    }

    // All Links Viable
    // Matrices
    // Overview misspelled
    @Then("The title of page should be Matrix Overivew")
    public void the_title_of_page_should_be_matrix_overivew() {
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Matrix Overview");
    }

    // Test Cases
    @Then("The title of page should be Test Case Overivew")
    public void the_title_of_page_should_be_test_case_overivew() {
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Test Case Overview");
    }

    // Report defect
    @When("The manager clicks on Report a Defect")
    public void the_manager_clicks_on_report_a_defect() {
        BasicRunner.managerHomePage.defectReporterLink.click();
    }
    @Then("The title of page should be Defect Reporter")
    public void the_title_of_page_should_be_defect_reporter() {
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Defect Reporter");
    }

    // Defect Overview
    @When("The manager clicks on Defect Overview")
    public void the_manager_clicks_on_defect_overview() {
        BasicRunner.managerHomePage.defectOverviewLink.click();
    }
    @Then("The title of page should be Defect Overview")
    public void the_title_of_page_should_be_defect_overview() {
        Assert.assertEquals(BasicRunner.driver.getTitle(), "Defect Overview");
    }

}
