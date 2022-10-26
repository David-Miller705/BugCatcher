package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerHomePage {
    @FindBy(xpath = "//nav/p")
    public WebElement greeting;
    public ManagerHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
