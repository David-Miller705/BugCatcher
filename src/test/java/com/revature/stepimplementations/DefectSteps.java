package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DefectSteps {

    // DEFECTS
    // assign-defect.feature
    //==============================================================================================================
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        // Note to self, this code already exists as its own test
        // Maybe there is a way to refactor this intelligently
        // Attempt to run this test after the positive login test for manager and do nothing here.
        BasicRunner.driver.get(BasicRunner.loginPageURL);
        Thread.sleep(500);
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
        BasicRunner.loginPage.loginButton.click();
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() throws InterruptedException {
        Thread.sleep(500);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.managerHomePageURL);
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {

    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {

    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {

    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {

    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {

    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {

    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() throws InterruptedException {
        BasicRunner.driver.get(BasicRunner.loginPageURL);
        Thread.sleep(500);
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(500);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.testerHomePageURL);
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {

    }


    //defect-status.feature
    //==============================================================================================================
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() throws InterruptedException {
        BasicRunner.driver.get(BasicRunner.loginPageURL);
        Thread.sleep(500);
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(500);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.testerHomePageURL);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() throws InterruptedException {
        Thread.sleep(250);
        for (WebElement defect: BasicRunner.testerHomePage.pendingDefectsCollapseButtons) {
            defect.click();
            Thread.sleep(500);
        }
        //Thread.sleep(1000);
        for (WebElement assignedTo: BasicRunner.testerHomePage.pendingDefectsAssignment) {
            Assert.assertTrue(assignedTo.getText().contains("ryeGuy"));
        }
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        int pendingDefects = BasicRunner.testerHomePage.pendingDefectsCollapseButtons.size();
        Assert.assertEquals(BasicRunner.testerHomePage.pendingDefectsChangeStatusButtons.size(), pendingDefects);
        Assert.assertEquals(BasicRunner.testerHomePage.pendingDefectsChangeStatusToAcceptedButtons.size(), pendingDefects);

        for (int i=0; i<pendingDefects; i++) {
            //BasicRunner.testerHomePage.pendingDefectsCollapseButtons.get(i).click();
            BasicRunner.testerHomePage.pendingDefectsChangeStatusButtons.get(i).click();

            BasicRunner.testerHomePage.pendingDefectsChangeStatusToAcceptedButtons.get(i).click();
            //BasicRunner.testerHomePage.pendingDefectsChangeStatusToRejectedButtons.get(i).click();
            //BasicRunner.testerHomePage.pendingDefectsChangeStatusToFixedButtons.get(i).click();
            //BasicRunner.testerHomePage.pendingDefectsChangeStatusToDeclinedButtons.get(i).click();
            //BasicRunner.testerHomePage.pendingDefectsChangeStatusToShelvedButtons.get(i).click();
        }

    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        int pendingDefects = BasicRunner.testerHomePage.pendingDefectsCollapseButtons.size();
        for (int i=0; i<pendingDefects; i++) {
            Assert.assertTrue(BasicRunner.testerHomePage.pendingDefectsStatusText.get(i).getText().contains("Accepted"));
            //Assert.assertTrue(BasicRunner.testerHomePage.pendingDefectsStatusText.get(i).getText().contains("Rejected"));
            //Assert.assertTrue(BasicRunner.testerHomePage.pendingDefectsStatusText.get(i).getText().contains("Fixed"));
            //Assert.assertTrue(BasicRunner.testerHomePage.pendingDefectsStatusText.get(i).getText().contains("Declined"));
            //Assert.assertTrue(BasicRunner.testerHomePage.pendingDefectsStatusText.get(i).getText().contains("Shelved"));
        }
    }


    //report-defect-negative
    //Steps too short
    //==============================================================================================================
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() throws InterruptedException {
        BasicRunner.driver.get(BasicRunner.loginPageURL);
        Thread.sleep(500);
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(500);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.testerHomePageURL);
        BasicRunner.testerHomePage.defectReporterLink.click();
        Thread.sleep(500);
        currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.defectReporterPageURL);
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {

    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) {

    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {

    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    //report-defect-negative
    //Description too short

    //report-defect-negative
    //No date selected


    //report-defect-positive
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


}
