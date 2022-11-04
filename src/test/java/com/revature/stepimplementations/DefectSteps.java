package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefectSteps {

    private String defectID = "placeholder";
    private int chosenDefect = 0;
    private String chosenTester = null;
    private Random random = new Random();

    // DEFECTS
    // assign-defect.feature
    //==============================================================================================================
    @Given("The manager is logged in as a manager")
    public void the_manager_is_logged_in_as_a_manager() throws InterruptedException {
        BasicRunner.login("g8tor", "chomp!");
    }
    @Given("The manager is on the home page")
    public void the_manager_is_on_the_home_page() throws InterruptedException {
        BasicRunner.page.homePageLink.click();
        BasicRunner.webDriverWait.until(ExpectedConditions.urlToBe(BasicRunner.managerHomePageURL));
    }
    @Then("The manager should see pending defects")
    public void the_manager_should_see_pending_defects() {
        int defectCount = BasicRunner.managerHomePage.pendingDefectsID.size();
        Assert.assertNotEquals(defectCount, 0);
        chosenDefect = random.nextInt(defectCount);
        defectID = BasicRunner.managerHomePage.pendingDefectsID.get(chosenDefect).getText();
    }
    @When("The manager clicks on the select button for a defect")
    public void the_manager_clicks_on_the_select_button_for_a_defect() {
        WebElement button = BasicRunner.managerHomePage.pendingDefectsSelect.get(chosenDefect);
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
    @Then("The defect description should appear in bold")
    public void the_defect_description_should_appear_in_bold() {
        Assert.assertEquals(BasicRunner.managerHomePage.boldDescription.getText(),
                BasicRunner.managerHomePage.pendingDefectsDescription.get(chosenDefect).getText());
    }
    @When("The manager selects an tester from the drop down")
    public void the_manager_selects_an_tester_from_the_drop_down() {
        int testerCount = BasicRunner.managerHomePage.employeeOptions.size();
        int chosenTesterIndex = random.nextInt(testerCount);
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(BasicRunner.managerHomePage.assignmentDropdown));
        chosenTester = BasicRunner.managerHomePage.employeeOptions.get(chosenTesterIndex).getAttribute("value");
        BasicRunner.managerHomePage.assignmentDropdown.sendKeys(chosenTester);
    }
    @When("The manager clicks assign")
    public void the_manager_clicks_assign() {
        WebElement button = BasicRunner.managerHomePage.assignButton;
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
    @Then("The defect should disappear from the list")
    public void the_defect_should_disappear_from_the_list() throws InterruptedException {
        // The removed ID will cause a staleElementReferenceException due to removing a defect from the list
        // So we wait for the element to detach from the dom then remove it from the list.
        BasicRunner.webDriverWait.until(ExpectedConditions.stalenessOf(BasicRunner.managerHomePage.pendingDefectsID.get(chosenDefect)));
        BasicRunner.managerHomePage.pendingDefectsID.remove(chosenDefect);
        //List<WebElement> stillPendingDefectsID = BasicRunner.driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        //BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOfAllElements(stillPendingDefectsID));
        for (WebElement e: BasicRunner.managerHomePage.pendingDefectsID) {
            Assert.assertNotEquals(e.getText(), defectID);
        }
    }
    @Given("The assigned tester is on their home page")
    public void the_assigned_tester_is_on_their_home_page() throws InterruptedException {
        String password = null;
        if (chosenTester.equals("ryeGuy")) {
            password = "coolbeans";
        } else if (chosenTester.equals("cavalier89")) {
            password = "alucard";
        }
        BasicRunner.login(chosenTester, password);
    }
    @Then("The tester should see the pending defect")
    public void the_tester_should_see_the_pending_defect() {
        boolean foundAssignedDefect = false;
        for (WebElement e: BasicRunner.testerHomePage.pendingDefectsID) {
            BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(e));
            if(e.getText().contains(defectID)) {
                foundAssignedDefect = true;
            }
        }
        Assert.assertTrue(foundAssignedDefect);
    }


    //defect-status.feature
    //==============================================================================================================
    @Given("The tester is on the Home Page")
    public void the_tester_is_on_the_home_page() throws InterruptedException {
        BasicRunner.login("ryeGuy", "coolbeans");
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.testerHomePageURL);
    }
    @Then("The tester can can see only defects assigned to them")
    public void the_tester_can_can_see_only_defects_assigned_to_them() throws InterruptedException {
        BasicRunner.webDriverWait.until(ExpectedConditions.urlToBe(BasicRunner.testerHomePageURL));

        for (WebElement defect: BasicRunner.testerHomePage.pendingDefectsCollapseButtons) {
            // Get CSS transition delay (400ms)
            String transitionDelay = defect.findElement(By.xpath("./following-sibling::div"))
                    .getCssValue("transition").split(" ")[1];
            long milliSeconds = (long) (Float.parseFloat(transitionDelay.split("s")[0])*1000);

            BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(defect));
            defect.click();
            // Wait for CSS transition delay
            // If you don't wait for the transition to finish, the next <span> moves out of the way even
            // though there was an explicit wait for it to be visible and clickable
            BasicRunner.actions.pause(milliSeconds).perform();
        }

        for (WebElement assignedTo: BasicRunner.testerHomePage.pendingDefectsAssignment) {
            Assert.assertTrue(assignedTo.getText().contains("ryeGuy"));
        }
    }
    @When("The tester changes the defect to {string}")
    public void the_tester_changes_to_defect_to_any_status(String status) throws InterruptedException {
        int pendingDefects = BasicRunner.testerHomePage.pendingDefectsCollapseButtons.size();
        Assert.assertEquals(BasicRunner.testerHomePage.pendingDefectsChangeStatusButtons.size(), pendingDefects);

        for (int i=0; i<pendingDefects; i++) {
            WebElement button = BasicRunner.testerHomePage.pendingDefectsChangeStatusButtons.get(i);
            BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
            switch(status) {
                case "Accepted":
                    button = BasicRunner.testerHomePage.pendingDefectsChangeStatusToAcceptedButtons.get(i);
                    BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                    button.click();
                    break;
                case "Rejected":
                    button = BasicRunner.testerHomePage.pendingDefectsChangeStatusToRejectedButtons.get(i);
                    BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                    button.click();
                    break;
                case "Fixed":
                    button = BasicRunner.testerHomePage.pendingDefectsChangeStatusToFixedButtons.get(i);
                    BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                    button.click();
                    break;
                case "Declined":
                    button = BasicRunner.testerHomePage.pendingDefectsChangeStatusToDeclinedButtons.get(i);
                    BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                    button.click();
                    break;
                case "Shelved":
                    button = BasicRunner.testerHomePage.pendingDefectsChangeStatusToShelvedButtons.get(i);
                    BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                    button.click();
                    break;
                default:
                    Assert.fail("Status \"" + status + "\" is not a valid status");

            }
        }

    }
    @Then("The tester should see the defect has a {string} status")
    public void the_tester_should_see_the_defect_has_a_different_status(String status) {
        int pendingDefects = BasicRunner.testerHomePage.pendingDefectsCollapseButtons.size();
        for (int i=0; i<pendingDefects; i++) {
            WebElement row = BasicRunner.testerHomePage.pendingDefectsStatusText.get(i);
            BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(row));
            System.out.println(status + Integer.toString(i));
            Assert.assertTrue(row.getText().contains(status));
        }

    }


    //report-defect-negative
    //Steps too short
    //==============================================================================================================
    @Given("The employee is on the Defect Reporter Page")
    public void the_employee_is_on_the_defect_reporter_page() throws InterruptedException {
        BasicRunner.login("ryeGuy", "coolbeans");
        BasicRunner.testerHomePage.defectReporterLink.click();
        BasicRunner.webDriverWait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(BasicRunner.testerHomePageURL)));
        String currentURL = BasicRunner.driver.getCurrentUrl();
        Assert.assertEquals(currentURL, BasicRunner.defectReporterPageURL);
    }
    @When("The employee selects todays date")
    public void the_employee_selects_todays_date() throws InterruptedException {
        String date = java.time.LocalDate.now().toString();
        // Need to convert YYYY-MM-DD to MM-DD-YYYY
        date = date.substring(5,7) + "-" + date.substring(8,10) + "-" + date.substring(0, 4);
        BasicRunner.defectReporterPage.dateInput.sendKeys(date);
    }
    @When("The employee types in {string} with")
    public void the_employee_types_in_with(String string, String docString) {
        if (string.equals("Description")) {
            BasicRunner.defectReporterPage.descriptionInput.sendKeys(docString);
        } else if (string.equals("Steps")) {
            BasicRunner.defectReporterPage.stepsToReproduceInput.sendKeys(docString);
        }
    }
    @When("The employee selects high priority")
    public void the_employee_selects_high_priority() throws InterruptedException {
        Actions myAction = new Actions(BasicRunner.driver);
        int width = BasicRunner.defectReporterPage.severityInput.getSize().getWidth();
        int min = Integer.parseInt(BasicRunner.defectReporterPage.severityInput.getAttribute("min"));
        int max = Integer.parseInt(BasicRunner.defectReporterPage.severityInput.getAttribute("max"));
        int step = 1;
        try {
            step = Integer.parseInt(BasicRunner.defectReporterPage.severityInput.getAttribute("step"));
        } catch (NumberFormatException e) {
            step = 1;
        }
        int choice = max-min;
        int target = 0;
        try {
            target = (choice*step*width)/(max-min);
        } catch (ArithmeticException e) {
            target = 0;
        }
        // Clicking the web element places cursor in the center of the object, so we move left by half the width to be at the start,
        // then move to the appropriate spot in the interval [min, max]
        myAction.clickAndHold(BasicRunner.defectReporterPage.severityInput)
                .moveByOffset(-width/2, 0)
                .moveByOffset(target, 0)
                .release()
                .build()
                .perform();
        //Thread.sleep(1000);
        Assert.assertEquals(BasicRunner.defectReporterPage.priorityText.getText(), "High");
    }
    @When("The employee selects low severity")
    public void the_employee_selects_low_severity() throws InterruptedException {
        Actions myAction = new Actions(BasicRunner.driver);
        int width = BasicRunner.defectReporterPage.severityInput.getSize().getWidth();
        int min = Integer.parseInt(BasicRunner.defectReporterPage.severityInput.getAttribute("min"));
        int max = Integer.parseInt(BasicRunner.defectReporterPage.severityInput.getAttribute("max"));
        int step = 1;
        try {
            step = Integer.parseInt(BasicRunner.defectReporterPage.severityInput.getAttribute("step"));
        } catch (NumberFormatException e) {
            step = 1;
        }
        int choice = min-min;
        int target = 0;
        try {
            target = (choice*step*width)/(max-min);
        } catch (ArithmeticException e) {
            target = 0;
        }
        myAction.clickAndHold(BasicRunner.defectReporterPage.severityInput)
                .moveByOffset(-width/2, 0)
                .moveByOffset(target, 0)
                .release()
                .build()
                .perform();
        //Thread.sleep(1000);
        Assert.assertEquals(BasicRunner.defectReporterPage.severityText.getText(), "LOW");
    }
    @When("The employee clicks the report button")
    public void the_employee_clicks_the_report_button() {
        WebElement button = BasicRunner.defectReporterPage.reportButton;
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
    @Then("No confirmation dialog appears")
    public void no_confirmation_dialog_appears() throws InterruptedException {
        Assert.assertThrows(NoAlertPresentException.class, () -> {
            BasicRunner.driver.switchTo().alert();
        });
    }

    //report-defect-negative
    //Description too short

    //report-defect-negative
    //No date selected


    //report-defect-positive
    @Then("There should be a confirmation box")
    public void there_should_be_a_confirmation_box() {
        BasicRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = BasicRunner.driver.switchTo().alert();
        String message = alert.getText();
        Assert.assertEquals(message, "Confirm Bug Report?");
    }
    @When("The employee clicks Ok")
    public void the_employee_clicks_ok() {
        BasicRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = BasicRunner.driver.switchTo().alert();
        alert.accept();
    }
    @Then("A modal should appear with a Defect ID")
    public void a_modal_should_appear_with_a_defect_id() throws InterruptedException {
        WebElement text = BasicRunner.defectReporterPage.defectID;
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(text));
        String message = text.getText();
        Pattern pattern = Pattern.compile("^Defect [0-9]+ created$");
        Matcher matcher = pattern.matcher(message);
        Assert.assertTrue(matcher.find());
    }
    @When("The employee clicks close")
    public void the_employee_clicks_close() {
        WebElement button = BasicRunner.defectReporterPage.closeButton;
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }
    @Then("The modal should disappear")
    public void the_modal_should_disappear() {
        List<WebElement> children = BasicRunner.driver.findElements(By.xpath("//div[@class='ReactModalPortal']/*"));
        Assert.assertEquals(children.size(), 0);
    }

}
