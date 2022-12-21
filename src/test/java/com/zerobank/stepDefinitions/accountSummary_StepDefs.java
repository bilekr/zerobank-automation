package com.zerobank.stepDefinitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class accountSummary_StepDefs {

    AccountSummary accountSummary=new AccountSummary();
    @Then("User should see the following Accounts Types")
    public void user_should_see_the_following_accounts_types(List<String> expectedAccounts) {

        List<String>actualAccounts= BrowserUtils.getElementsText(accountSummary.accountTypes);
        System.out.println("actualAccounts.size() = " + actualAccounts.size());
        System.out.println("actualAccounts = " + actualAccounts);

        Assert.assertEquals(expectedAccounts,actualAccounts);
    }
    @Then("Credit Accounts table should have following columns")
    public void credit_accounts_table_should_have_following_columns(List<String> expectedColumns) {


        List<String> actualColumns=BrowserUtils.getElementsText(accountSummary.creditAccountColumns);

        Assert.assertEquals(expectedColumns,actualColumns);
    }

}
