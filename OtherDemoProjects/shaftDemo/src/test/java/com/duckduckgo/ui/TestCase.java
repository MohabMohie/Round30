package com.duckduckgo.ui;

import com.shaft.driver.SHAFT;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
      driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testOrderConfirmationCreditCard() {
        driver.get("https://duckduckgo.com/");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://duckduckgo.com/");
    }

    @Test
    public void testOrderConfirmationCash() {
        driver.get("https://www.baeldung.com/junit-5-parallel-tests");
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.baeldung.com/junit-5-parallel-tests");
    }
}
