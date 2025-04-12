package com.saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Page {
    public Login(WebDriver driver) {
        super(driver);
    }

    // locators
    private static final By usernameInput = By.id("user-name");
    private static final By passwordInput = By.id("password");
    private static final By loginButton = By.id("login-button");

    private static final By errorMessage = By.tagName("h3");

    // actions
    public Login navigate(){
        driver.get("https://www.saucedemo.com/");
        return this;
    }

    public Products login(String username, String password) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new Products(driver);
    }

    public Login invalidLogin(String username, String password) {
        login(username, password);
        return this;
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMessage).getText();
    }
}
