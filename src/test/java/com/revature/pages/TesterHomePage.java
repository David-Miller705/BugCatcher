package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TesterHomePage {

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

    @FindBy(xpath="//nav/a[@href='/testerhome']")
    public WebElement homePageLink;

    @FindBy(xpath = "//li/div/span")
    public List<WebElement> pendingDefectsCollapseButtons;

    @FindBy(xpath = "//li//div[@class='Collapsible__contentInner']/p[5]")
    public List<WebElement> pendingDefectsAssignment;

    @FindBy(xpath = "//li//div[@class='Collapsible__contentInner']/p[6]")
    public List<WebElement> pendingDefectsDateReported;

    @FindBy(xpath = "//button[text() = 'Change Status']")
    public List<WebElement> pendingDefectsChangeStatusButtons;

    @FindBy(xpath = "//button[text() = 'Accepted']")
    public List<WebElement> pendingDefectsChangeStatusToAcceptedButtons;

    @FindBy(xpath = "//button[text() = 'Rejected']")
    public List<WebElement> pendingDefectsChangeStatusToRejectedButtons;

    @FindBy(xpath = "//button[text() = 'Fixed']")
    public List<WebElement> pendingDefectsChangeStatusToFixedButtons;

    @FindBy(xpath = "//button[text() = 'Declined']")
    public List<WebElement> pendingDefectsChangeStatusToDeclinedButtons;

    @FindBy(xpath = "//button[text() = 'Shelved']")
    public List<WebElement> pendingDefectsChangeStatusToShelvedButtons;

    @FindBy(xpath = "//li//p/b[2]")
    public List<WebElement> pendingDefectsStatusText;



    public TesterHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
