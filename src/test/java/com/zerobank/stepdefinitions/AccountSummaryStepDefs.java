package com.zerobank.stepdefinitions;

import com.zerobank.pages.HomePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDefs {

    @Then("the user navigates Online Banking - Account Summary")
    public void the_user_navigates_Online_Banking_Account_Summary() {

        HomePage homePage = new HomePage();
        homePage.onlineBankingButton.click();
        homePage.accountSummaryButton.click();

    }

    @Then("the user should see the title {string}")
    public void the_user_should_see_the_title(String expectedTitle) {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - "+expectedTitle, actualTitle);

    }

    @Then("the user should see four account types")
    public void the_user_should_see_four_account_types() {

        List<String> expectedAccountTypes = Arrays.asList("Cash Accounts", "Investment Accounts", "Credit Accounts",
                "Loan Accounts");

        List<String> actualTypelist = BrowserUtils.getElementsText(new HomePage().accountTypesList2);

        Assert.assertEquals(expectedAccountTypes, actualTypelist);
        System.out.println("actualTypelist = " + actualTypelist);
    }


    @Then("the user should see three Credit Account Volumes")
    public void the_user_should_see_three_Credit_Account_Volumes() {
        List<String> expectedColumns = Arrays.asList("Account", "Credit Card", "Balance");

        List<String> actualColumns = BrowserUtils.getElementsText(new HomePage().creditAccountColumns);

        Assert.assertEquals(expectedColumns, actualColumns);
        System.out.println("actualColumns = " + actualColumns);

    }

}
