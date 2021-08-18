package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "user_login")
    public WebElement userName;
    @FindBy(id = "user_password")
    public WebElement password;
    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(id = "primary-button")
    public WebElement ErrorPageBackToSafety;

    @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(xpath = " //*[@id='login_form']/div[1]")
    public WebElement errorMessage;

    public String expectedErrorMessage = "Login and/or password are wrong.";

    public void login() throws InterruptedException {

        signinButton.click();
        userName.sendKeys(ConfigurationReader.get("username"));
        password.sendKeys(ConfigurationReader.get("password"));
        submit.click();
        Thread.sleep(5000);
        ErrorPageBackToSafety.click();

        // verification that we logged
    }

    public void login(String username1, String password1) {
        signinButton.click();
        userName.sendKeys(username1);
        password.sendKeys(password1);
        submit.click();
        // verification that we logged
    }
}