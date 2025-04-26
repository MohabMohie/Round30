package com.duckduckgo.ui;

import com.duckduckgo.ui.Results;
import com.duckduckgo.ui.Search;
import com.shaft.driver.SHAFT;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestClass {
    SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData;

    @Test
    public void navigateToDuckDuckGoAndAssertBrowserTitleIsDisplayedCorrectly() {
        var searchPage = new Search(driver);
        searchPage.get();
        var expectedTitle = testData.getTestData("expectedTitle");
        searchPage.assertTitle(expectedTitle);
    }

    @Test
    public void navigateToDuckDuckGoAndAssertLogoIsDisplayedCorrectly() {
        var searchPage = new Search(driver);
        searchPage.get();
        searchPage.assertLogo();
    }

    @Test
    public void searchForQueryAndAssert() {
//        var searchPage = new Search(driver);
//        searchPage.get();
        var searchQuery = testData.getTestData("searchQuery");
//        searchPage.search(searchQuery);

        var unexpectedFirstResult = testData.getTestData("unexpectedInFirstResult");
//        var resultsPage = new Results(driver);
//        resultsPage.assertFirstResultDoesNotEqual(unexpectedFirstResult);

        new Search(driver)
                .get()
                .search(searchQuery)
                .assertFirstResultDoesNotEqual(unexpectedFirstResult);
    }

    @BeforeClass
    public void beforeClass() {
        testData = new SHAFT.TestData.JSON(System.getProperty("targetEnv") + "/simpleJSON.json");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
