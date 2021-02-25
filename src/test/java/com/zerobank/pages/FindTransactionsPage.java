package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FindTransactionsPage {

    public FindTransactionsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id=\"tabs\"]/ul/li[2]/a")
    public WebElement findTransactionsButton;

    @FindBy(xpath = "(//*[@*='aa_fromDate'])[2]")
    public WebElement dateFrom_TextBox;

    @FindBy(xpath = "(//*[@*='aa_toDate'])[2]")
    public WebElement dateTo_TextBox;

    @FindBy(xpath = "//*[@id='find_transactions_form']//button")
    public WebElement findButton;

    @FindBy(xpath = "//*[@id='aa_description']")
    public WebElement descriptionInputBox;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']//tbody/tr")
    public List<WebElement>  webTable;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[4]")
    public List<WebElement> allWithdrawal;

    //*[@id="filtered_transactions_for_account"]//tr[1]/td[1]

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody/tr//td[3]")
    public List<WebElement> allDeposit;
}
