package com.meetsky.step_definitions;

import com.meetsky.pages.LogOutPage;
import com.meetsky.pages.LoginPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LogOutStepDef {
    LoginPage loginPage = new LoginPage();
    LogOutPage logOutPage = new LogOutPage();

    @Given("User logs in with valid credentials")
    public void userLogsInWithValidCredentials() {
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
        loginPage.usernameBox.sendKeys("Employee51");
        loginPage.passwordBox.sendKeys("Employee123");
        loginPage.loginButton.click();
    }

    @Given("User click to settings expand button on top-right corner")
    public void userClickToSettingsExpandButtonOnTopRightCorner() {
        logOutPage.settings.click();
    }

    @When("Click to Log out button")
    public void clickToLogOutButton() {
        logOutPage.logOutButton.click();
    }

    @Then("User should be able to logged out successfully and can see the login page")
    public void userShouldBeAbleToLoggedOutSuccessfullyAndCanSeeTheLoginPage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Meetsky - QA"));
    }

    @And("User should not be able to go to home page again by clicking step back button")
    public void userShouldNotBeAbleToGoToHomePageAgainByClickingStepBackButton() {
        Driver.getDriver().navigate().back();
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Meetsky - QA"));
    }


    @After
    public void tearDownScenario(Scenario scenario) {

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }


        BrowserUtils.sleep(3);
        Driver.closeDriver();

    }
    @Before
    public void setUpScenario(){
        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");
    }
}
