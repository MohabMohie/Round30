package com.saucedemo;

import org.openqa.selenium.WebDriver;

public abstract class Page {
    final protected WebDriver driver;
    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
