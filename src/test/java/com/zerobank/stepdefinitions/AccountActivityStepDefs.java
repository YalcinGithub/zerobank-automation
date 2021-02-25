package com.zerobank.stepdefinitions;

import com.zerobank.pages.HomePage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityStepDefs {


    @Then("the user navigates Online Banking - Account Activity")
    public void the_user_navigates_Online_Banking_Account_Activity() {

        HomePage homePage = new HomePage();
        homePage.onlineBankingButton.click();
        homePage.accountActivityButton.click();

    }

    @Then("Account drop down default option should be {string}")
    public void account_drop_down_default_option_should_be(String expectedDefaultOption) {
        Select dropdownOptions = new Select(new HomePage().accountDropdown);
        String actualDefaultOption = dropdownOptions.getFirstSelectedOption().getText();

        Assert.assertEquals(expectedDefaultOption, actualDefaultOption);

    }

    @Then("Account dropdown should have the following options:")
    public void account_dropdown_should_have_the_following_options(List<String> expectedList) {
        Select dropdownOptions = new Select(new HomePage().accountDropdown);
        List<WebElement> elementList = dropdownOptions.getOptions();
        List<String> actualList = BrowserUtils.getElementsText(elementList);

        Assert.assertEquals(expectedList, actualList);
    }

    @Then("Transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumns) {
        BrowserUtils.waitFor(2);
        List<String> actualColumns = BrowserUtils.getElementsText(new HomePage().transactionTableColumns);
        Assert.assertEquals(expectedColumns, actualColumns);

        System.out.println("actualColumns = " + actualColumns);
        System.out.println("expectedColumns = " + expectedColumns);
    }

}
