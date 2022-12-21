package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsPage extends BasePage{

    @FindBy(css = "#sp_payee")
    public WebElement payeeInput;

    @FindBy(css = "#sp_account")
    public WebElement accountInput;

    @FindBy(css = "#sp_amount")
    public WebElement amountInput;

    @FindBy(css = "#sp_date")
    public WebElement dateInput;

    @FindBy(css = "#sp_description")
    public WebElement descriptionInput;

    @FindBy(css = "#pay_saved_payees")
    public WebElement payBtn;

    @FindBy(css = "#alert_content")
    public WebElement messageText;

    @FindBy (css = "#np_new_payee_name")
    public WebElement payeeName;

    @FindBy(css = "#np_new_payee_address")
    public WebElement address;

    @FindBy(css = "#np_new_payee_account")
    public WebElement account;

    @FindBy(css = "#np_new_payee_details")
    public WebElement paydetails;

    @FindBy(css = "#add_new_payee")
    public WebElement newPayBtn;

    public void payeeInputMtd(String PayeeName,String PayeeAddress, String Account,String PayeeDetails){

       payeeName.sendKeys(PayeeName);
       address.sendKeys(PayeeAddress);
       account.sendKeys(Account);
       paydetails.sendKeys(PayeeDetails);

       newPayBtn.click();


    }

}
