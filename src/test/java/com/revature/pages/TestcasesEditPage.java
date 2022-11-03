package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestcasesEditPage extends Page {
//
//    @FindBy(xpath="//nav/a[@href='/matrices']")
//    public WebElement matricesLink;
//
//    @FindBy(xpath="//nav/a[@href='/testcases']")
//    public WebElement testCasesLink;
//
//    @FindBy(xpath="//nav/a[@href='/defectreporter']")
//    public WebElement defectReporterLink;
//
//    @FindBy(xpath="//nav/a[@href='/defectoverview']")
//    public WebElement defectOverviewLink;
//
//    @FindBy(xpath="//nav/a[@href='/?dev=5']")
//    public WebElement logoutLink;
//
//    @FindBy(xpath="//nav/a[@href='/managerhome' or @href='/testerhome']")
//    public WebElement homePageLink;

    @FindBy(xpath = "//h1")
    public WebElement testcaseID;

    @FindBy(xpath = "//button[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//button[text()='Save']")
    public WebElement saveButton;

    @FindBy(xpath = "//button[text()='Reset']")
    public WebElement resetButton;

    @FindBy(xpath = "//h6[text()='Description']/following-sibling::*[1]")
    public WebElement descriptionInput;

    @FindBy(xpath = "//h6[text()='Steps']/following-sibling::*[1]")
    public WebElement stepsInput;

    @FindBy(xpath = "//h6[text()='Automated']/following-sibling::*[1]")
    public WebElement automatedInput;

    @FindBy(xpath = "//h6[text()='Performed by']/following-sibling::*[1]")
    public WebElement performedByInput;

    @FindBy(xpath = "//h6[text()='Test Result']/following-sibling::*[1]")
    public WebElement testResultsInput;

    @FindBy(xpath = "//h6[text()='Summary']/following-sibling::*[1]")
    public WebElement summaryInput;




    public TestcasesEditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
