package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DefectOverviewPage extends Page {
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

    public DefectOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
