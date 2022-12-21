package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{


        @FindBy(id = "signin_button")
        public WebElement signBtn;

        @FindBy(id = "user_login")
        public WebElement userName;

        @FindBy(id = "user_password")
        public WebElement passWord;

        @FindBy(xpath = "//input[@name='submit']")
        public WebElement loginBtn;

        @FindBy (xpath = "//div[@class='alert alert-error']")
        public WebElement errorMsg;

    }

