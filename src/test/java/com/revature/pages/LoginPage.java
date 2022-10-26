package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath="//input[@name='username']")
    public WebElement usernameInput;

    @FindBy(xpath="//input[@name='pass']")
    public WebElement passwordInput;

    @FindBy(xpath="//button[text()='Login']")
    public WebElement loginButton;

    public LoginPage(WebDriver driver) {
        //This uses the @FindBy annotations to initialize the class members
        PageFactory.initElements(driver, this);
    }

}
