package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TesterHomePage {
    @FindBy(xpath = "//nav/p")
    public WebElement greeting;
    public TesterHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
