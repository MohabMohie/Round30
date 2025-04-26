package com.duckduckgo.ui;

import org.junit.jupiter.api.TestClassOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestScenario {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void login(){
        //actions
        //assertion that login was successful
    }

    @Test(dependsOnMethods = {"login"})
    public void addItemToCart(){
        //actions
        //assertion that item was added to cart
    }

    @Test(dependsOnMethods = {"login","addItemToCart"})
    public void confirmPayment(){
        //actions
        //assertion that payment method was selected successfully
        Assert.fail();
    }

    @Test(dependsOnMethods = {"login","addItemToCart", "confirmPayment"})
    public void confirmShippingInformation(){
        //actions
        //assertion that shipping information was saved successfully
    }

    @Test(dependsOnMethods = {"login","addItemToCart", "confirmPayment", "confirmShippingInformation"})
    public void placeOrder(){
        //actions
        //assertion that order was placed successfully
    }
}
