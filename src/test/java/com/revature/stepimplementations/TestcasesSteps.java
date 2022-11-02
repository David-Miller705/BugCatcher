package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class TestcasesSteps {

    private String lastTestcaseID = null;
    private String newTestcaseID = null;
    private String currentTestcaseID = null;
    private String modalTestcaseID = null;

    private String originalDescription = null;
    private String originalSteps = null;
    private String originalAutomation = null;
    private String originalPerformedBy = null;
    private String originalTestResult = null;
    private String originalSummary = null;

    private Random random = new Random();


    // TESTCASES
    // Add a test case
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() throws InterruptedException {
        BasicRunner.driver.get(BasicRunner.loginPageURL);
        Thread.sleep(500);
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(500);
        BasicRunner.testerHomePage.testCasesLink.click();
        Thread.sleep(500);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.testcasesPageURL);
        int testCount = BasicRunner.testcasesPage.testcases.size();
        if (testCount > 0) {
            lastTestcaseID = BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td[1]")).getText();
        }
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String string, String docString) {
        if (string.equals("Description")) {
            BasicRunner.testcasesPage.descriptionTextbox.sendKeys(docString);
        } else if (string.equals("Steps")) {
            BasicRunner.testcasesPage.stepsTextbox.sendKeys(docString);
        }
    }
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() throws InterruptedException {
        BasicRunner.testcasesPage.submitButton.click();
        Thread.sleep(500);
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        int testCount = BasicRunner.testcasesPage.testcases.size();
        Assert.assertTrue(testCount > 0);
        newTestcaseID = BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td[1]")).getText();
        Assert.assertNotEquals(lastTestcaseID, newTestcaseID);
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        int testCount = BasicRunner.testcasesPage.testcases.size();
        Assert.assertTrue(testCount > 0);
        String currentLastTestStatus = BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td[3]")).getText();
        Assert.assertEquals(currentLastTestStatus, "UNEXECUTED");
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() throws InterruptedException {
        int testCount = BasicRunner.testcasesPage.testcases.size();
        Assert.assertTrue(testCount > 0);
        currentTestcaseID = BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td[1]")).getText();
        BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td/button")).click();
        Thread.sleep(500);
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        modalTestcaseID = BasicRunner.testcasesPage.modalID.getText().split(" ")[1];
        Assert.assertEquals(modalTestcaseID, currentTestcaseID);
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        String performedBy = BasicRunner.testcasesPage.modalPerformedBy.getText();
        Assert.assertEquals(performedBy, "No One");
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() throws InterruptedException {
        BasicRunner.testcasesPage.modalCloseButton.click();
        Thread.sleep(500);
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        List<WebElement> children = BasicRunner.driver.findElements(By.xpath("//div[@class='ReactModalPortal']/*"));
        Assert.assertEquals(children.size(), 0);
    }

    // Edit testcase

    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() throws InterruptedException {
        int testCount = BasicRunner.testcasesPage.testcases.size();
        Assert.assertTrue(testCount > 0);
        currentTestcaseID = BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td[1]")).getText();
        BasicRunner.testcasesPage.testcases.get(testCount-1).findElement(By.xpath("./td/button")).click();
        Thread.sleep(500);
    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() throws InterruptedException {
        modalTestcaseID = BasicRunner.testcasesPage.modalID.getText().split(" ")[1];
        BasicRunner.testcasesPage.modalEditButton.click();
        Thread.sleep(500);
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        String editTestcaseID = BasicRunner.testcasesEditPage.testcaseID.getText();
        Assert.assertTrue(editTestcaseID.contains(currentTestcaseID));
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        Assert.assertFalse(BasicRunner.testcasesEditPage.descriptionInput.isEnabled());
        Assert.assertFalse(BasicRunner.testcasesEditPage.stepsInput.isEnabled());
        Assert.assertEquals(BasicRunner.testcasesEditPage.automatedInput.getTagName(), "p");
        Assert.assertEquals(BasicRunner.testcasesEditPage.performedByInput.getTagName(), "p");
        Assert.assertEquals(BasicRunner.testcasesEditPage.testResultsInput.getTagName(), "p");
        Assert.assertFalse(BasicRunner.testcasesEditPage.summaryInput.isEnabled());

    }
    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() throws InterruptedException {
        BasicRunner.testcasesEditPage.editButton.click();
        Thread.sleep(500);
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        Assert.assertTrue(BasicRunner.testcasesEditPage.descriptionInput.isEnabled());
        Assert.assertTrue(BasicRunner.testcasesEditPage.stepsInput.isEnabled());
        Assert.assertEquals(BasicRunner.testcasesEditPage.automatedInput.getTagName(), "input");
        Assert.assertEquals(BasicRunner.testcasesEditPage.performedByInput.getTagName(), "select");
        Assert.assertEquals(BasicRunner.testcasesEditPage.testResultsInput.getTagName(), "select");
        Assert.assertTrue(BasicRunner.testcasesEditPage.summaryInput.isEnabled());

    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        BasicRunner.testcasesEditPage.descriptionInput.sendKeys("New description");
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        BasicRunner.testcasesEditPage.stepsInput.sendKeys("New steps");
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() throws InterruptedException {
        BasicRunner.testcasesEditPage.automatedInput.click();
        Thread.sleep(500);
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        BasicRunner.testcasesEditPage.performedByInput.sendKeys("ryeGuy");
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        BasicRunner.testcasesEditPage.testResultsInput.sendKeys("FAIL");
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        BasicRunner.testcasesEditPage.summaryInput.sendKeys("tl;dr");
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() throws InterruptedException {
        BasicRunner.testcasesEditPage.saveButton.click();
        Thread.sleep(500);
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        String confirmation = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(confirmation, "Are you sure you want to update the test case?");
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() throws InterruptedException {
        BasicRunner.driver.switchTo().alert().accept();
        Thread.sleep(500);
    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        String message = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(message, "Test Case has been Saved");
        BasicRunner.driver.switchTo().alert().dismiss();
    }

    //Reset testcase

    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() throws InterruptedException {
        BasicRunner.driver.get(BasicRunner.loginPageURL);
        Thread.sleep(500);
        BasicRunner.loginPage.usernameInput.sendKeys("ryeGuy");
        BasicRunner.loginPage.passwordInput.sendKeys("coolbeans");
        BasicRunner.loginPage.loginButton.click();
        Thread.sleep(500);
        BasicRunner.testerHomePage.testCasesLink.click();
        Thread.sleep(500);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.testcasesPageURL);

        int testCount = BasicRunner.testcasesPage.testcases.size();
        Assert.assertNotEquals(testCount, 0);

        int chosenTestcase = random.nextInt(testCount);
        BasicRunner.testcasesPage.testcases.get(chosenTestcase).findElement(By.xpath(".//button")).click();
        Thread.sleep(500);
        BasicRunner.testcasesPage.modalEditButton.click();
        Thread.sleep(500);

        originalDescription = BasicRunner.testcasesEditPage.descriptionInput.getText();
        originalSteps = BasicRunner.testcasesEditPage.stepsInput.getText();
        originalAutomation = BasicRunner.testcasesEditPage.automatedInput.getText();
        originalPerformedBy = BasicRunner.testcasesEditPage.performedByInput.getText();
        originalTestResult = BasicRunner.testcasesEditPage.testResultsInput.getText();
        originalSummary = BasicRunner.testcasesEditPage.summaryInput.getText();
    }
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        BasicRunner.testcasesEditPage.resetButton.click();
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        Assert.assertEquals(originalDescription, BasicRunner.testcasesEditPage.descriptionInput.getText());
        Assert.assertEquals(originalSteps, BasicRunner.testcasesEditPage.stepsInput.getText());
        Assert.assertEquals(originalAutomation, BasicRunner.testcasesEditPage.automatedInput.getText());
        Assert.assertEquals(originalPerformedBy, BasicRunner.testcasesEditPage.performedByInput.getText());
        Assert.assertEquals(originalTestResult, BasicRunner.testcasesEditPage.testResultsInput.getText());
        Assert.assertEquals(originalSummary, BasicRunner.testcasesEditPage.summaryInput.getText());
    }

}
