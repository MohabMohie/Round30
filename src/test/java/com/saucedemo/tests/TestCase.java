package com.saucedemo.tests;

import engine.Bot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestCase {
    protected WebDriver driver;
    protected Bot bot;

    @BeforeMethod
    public void beforeMethod(){
        // driver initialization
        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        options.setCapability("webSocketUrl", true);
//        options.setImplicitWaitTimeout(Duration.ofSeconds(5));
        driver = new ChromeDriver(options);

        // bot initialization
        bot = new Bot(driver);
    }

    @AfterMethod
    public void afterMethod(){
        // driver termination
        driver.quit();
    }
}
