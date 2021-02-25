package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingButton;

    @FindBy(id = "account_summary_link")
    public WebElement accountSummaryButton;

    @FindBy(id = "account_activity_link")
    public WebElement accountActivityButton;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLinkButton;

    @FindAll({
            @FindBy(className = "board-header")
    })
    public List<WebElement> accountTypesList;

    @FindBy(className = "board-header")
    public List<WebElement> accountTypesList2;

    @FindBy(xpath = "(//*[@class='table'])[3]//th")
    public List<WebElement> creditAccountColumns;

    @FindBy(xpath = "//*[@required='required']")
    public WebElement accountDropdown;

    @FindBy(xpath = "//*[@id='all_transactions_for_account']//th")
    public List<WebElement> transactionTableColumns;

}