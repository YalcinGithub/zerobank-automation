package com.zerobank.stepdefinitions;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page()  {
        String url = ConfigurationReader.get("url");
        WebDriver driver = Driver.get();
        driver.manage().window().maximize();
        driver.get(url);

    }
    @When("the user enters valid username and password")
    public void the_user_enters_valid_username_and_password() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login();
    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Personal Banking - Loans - Credit Cards",actualTitle);
    }
    //    @Then("the user should be able to login")
//    public void the_user_should_be_able_to_login() throws InterruptedException {
//        BrowserUtils.waitFor(3);
//        String actualTitle = Driver.get().getTitle();
//        Assert.assertEquals("Dashboard",actualTitle);
    @When("user tries to login with invalid {string} or {string}")
    public void user_tries_to_login_with_invalid_or(String username, String password) {
        LoginPage loginpage = new LoginPage();
        loginpage.login(username,password);
    }
    @Then("error message Login and|or password are wrong should be displayed")
    public void error_message_Login_and_or_password_are_wrong_should_be_displayed() {
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.expectedErrorMessage,loginPage.errorMessage.getText());
    }
}