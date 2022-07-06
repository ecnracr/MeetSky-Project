package com.meetsky.pages;

import com.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {

        public ResetPage() {
            PageFactory.initElements(Driver.getDriver(), this);
        }

        @FindBy(id = "reset-password-submit")
        public WebElement resetPasswordButton;

    }

