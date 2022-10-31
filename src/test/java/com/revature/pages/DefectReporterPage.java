package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectReporterPage {

    @FindBy(xpath="//nav/a[@href='/matrices']")
    public WebElement matricesLink;

    @FindBy(xpath="//nav/a[@href='/testcases']")
    public WebElement testCasesLink;

    @FindBy(xpath="//nav/a[@href='/defectreporter']")
    public WebElement defectReporterLink;

    @FindBy(xpath="//nav/a[@href='/defectoverview']")
    public WebElement defectOverviewLink;

    @FindBy(xpath="//nav/a[@href='/?dev=5']")
    public WebElement logoutLink;

    @FindBy(xpath="//nav/a[@href='/managerhome' or @href='/testerhome']")
    public WebElement homePageLink;

    @FindBy(xpath = "//form[@id='defectReport']/input[@name='dateReported' and @type='date']")
    public WebElement dateInput;

    @FindBy(xpath = "//form[@id='defectReport']/textarea[@name='desc']")
    public WebElement descriptionInput;

    @FindBy(xpath = "//form[@id='defectReport']/textarea[@name='stepsToReproduce']")
    public WebElement stepsToReproduceInput;

    @FindBy(xpath = "//form[@id='defectReport']/input[@name='severity' and @type='range']")
    public WebElement severityInput;

    @FindBy(xpath = "//form[@id='defectReport']/input[@name='severity' and @type='range']/following-sibling::p[1]")
    public WebElement severityText;

    @FindBy(xpath = "//form[@id='defectReport']/input[@name='priority' and @type='range']")
    public WebElement priorityInput;

    @FindBy(xpath = "//form[@id='defectReport']/input[@name='priority' and @type='range']/following-sibling::p[1]")
    public WebElement priorityText;

    @FindBy(xpath = "//form[@id='defectReport']/button[@type='submit']")
    public WebElement reportButton;

    @FindBy(xpath = "//div[@class='ReactModalPortal']//h4")
    public WebElement defectID;

    @FindBy(xpath = "//button[text()='Close']")
    public WebElement closeButton;




    public DefectReporterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
