package com.zerobank.stepDefinitions;

import com.zerobank.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

public class payBills_stepDefs {

    PayBillsPage payBillsPage = new PayBillsPage();

    @When("User should input the pay requirements")
    public void user_should_input_the_pay_requirements() {

        Select select = new Select(payBillsPage.payeeInput);
        select.selectByVisibleText("Bank of America");

        Select select1 = new Select(payBillsPage.accountInput);
        select1.selectByVisibleText("Loan");

        payBillsPage.amountInput.sendKeys("30000");
        payBillsPage.dateInput.sendKeys("2022-12-12");
        payBillsPage.descriptionInput.sendKeys("Good payment");

        payBillsPage.payBtn.click();
    }

    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {

        String actualMessage = payBillsPage.messageText.getText();

        Assert.assertEquals(expectedMessage, actualMessage);


    }

    @When("User should not complete pay operation by using invalid {string}, {string} and {string}")
    public void user_should_not_complete_pay_operation_by_using_invalid_and(String amount, String date, String
            description) {
        Select select = new Select(payBillsPage.payeeInput);
        select.selectByVisibleText("Bank of America");

        Select select1 = new Select(payBillsPage.accountInput);
        select1.selectByVisibleText("Loan");

        payBillsPage.amountInput.sendKeys(amount);
        payBillsPage.dateInput.sendKeys(date);
        payBillsPage.descriptionInput.sendKeys(description);

        payBillsPage.payBtn.click();
    }

    @Then("{string} message should not be displayed")
    public void message_should_not_be_displayed(String expectedMessage) {

        String actualMessage = payBillsPage.messageText.getText();

        boolean match = false;
        if (actualMessage != expectedMessage) {
            match = true;
        }
        Assert.assertTrue(match);
    }
    @When("User should create new payee using following information")
    public void user_should_create_new_payee_using_following_information(Map<String,String> information) {

        payBillsPage.payeeInputMtd(information.get("Payee Name"),information.get("Payee Address"),information.get("Account"),
                information.get("Payee details"));
    }


}


