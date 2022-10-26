package com.revature.purgatory;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Steps {

    public static String loginPageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/?dev=5";
    public static String managerHomePageURL = "https://bugcatcher-jasdhir.coe.revaturelabs.com/managerhome";



    // DEFECTS *****************************************************************************************************
    // assign-defect.feature
    //==============================================================================================================
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


    //defect-status.feature
    //==============================================================================================================
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester changes to defect to any status")
    public void the_tester_changes_to_defect_to_any_status() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The tester should see the defect has a different status")
    public void the_tester_should_see_the_defect_has_a_different_status() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }


    //report-defect-negative
    //Steps too short
    //==============================================================================================================
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
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
    //==============================================================================================================
//    @Given("The employee is on the Defect Reporter Page")
//    public void the_employee_is_on_the_defect_reporter_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects todays date")
//    public void the_employee_selects_todays_date() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee types in {string} with")
//    public void the_employee_types_in_with(String string, String docString) {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects high priority")
//    public void the_employee_selects_high_priority() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects low severity")
//    public void the_employee_selects_low_severity() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee clicks the report button")
//    public void the_employee_clicks_the_report_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @Then("No confirmation dialog appears")
//    public void no_confirmation_dialog_appears() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }

    //report-defect-negative
    //No date selected

    //==============================================================================================================
//    @Given("The employee is on the Defect Reporter Page")
//    public void the_employee_is_on_the_defect_reporter_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee types in {string} with")
//    public void the_employee_types_in_with(String string, String docString) {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects high priority")
//    public void the_employee_selects_high_priority() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects low severity")
//    public void the_employee_selects_low_severity() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee clicks the report button")
//    public void the_employee_clicks_the_report_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @Then("No confirmation dialog appears")
//    public void no_confirmation_dialog_appears() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }

    //report-defect-positive
    //==============================================================================================================
//    @Given("The employee is on the Defect Reporter Page")
//    public void the_employee_is_on_the_defect_reporter_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects todays date")
//    public void the_employee_selects_todays_date() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee types in {string} with")
//    public void the_employee_types_in_with(String string, String docString) {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects high priority")
//    public void the_employee_selects_high_priority() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee selects low severity")
//    public void the_employee_selects_low_severity() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The employee clicks the report button")
//    public void the_employee_clicks_the_report_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
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



    // LOGIN ****************************************************************************************************
    //login-negative
    // wrong password
    @Given("The employee is on the login page")
    public void the_employee_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        BasicRunner.driver.get(loginPageURL);
    }
    @When("The employee types in g8tor into the username input")
    public void the_employee_types_in_g8tor_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }
    @When("The employee types in chomp! into the password input")
    public void the_employee_types_in_chomp_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }
    @When("The employee clicks on the login button")
    public void the_employee_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        BasicRunner.loginPage.loginButton.click();
    }
    @Then("The employee should see an alert saying they have the wrong password")
    public void the_employee_should_see_an_alert_saying_they_have_the_wrong_password() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    //login-negative
    //wrong username
//    @Given("The employee is on the login page")
//    public void the_employee_is_on_the_login_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The employee types in sicEmDawgs into the username input")
    public void the_employee_types_in_sic_em_dawgs_into_the_username_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee types in natchamps into the password input")
    public void the_employee_types_in_natchamps_into_the_password_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
//    @When("The employee clicks on the login button")
//    public void the_employee_clicks_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @Then("The employee should see an alert saying no user with that username found")
    public void the_employee_should_see_an_alert_saying_no_user_with_that_username_found() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // login-positive
//    @Given("The employee is on the login page")
//    public void the_employee_is_on_the_login_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The employee types g8tor into username input")
    public void the_employee_types_g8tor_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        BasicRunner.loginPage.usernameInput.sendKeys("g8tor");
    }
    @When("The employee types chomp! into password input")
    public void the_employee_types_chomp_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        BasicRunner.loginPage.passwordInput.sendKeys("chomp!");
    }
//    @When("The employee clicks on the login button")
//    public void the_employee_clicks_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @Then("the employee should be on the Manager page")
    public void the_employee_should_be_on_the_manager_page() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        Thread.sleep(2000);
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, managerHomePageURL);
    }
    @Then("The employee should see their name Patty Pastiche on the home page")
    public void the_employee_should_see_their_name_patty_pastiche_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
        String greeting = BasicRunner.managerHomePage.greeting.getText();

        Assert.assertTrue(greeting.contains("Patty"));
        Assert.assertTrue(greeting.contains("Pastiche"));

    }

    //login-positive
//    @Given("The employee is on the login page")
//    public void the_employee_is_on_the_login_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The employee types ryeGuy into username input")
    public void the_employee_types_rye_guy_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee types coolbeans into password input")
    public void the_employee_types_coolbeans_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
//    @When("The employee clicks on the login button")
//    public void the_employee_clicks_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @Then("the employee should be on the Tester page")
    public void the_employee_should_be_on_the_tester_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The employee should see their name Fakey McFakeFace on the home page")
    public void the_employee_should_see_their_name_fakey_mc_fake_face_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    //login-positive
//    @Given("The employee is on the login page")
//    public void the_employee_is_on_the_login_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The employee types cavalier89 into username input")
    public void the_employee_types_cavalier89_into_username_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The employee types alucard into password input")
    public void the_employee_types_alucard_into_password_input() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
//    @When("The employee clicks on the login button")
//    public void the_employee_clicks_on_the_login_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @Then("the employee should be on the Tester page")
//    public void the_employee_should_be_on_the_tester_page() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @Then("The employee should see their name Dracula Fangs on the home page")
    public void the_employee_should_see_their_name_dracula_fangs_on_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // MATRIX ********************************************************************************************************

    // create new matrix
    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // Update Defects
    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // Update Test Cases
//    @Given("A manager or tester has selected a matrix")
//    public void a_manager_or_tester_has_selected_a_matrix() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
//    @When("A manager or tester confirms their changes")
//    public void a_manager_or_tester_confirms_their_changes() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @Then("Then the matrix should saved")
//    public void then_the_matrix_should_saved() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }

    // NAVIGATION ***************************************************************************************************
    // Home page links visible

    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // Back Navigation
    @When("The manager clicks on Matrices")
    public void the_manager_clicks_on_matrices() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The title of the page should be Matrix Page")
    public void the_title_of_the_page_should_be_matrix_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks the browser back button")
    public void the_manager_clicks_the_browser_back_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The manager should be on the home page and the title of page is Home")
    public void the_manager_should_be_on_the_home_page_and_the_title_of_page_is_home() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The manager clicks on Test Cases")
    public void the_manager_clicks_on_test_cases() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // All Links Viable
    // Matricies
//    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
//    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The manager clicks on Matrices")
//    public void the_manager_clicks_on_matrices() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @Then("The title of page should be Matrix Overivew")
    public void the_title_of_page_should_be_matrix_overivew() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    
    // Test Cases
//    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
//    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The manager clicks on Test Cases")
//    public void the_manager_clicks_on_test_cases() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @Then("The title of page should be Test Case Overivew")
    public void the_title_of_page_should_be_test_case_overivew() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    
    // Report defect
//    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
//    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The manager clicks on Report a Defect")
    public void the_manager_clicks_on_report_a_defect() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The title of page should be Defect Reporter")
    public void the_title_of_page_should_be_defect_reporter() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // Defect Overview

//    @Then("The manager should see links for Matrices, Test Cases, Defect Reporting and Defect Overview")
//    public void the_manager_should_see_links_for_matrices_test_cases_defect_reporting_and_defect_overview() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The manager clicks on Defect Overview")
    public void the_manager_clicks_on_defect_overview() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The title of page should be Defect Overview")
    public void the_title_of_page_should_be_defect_overview() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // TESTCASES *****************************************************************************************************
    //Add a test case
    @Given("The tester is on the test case dashboard")
    public void the_tester_is_on_the_test_case_dashboard() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester types {string} into input with")
    public void the_tester_types_into_input_with(String string, String docString) {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester presses the submit button")
    public void the_tester_presses_the_submit_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The test case should appear at the bottom of the table")
    public void the_test_case_should_appear_at_the_bottom_of_the_table() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The test case result should say UNEXECUTED")
    public void the_test_case_result_should_say_unexecuted() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester presses on details")
    public void the_tester_presses_on_details() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("A test case modal should appear showing the case ID")
    public void a_test_case_modal_should_appear_showing_the_case_id() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The performed by field should say No One")
    public void the_performed_by_field_should_say_no_one() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester presses the close buttton")
    public void the_tester_presses_the_close_buttton() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The Modal Should be closed")
    public void the_modal_should_be_closed() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    // Edit testcase

//    @Given("The tester is on the test case dashboard")
//    public void the_tester_is_on_the_test_case_dashboard() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The tester clicks on details")
    public void the_tester_clicks_on_details() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
//    @Then("A test case modal should appear showing the case ID")
//    public void a_test_case_modal_should_appear_showing_the_case_id() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The Tester clicks on edit within the modal")
    public void the_tester_clicks_on_edit_within_the_modal() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The Tester should be on the case editor for that case")
    public void the_tester_should_be_on_the_case_editor_for_that_case() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The fields should be uneditable")
    public void the_fields_should_be_uneditable() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester clicks on the edit button")
    public void the_tester_clicks_on_the_edit_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The test case fields should be editable")
    public void the_test_case_fields_should_be_editable() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester types in a new description into the description text area")
    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester types in a new steps into the steps text area")
    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester clicks on the automated check mark")
    public void the_tester_clicks_on_the_automated_check_mark() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester selects ryeGuy for performed from drop down")
    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester selects FAIL for test result from drop down")
    public void the_tester_selects_fail_for_test_result_from_drop_down() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester types in a new summary into the summary text area")
    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester clicks save on test case page")
    public void the_tester_clicks_save_on_test_case_page() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("A confirmation prompt should appear")
    public void a_confirmation_prompt_should_appear() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @When("The tester clicks on Ok")
    public void the_tester_clicks_on_ok() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("An alert says the test case has been saved")
    public void an_alert_says_the_test_case_has_been_saved() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

    //Reset testcase

    @Given("the tester is on the test case editor for a specific test case")
    public void the_tester_is_on_the_test_case_editor_for_a_specific_test_case() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
//    @Then("The fields should be uneditable")
//    public void the_fields_should_be_uneditable() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The Tester clicks on the edit button")
//    public void the_tester_clicks_on_the_edit_button() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @Then("The test case fields should be editable")
//    public void the_test_case_fields_should_be_editable() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The tester types in a new description into the description text area")
//    public void the_tester_types_in_a_new_description_into_the_description_text_area() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The tester types in a new steps into the steps text area")
//    public void the_tester_types_in_a_new_steps_into_the_steps_text_area() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The tester clicks on the automated check mark")
//    public void the_tester_clicks_on_the_automated_check_mark() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The tester selects ryeGuy for performed from drop down")
//    public void the_tester_selects_rye_guy_for_performed_from_drop_down() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The tester selects FAIL for test result from drop down")
//    public void the_tester_selects_fail_for_test_result_from_drop_down() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
//    @When("The tester types in a new summary into the summary text area")
//    public void the_tester_types_in_a_new_summary_into_the_summary_text_area() {
//        // Write code here that turns the phrase above into concrete actions
//        //throw new io.cucumber.java.PendingException();
//    }
    @When("The tester clicks on the reset button")
    public void the_tester_clicks_on_the_reset_button() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }
    @Then("The fields should be populated to their old values")
    public void the_fields_should_be_populated_to_their_old_values() {
        // Write code here that turns the phrase above into concrete actions
        //throw new io.cucumber.java.PendingException();
    }

}
