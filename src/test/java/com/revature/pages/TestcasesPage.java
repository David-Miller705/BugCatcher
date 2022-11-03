package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TestcasesPage extends Page {

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

    @FindBy(xpath = "//textarea[@name='desc']")
    public WebElement descriptionTextbox;

    @FindBy(xpath = "//textarea[@name='steps']")
    public WebElement stepsTextbox;

    @FindBy(xpath = "//button[text()=' Submit']")
    public WebElement submitButton;
    // There's a space in the submit button tag

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> testcases;

    @FindBy(xpath = "//div[@class='ReactModalPortal']//h3")
    public WebElement modalID;

    @FindBy(xpath = "//div[@class='ReactModalPortal']//h4[text()='Performed By']/following-sibling::*[1]")
    public WebElement modalPerformedBy;

    @FindBy(xpath = "//div[@class='ReactModalPortal']//button/a[text()='Edit']")
    public WebElement modalEditButton;

    @FindBy(xpath = "//div[@class='ReactModalPortal']//button[text()='Close']")
    public WebElement modalCloseButton;


    public TestcasesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
