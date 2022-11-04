package com.revature.stepimplementations;

import com.revature.runners.BasicRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;
import java.util.Random;

public class MatrixSteps {

    private int randomPart = 0;
    private boolean manager = true;
    private boolean add = true;
    private int chosenMatrix = 0;
    private int chosenRequirement = 0;
    private int defectCount = 0;
    private int chosenDefect = 0;

    private int testcaseCount = 0;
    private int chosenTestcase = 0;

    private Random random = new Random();

    // MATRIX
    // create new matrix
    @Given("A manager is on their home page")
    public void a_manager_is_on_their_home_page() {
        BasicRunner.login("g8tor", "chomp!");
    }
    @Then("A manager can pull up a form to make a new matrix")
    public void a_manager_can_pull_up_a_form_to_make_a_new_matrix() {
        Assert.assertTrue(BasicRunner.managerHomePage.newMatrixButton.isDisplayed());
        BasicRunner.managerHomePage.newMatrixButton.click();
    }
    @When("A manager creates a title for a matrix")
    public void a_manager_creates_a_title_for_a_matrix() {
        randomPart = random.nextInt(1_000_000);
        BasicRunner.managerHomePage.matrixTitle.sendKeys("New Title"+Integer.toString(randomPart));
    }
    @When("A manager adds requirements to a matrix")
    public void a_manager_adds_requirements_to_a_matrix() {
        BasicRunner.managerHomePage.matrixRequirement.sendKeys("New Requirement");
        BasicRunner.managerHomePage.matrixPriority.sendKeys("Medium");
        BasicRunner.managerHomePage.matrixNote.sendKeys("New Note");
        BasicRunner.managerHomePage.addRequirementButton.click();
    }
    @When("A manager saves a matrix")
    public void a_manager_saves_a_matrix() {
        BasicRunner.managerHomePage.createMatrixButton.click();
        BasicRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
        BasicRunner.driver.switchTo().alert().dismiss();
    }
    @Then("The matrix should be visible for all testers and managers")
    public void the_matrix_should_be_visible_for_all_testers_and_managers() {
        String addedTitle = "New Title"+Integer.toString(randomPart);
        String lastTitle = null;
        BasicRunner.login("g8tor", "chomp!");
        BasicRunner.managerHomePage.matricesLink.click();
        BasicRunner.webDriverWait.until(ExpectedConditions.urlToBe(BasicRunner.matricesPageURL));
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOfAllElements(BasicRunner.matricesPage.matrices));
        lastTitle = BasicRunner.matricesPage.matrices.get(BasicRunner.matricesPage.matrices.size()-1).getText().split("\n")[0];
        Assert.assertEquals(lastTitle, addedTitle);

        // Check if tester can see it
        BasicRunner.login("ryeGuy", "coolbeans");
        BasicRunner.testerHomePage.matricesLink.click();
        BasicRunner.webDriverWait.until(ExpectedConditions.urlToBe(BasicRunner.matricesPageURL));
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOfAllElements(BasicRunner.matricesPage.matrices));
        lastTitle = BasicRunner.matricesPage.matrices.get(BasicRunner.matricesPage.matrices.size()-1).getText().split("\n")[0];
        Assert.assertEquals(lastTitle, addedTitle);

    }

    // Update Defects
    @Given("A manager or tester has selected a matrix")
    public void a_manager_or_tester_has_selected_a_matrix() {
        manager = random.nextBoolean();
        if (manager) {
            BasicRunner.login("g8tor", "chomp!");
            BasicRunner.managerHomePage.matricesLink.click();
        } else {
            BasicRunner.login("ryeGuy", "coolbeans");
            BasicRunner.managerHomePage.matricesLink.click();
        }
        BasicRunner.webDriverWait.until(ExpectedConditions.urlToBe(BasicRunner.matricesPageURL));
        BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOfAllElements(BasicRunner.matricesPage.matrices));

        chosenMatrix = random.nextInt(BasicRunner.matricesPage.matrices.size());
        WebElement button = BasicRunner.matricesPage.matrices.get(chosenMatrix).findElement(By.xpath(".//button[text()='Show']"));
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();


    }
    @When("A manager or tester adds or removes defects")
    public void a_manager_or_tester_adds_or_removes_defects() {
        add = random.nextBoolean();

        List<WebElement> requirementsEditButton = BasicRunner.matricesPage.matrices.get(chosenMatrix)
                .findElements(By.xpath(".//button[text()='Edit']"));
        chosenRequirement = random.nextInt(requirementsEditButton.size());
        WebElement button = requirementsEditButton.get(chosenRequirement);
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();


        List<WebElement> defects = BasicRunner.matricesPage.matrices.get(chosenMatrix)
                .findElements(By.xpath(".//h3[text()='Defect IDs']/following-sibling::ul[1]/li"));
        defectCount = defects.size()-1; // last entry is the option for adding a defect, not a defect itself

        if(add) {
            WebElement input = defects.get(defectCount).findElement(By.xpath(".//input[@list='defectlist']"));
            BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(input));
            input.sendKeys("901");

            button = defects.get(defectCount).findElement(By.xpath(".//button[text()='Add']"));
            BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        } else {
            if (defectCount > 0) {
                chosenDefect = random.nextInt(defectCount);
                button = defects.get(chosenDefect).findElement(By.xpath(".//button[text()='Remove']"));
                BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                button.click();

            }
        }
    }
    @When("A manager or tester confirms their changes")
    public void a_manager_or_tester_confirms_their_changes() {
        WebElement button = BasicRunner.matricesPage.matrices.get(chosenMatrix).findElement(By.xpath(".//button[text()='Save Requirements']"));
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();

    }
    @Then("Then the matrix should saved")
    public void then_the_matrix_should_saved() {
        BasicRunner.webDriverWait.until(ExpectedConditions.alertIsPresent());
        String message = BasicRunner.driver.switchTo().alert().getText();
        Assert.assertEquals(message, "Matrix Saved");
    }

    // Update Test Cases
    @When("A manager or tester adds or removes Test Cases")
    public void a_manager_or_tester_adds_or_removes_test_cases() {
        add = random.nextBoolean();
        List<WebElement> requirementsEditButton = BasicRunner.matricesPage.matrices.get(chosenMatrix)
                .findElements(By.xpath(".//button[text()='Edit']"));
        chosenRequirement = random.nextInt(requirementsEditButton.size());

        WebElement button = requirementsEditButton.get(chosenRequirement);
        BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();

        List<WebElement> testcases = BasicRunner.matricesPage.matrices.get(chosenMatrix)
                .findElements(By.xpath(".//h3[text()='Test Case IDs']/following-sibling::ul[1]/li"));
        testcaseCount = testcases.size()-1; // last entry is the option for adding a defect, not a defect itself

        if(add) {
            WebElement input = testcases.get(testcaseCount).findElement(By.xpath(".//input[@list='testlist']"));
            BasicRunner.webDriverWait.until(ExpectedConditions.visibilityOf(input));
            input.sendKeys("801");

            button = testcases.get(testcaseCount).findElement(By.xpath(".//button[text()='Add']"));
            BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
            button.click();
        } else {
            if (testcaseCount > 0) {
                chosenTestcase = random.nextInt(testcaseCount);
                button = testcases.get(chosenTestcase).findElement(By.xpath(".//button[text()='Remove']"));
                BasicRunner.webDriverWait.until(ExpectedConditions.elementToBeClickable(button));
                button.click();

            }
        }


    }
}
