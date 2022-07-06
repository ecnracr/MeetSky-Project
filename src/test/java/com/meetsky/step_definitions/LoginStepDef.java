package com.meetsky.step_definitions;

import com.meetsky.pages.LoginPage;
import com.meetsky.pages.ResetPage;
import com.meetsky.utilities.BrowserUtils;
import com.meetsky.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class LoginStepDef {

    LoginPage loginPage = new LoginPage();
    ResetPage resetPage = new ResetPage();
    String expectedErrorMessage = "Wrong username or password.";

    @Given("User goes to login page")
    public void user_goes_to_login_page() {

        Driver.getDriver().get("https://qa.meetsky.net/index.php/login");

    }

    @When("User enters {string} username")
    public void user_enters_username(String string) {

        if (string.isEmpty() || string.isBlank()) {
            expectedErrorMessage = "Please fill out this field.";
        } else {
            loginPage.usernameBox.sendKeys(string);
        }
    }

    @When("User enters {string} password")
    public void user_enters_password(String string) {
        if (string.isEmpty() || string.isBlank()) {
            expectedErrorMessage = "Please fill out this field.";
        } else {
            loginPage.passwordBox.sendKeys(string);
        }
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
            loginPage.loginButton.click() ;
    }

    @Then("User should be logged in")
    public void user_should_be_logged_in() {
        Assert.assertEquals("Files - Meetsky - QA", Driver.getDriver().getTitle());
    }

   @Then("User should see Wrong username or password message")
    public void user_should_see_wrong_username_or_password_message() {
        Assert.assertTrue(loginPage.errorMessage.isDisplayed());
    }

    @Then("User shouldn't be able to login and should see error message")
    public void user_shouldn_t_be_able_to_login_and_should_see_error_message() {
        Assert.assertTrue(loginPage.usernameBox.getAttribute("validationMessage").equals("Please fill out this field.")
                ||loginPage.passwordBox.getAttribute("validationMessage").equals("Please fill out this field."));

    }

    @Then("User should see the password in a form of dots")
    public void user_should_see_the_password_in_a_form_of_dots() {
        Assert.assertTrue(loginPage.passwordBox.getAttribute("type").equals("password"));
    }

    @When("User clicks on eye icon")
    public void user_clicks_on_eye_icon() {
        loginPage.eyeButton.click();
    }

    @Then("User should see the password in a form of text")
    public void user_should_see_the_password_in_a_form_of_text() {

        Assert.assertTrue(loginPage.passwordBox.getAttribute("type").equals("text"));
    }

    @When("User clicks on Forgot password link")
    public void user_clicks_on_forgot_password_link() {loginPage.ForgotPassword.click();
    }

    @Then("User should see the Reset Password button")
    public void user_should_see_the_reset_password_button() {
        Assert.assertTrue(resetPage.resetPasswordButton.isDisplayed());
    }

    @When("User sees the {string} and {string} placeholders")
    public void user_sees_the_and_placeholders(String string, String string2) {
        Assert.assertTrue(loginPage.usernameBox.getAttribute("placeholder").contains("Username"));
        Assert.assertTrue(loginPage.passwordBox.getAttribute("placeholder").contains("Password"));
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
