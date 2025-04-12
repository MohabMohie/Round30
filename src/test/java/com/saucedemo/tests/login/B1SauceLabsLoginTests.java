package com.saucedemo.tests.login;

import com.saucedemo.Login;
import com.saucedemo.Products;
import com.saucedemo.tests.TestCase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class B1SauceLabsLoginTests extends TestCase {
    @Test
    public void test(){
        // Login Page
        Login login = new Login(driver);
        login.navigate();

        String validUsername = "standard_user";
        String validPassword = "secret_sauce";

        login.login(validUsername, validPassword);

        // Products page
        Products products = new Products(driver);
        var isDisplayed = products.isPageTitleDisplayed();

        // Checkpoint
        Assert.assertTrue(isDisplayed, "Page title is not displayed");
    }

    @Test
    public void fluentTest(){
        // Steps
        var isDisplayed = new Login(driver)
                .navigate()
                .login("standard_user", "secret_sauce")
                .isPageTitleDisplayed();

        // Checkpoint
        Assert.assertTrue(isDisplayed, "Page title is not displayed");
    }

    @Test
    public void test1(){
        // Login Page
        Login login = new Login(driver);
        login.navigate();

        String lockedOutUser = "locked_out_user";
        String validPassword = "secret_sauce";

        login.login(lockedOutUser, validPassword);

        String errorMessageText = login.getErrorMessageText();

        // Checkpoint
        Assert.assertEquals(errorMessageText, "Epic sadface: Sorry, this user has been locked out.");
    }


}
