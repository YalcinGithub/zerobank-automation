package com.zerobank.stepdefinitions;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationStepDefs {

    @Given("the user is logged in to Account Summary page")
    public void the_user_is_logged_in_to_Account_Summary_page() throws InterruptedException {
        LoginStepDefs login = new LoginStepDefs();
        login.the_user_is_on_the_login_page();
        login.the_user_enters_valid_username_and_password();
        new HomePage().onlineBankingButton.click();
        new HomePage().accountSummaryButton.click();

        System.out.println();
    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_String_link_on_the_Account_Summary_page(String linkName) {

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

        WebElement element = switch (linkName) {
            case "Savings" -> accountSummaryPage.savingsLink;
            case "Brokerage" -> accountSummaryPage.brokerageLink;
            case "Checking" -> accountSummaryPage.checkingLink;
            case "Credit card" -> accountSummaryPage.creditCardLink;
            case "Loan" -> accountSummaryPage.loanLink;
            default -> throw new IllegalStateException("Unexpected value: " + linkName);
        };

        element.click();
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_Savings_selected(String expectedOption) {
        //BrowserUtils.waitFor(5);
        Select accountOptions = new Select(new AccountSummaryPage().accountDropdown);
        String actualOption = accountOptions.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption);

    }

}


//    @When("the user clicks on Brokerage link on the Account Summary page")
//    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
//        new AccountSummaryPage().brokerageLink.click();
//    }
//
//    @When("the user clicks on Checking link on the Account Summary page")
//    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
//        new AccountSummaryPage().checkingLink.click();
//    }
//
//    @When("the user clicks on Credit card link on the Account Summary page")
//    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
//        new AccountSummaryPage().creditCardLink.click();
//    }
//
//    @When("the user clicks on Loan link on the Account Summary page")
//    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
//        new AccountSummaryPage().loanLink.click();
//    }
