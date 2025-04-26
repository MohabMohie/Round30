package com.duckduckgo.ui;

import com.shaft.driver.SHAFT;
import com.shaft.gui.internal.locator.Locator;
import org.openqa.selenium.By;

public class Results extends Page {
//    private final SHAFT.GUI.WebDriver driver;
//    public Results (SHAFT.GUI.WebDriver driver) {
//        this.driver = driver;
//    }

    private static final By firstSearchResult = Locator.hasTagName("article").isFirst().build(); // synonym to By.xpath("(//article)[1]");

    public Results(SHAFT.GUI.WebDriver driver) {
        super(driver);
    }

    public void assertFirstResultDoesNotEqual(String unexpectedText){
        driver.element().assertThat(firstSearchResult).text().doesNotEqual(unexpectedText);
    }
}
