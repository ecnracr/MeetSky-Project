package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class LoginPage {

    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;

    @FindBy(id = "lost-password")
    public WebElement ForgotPassword;

    @FindBy(css = "img[src='/core/img/actions/toggle.svg']")
    public WebElement eyeButton;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }




}
