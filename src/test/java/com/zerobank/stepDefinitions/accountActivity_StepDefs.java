package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class accountActivity_StepDefs {

    AccountActivity accountActivity = new AccountActivity();

    @When("User should navigate to {string}")
    public void user_should_navigate_to(String accountType) {
        accountActivity.navigateToAccount(accountType);

    }

    @When("User should see the {string} as default type")
    public void user_should_see_the_as_default_type(String expectedOption) {
        Select select = new Select(accountActivity.dropDownElement);
        String actualOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedOption, actualOption);
    }

    @When("User should see the following Accounts")
    public void user_should_see_the_following_accounts(List<String> expectedAccountTypes) {

        Select select = new Select(accountActivity.dropDownElement);
        List<WebElement> options = select.getOptions();

        boolean match = false;
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());


            for (int i = 0; i < expectedAccountTypes.size(); i++) {
                if (option.getText().equals(expectedAccountTypes.get(i))) ;

                match=true;
            }

        }
        Assert.assertTrue(match);


    }

    @When("User should see the following options")
    public void user_should_see_the_following_options(List<String>expectedOptions) {

        List<String> actualOptions= BrowserUtils.getElementsText(accountActivity.rowHeader);
        Assert.assertEquals(expectedOptions,actualOptions);

    }

}
