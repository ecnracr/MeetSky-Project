package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

    @FindBy(xpath = "//div[@class='menutoggle']")
    public WebElement settings;

    @FindBy(xpath = "//img[@src='/core/img/actions/logout.svg?v=d5694075']")
    public WebElement logOutButton;





    public LogOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
