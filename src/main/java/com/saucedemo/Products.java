package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Products extends Page{
    public Products(WebDriver driver) {
        super(driver);
    }

    // locators
    private static final By pageTitle = By.xpath("//span[@data-test='title']");

    // actions
    public boolean isPageTitleDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }
}
