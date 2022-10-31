package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ManagerHomePage {
    @FindBy(xpath = "//nav/p")
    public WebElement greeting;

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

    @FindBy(xpath="//nav/a[@href='/managerhome']")
    public WebElement homePageLink;

    @FindBy(xpath = "//table/tbody/tr//button")
    public List<WebElement> pendingDefectsSelect;

    @FindBy(xpath = "//table/tbody/tr/td[1]")
    public List<WebElement> pendingDefectsID;

    @FindBy(xpath = "//table/tbody/tr/td[2]")
    public List<WebElement> pendingDefectsDescription;

    @FindBy(xpath = "//div[@id = 'root']/div/h4")
    public WebElement boldDescription;

    @FindBy(xpath = "//input[@list='employees']")
    public WebElement assignmentDropdown;

    @FindBy(xpath = "//button[text()='Assign']")
    public WebElement assignButton;


    public ManagerHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
