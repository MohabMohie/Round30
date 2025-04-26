package com.duckduckgo.ui;

import com.shaft.driver.SHAFT;
import com.shaft.gui.internal.locator.Locator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Search {
    private final SHAFT.GUI.WebDriver driver;
    private static final String targetUrl = System.getProperty("baseURL") + "/login/";
    private static final By logo = By.xpath("//div[contains(@class,'container_fullWidth__1H_L8')]//img");
    private static final By searchBox = Locator.hasAnyTagName().hasAttribute("name", "q").build(); // synonym to By.name("q");

    public Search(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public Search get(){
        driver.browser().navigateToURL(targetUrl);
        return this;
    }

    public void assertTitle(String expectedTitle) {
        driver.browser().assertThat().title().contains(expectedTitle);
    }

    public void assertLogo() {
        driver.element().assertThat(logo).matchesReferenceImage();
    }

    public Results search(String query) {
        driver.element().type(searchBox, query + Keys.ENTER);
        return new Results(driver);
    }

}
