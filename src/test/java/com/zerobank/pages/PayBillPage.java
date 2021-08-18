package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillPage {
    {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//*[@id='sp_amount']")
    public WebElement amountInputBox;

    @FindBy(xpath = "//*[@id='sp_date']")
    public WebElement dateInputBox;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']//td[7]")
    public WebElement dateDaySelect;

    @FindBy(xpath = "//*[@id='pay_saved_payees']")
    public WebElement payButton;

    @FindBy(xpath = "//*[@id='alert_content']/span")
    public WebElement successMessage;

    @FindBy(xpath = "//a[normalize-space()='Add New Payee']")
    public WebElement addNewPayeeTab;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeNameInputBox;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddressInputBox;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement payeeAccountInputBox;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetailsInputBox;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    public WebElement addNewPayeeButton;

    @FindBy(xpath = "//*[@id='alert_content']")
    public WebElement payeeAddedSuccessfulMessage;

    @FindBy(xpath = "//a[normalize-space()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyTab;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement selectCurrencyDropdownButton;

    @FindBy(xpath = "//input[@id='pc_calculate_costs']")
    public WebElement calculateCostsButton;

}
