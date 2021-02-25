package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class FindTransactionsStepDefs {
    FindTransactionsPage findTransactionsPage = new FindTransactionsPage();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() throws InterruptedException {

        new AccountActivityNavigationStepDefs().the_user_is_logged_in_to_Account_Summary_page();
        new AccountSummaryPage().accountActivityTab.click();
        findTransactionsPage.findTransactionsButton.click();

    }

    @When("the user enters date range from {string} to {string}")
    public void theUserEntersDateRangeFromTo(String arg0, String arg1) {
        BrowserUtils.waitFor(1);

        findTransactionsPage.dateFrom_TextBox.clear();
        findTransactionsPage.dateFrom_TextBox.sendKeys(arg0);

        findTransactionsPage.dateTo_TextBox.clear();
        findTransactionsPage.dateTo_TextBox.sendKeys(arg1);

        //BrowserUtils.waitFor(5);
    }


    @When("clicks search")
    public void clicks_search() {
        BrowserUtils.waitForClickablility(new FindTransactionsPage().findButton, 3);
        findTransactionsPage.findButton.click();
        BrowserUtils.waitFor(3);
    }

    @Then("results table should only show transactions dates from {string} to {string}")
    public void resultsTableShouldOnlyShowTransactionsDatesFromTo(String first, String last) throws ParseException {
        Date firstDate = convertToDate(first);
        Date lastDate = convertToDate(last);

        BrowserUtils.waitFor(2);
        List<WebElement> table = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tr"));

        for (int i = 0; i < (table.size()) - 1; i++) {
            String myXpath = "//*[@id='filtered_transactions_for_account']//tr[" + (i + 1) + "]/td[1]";

            WebElement dateFromTable = Driver.get().findElement(By.xpath(myXpath));

            Date getDate = convertToDate(dateFromTable.getText());

            Assert.assertTrue(isBetweenDates(firstDate, lastDate, getDate));
        }

    }

    @And("the results table should only not contain transactions dated {string}")
    public void theResultsTableShouldOnlyNotContainTransactionsDated(String dateString) {
        List<WebElement> table = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tr"));

        for (int i = 0; i < (table.size()) - 1; i++) {
            WebElement dateFromTable = Driver.get().findElement(By.xpath("//*[@id='filtered_transactions_for_account']//tr[" + (i + 1) + "]/td[1]"));
            Assert.assertNotEquals(dateString, dateFromTable.getText());
        }

    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() throws ParseException {

        List<WebElement> table = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tr"));
        List<Date> myList = new ArrayList<>();

        for (int i = 0; i < (table.size()) - 1; i++) {
            WebElement dateFromTable = Driver.get().findElement(By.xpath("//*[@id='filtered_transactions_for_account']//tr[" + (i + 1) + "]/td[1]"));
            Date getDate = convertToDate(dateFromTable.getText());
            myList.add(getDate);
        }

        List<Date> sortedList = new ArrayList<>(myList);
        sortedList.sort(Collections.reverseOrder());
        Assert.assertEquals(sortedList, myList);
    }

    public Date convertToDate(String string) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(string);
    }

    public boolean isBetweenDates(Date start, Date end, Date testDate) {
        return testDate.equals(start) || (testDate.after(start) && testDate.before(end)) || testDate.equals(end);
    }

    @When("the user enters description {string}")
    public void theUserEntersDescription(String arg0) {
        BrowserUtils.waitFor(1);
        findTransactionsPage.descriptionInputBox.clear();
        findTransactionsPage.descriptionInputBox.sendKeys(arg0);
    }

    @But("results table should {string} show descriptions containing {string}")
    public void resultsTableShouldNotShowDescriptionsContaining(String in_out, String expectedDescription) {

        List<WebElement> table = new ArrayList<>();
        table = Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tbody/tr"));
        BrowserUtils.waitFor(3);
        Assert.assertTrue(table.size() > 0);

        for (int i = 0; i < table.size(); i++) {
            String myXpath = "//*[@id='filtered_transactions_for_account']//tbody/tr[" + (i + 1) + "]/td[2]";
            String actualDescription = Driver.get().findElement(By.xpath(myXpath)).getText();

            if (in_out.equals("not")) {
                Assert.assertFalse(actualDescription.contains(expectedDescription.toUpperCase()));
            } else if (in_out.equals("only")) {
                Assert.assertTrue(actualDescription.contains(expectedDescription.toUpperCase()));
            }

        }
    }

    @Then("results table should show {string} result under {string}")
    public void resultsTableShouldShowResultUnder(String show, String column){
        List<String> columnContent;
        columnContent = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")));
        System.out.println("columnContent = " + columnContent);
        System.out.println("columnContent.size() = " + columnContent.size());

//        switch (column.toLowerCase()) {
//            case "deposit":
//                columnContent = BrowserUtils.getElementsText(findTransactionsPage.allDeposit);
//                break;
//            case "withdrawal":
//                columnContent = BrowserUtils.getElementsText(findTransactionsPage.allWithdrawal);
//        }
//        int sizeOfItems = columnContent.size();
//        if (show.toLowerCase().contains("one")) {
//
//            Assert.assertTrue(sizeOfItems >= 1);
//        } else if (show.equalsIgnoreCase("no")) {
//            for (String list : columnContent) {
//                Assert.assertTrue(list.isEmpty());
//            }
//        } else {
//            Assert.fail("Word undefined");
//        }
    }
//{
//
//        int columnNumber = 0;
//        if (typeSelection.equals("Withdrawal")) {
//            columnNumber = 4;
//        } else if (typeSelection.equals("Deposit")) {
//            columnNumber = 3;
//        }
//
//        boolean atLeastOne = false;
//        List<String > myList = new ArrayList<>();
//                myList = BrowserUtils.getElementsText(findTransactionsPage.allWithdrawal);
//
//        System.out.println("myList.size() = " + myList.size());
//
//        List<WebElement> temporaryList = Driver.get().findElements(By.xpath("(//*[@id='filtered_transactions_for_account']//tbody/tr)"));
//        WebElement tempelement = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]"));
//        System.out.println("tempelement = " + tempelement);
//        System.out.println("temporaryList.size() = " + temporaryList.size());
//
//        for (int i = 0; i < myList.size(); i++) {
//            String myXpath = "//*[@id='filtered_transactions_for_account']//tr[" + i + "]/td[" + columnNumber + "]";
//            String columnInfo = Driver.get().findElement(By.xpath(myXpath)).getText();
//            System.out.println("columnInfo = " + columnInfo);
//            if (one_or_no.equals("no")) {
//                System.out.println("ife girdi");
//                Assert.assertEquals("", columnInfo);
//            } else if ((one_or_no.equals("at least one")) && !columnInfo.equals("")) {
//                atLeastOne = true;
//                System.out.println("Elife girdi");
//            }
//
//        }
//
//        if (one_or_no.equals("at least one")) {
//            System.out.println("en son ife girmis");
//            Assert.assertTrue(atLeastOne);
//        }
//
//    }

    @When("user selects type {string}")
    public void userSelectsType(String typeSelection) {
    }
}
