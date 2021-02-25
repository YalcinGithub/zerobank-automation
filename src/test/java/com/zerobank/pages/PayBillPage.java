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
}
