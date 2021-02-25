package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSummaryPage {

    public AccountSummaryPage() {
        PageFactory.initElements(Driver.get(), this);
    }


    @FindBy(xpath = "//*[.='Savings']")
    public WebElement savingsLink;

    @FindBy(xpath = "//*[.='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//*[.='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "(//*[.='Credit Card'])[2]")
    public WebElement creditCardLink;

    @FindBy(xpath = "//*[.='Loan']")
    public WebElement loanLink;

    @FindBy(className = "input-xlarge")
    public WebElement accountDropdown;

    @FindBy(xpath = "//*[@id='account_activity_tab']/a")
    public WebElement accountActivityTab;



}
