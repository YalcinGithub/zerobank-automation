package com.zerobank.stepdefinitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PayBillsStepDefs {

    @Then("the user navigates Online Banking - Pay Bills Page")
    public void the_user_navigates_Online_Banking_Pay_Bills_Page() {

        HomePage homePage = new HomePage();
        homePage.onlineBankingButton.click();
        homePage.payBillsLinkButton.click();

    }

    @Then("the user should be able input Amount and Date")
    public void the_user_should_be_able_input_Amount_and_Date() {
        //BrowserUtils.waitFor(1);
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.amountInputBox.sendKeys("10");

        //Driver.get().findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("10");
        //BrowserUtils.waitFor(3);
        payBillPage.dateInputBox.click();
        payBillPage.dateDaySelect.click();

    }

    @Then("the user should see the message {string} after payment")
    public void the_user_should_see_the_message_after_payment(String expectedMessage) {
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.payButton.click();
        String actualMessage = payBillPage.successMessage.getText();

        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("if the user inputs nothing, gets Error message")
    public void if_the_user_inputs_nothing_gets_Error_message() {
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.payButton.click();

        String expectedMessage = "Please fill out this field.";
        String actualMessage = payBillPage.amountInputBox.getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("nothing, gets Error success");

    }

    @Then("if the user inputs only date, gets Error message")
    public void if_the_user_inputs_only_date_gets_Error_message() {
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.dateInputBox.click();
        payBillPage.dateDaySelect.click();

        payBillPage.payButton.click();

        String expectedMessage = "Please fill out this field.";
        String actualMessage = payBillPage.amountInputBox.getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, actualMessage);

        payBillPage.dateInputBox.clear();
        System.out.println("only date, gets Error success");
    }

    @Then("if the user inputs only amount, gets Error message")
    public void if_the_user_inputs_only_amount_gets_Error_message() {
        PayBillPage payBillPage = new PayBillPage();
        payBillPage.amountInputBox.sendKeys("10");
        payBillPage.payButton.click();

        String expectedMessage = "Please fill out this field.";
        String actualMessage = payBillPage.dateInputBox.getAttribute("validationMessage");

        Assert.assertEquals(expectedMessage, actualMessage);
        System.out.println("only amount, gets Error success");

    }

    @Then("if the user inputs invalid date, it is not accepted")
    public void if_the_user_inputs_invalid_date_it_is_not_accepted() {
        PayBillPage payBillPage = new PayBillPage();
        BrowserUtils.waitFor(2);
        payBillPage.dateInputBox.sendKeys("1asdf!@#$%");
        System.out.println("payBillPage.dateInputBox.getAttribute(\"value\") = " + payBillPage.dateInputBox.getAttribute("value"));
Assert.assertEquals("1",payBillPage.dateInputBox.getAttribute("value"));
    }


}
