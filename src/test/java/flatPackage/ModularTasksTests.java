package flatPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ModularTasksTests extends TestCase {
    @Test
    public void navigateToDuckuckGoAndCheckPageTitle(){
        driver.navigate().to("https://duckduckgo.com/");
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Google");
    }
    @Test
    public void navigateToDuckDuckGoAndCheckLogoIsDisplayed(){
        driver.navigate().to("https://duckduckgo.com/");
//        boolean isDisplayed = driver.findElement(By.xpath("//div[contains(@class,'headerWrapDesktop')]//img")).isDisplayed();
        boolean isDisplayed = bot.isDisplayed(By.xpath("//div[contains(@class,'headerWrapDesktop')]//img"));
        Assert.assertTrue(isDisplayed, "Logo is not displayed");
    }

    /**
     * Open Google Chrome
     * Navigate to [<a href="https://duckduckgo.com/">duckduckgo</a>]
     * Search for [Selenium WebDriver]
     * Assert that the link of the first result is [<a href="https://www.selenium.dev/documentation/webdriver/">selenium.dev/documentation/webdriver/</a>]
     * Close Google Chrome
     */
    @Test(description = "Given I am on the DuckDuckGo homepage, " +
            "When I search for 'Selenium WebDriver', " +
            "Then the first result should be 'https://www.selenium.dev/documentation/webdriver/'")
    public void searchForQueryAndCheckFirstResultText(){
        // Given I am on the DuckDuckGo homepage
        driver.navigate().to("https://duckduckgo.com/");

        // When I search for 'Selenium WebDriver'

//        By.xpath("//*[@id='searchbox_input']");
//        By.cssSelector("#searchbox_input");
//        By.id("searchbox_input");

//        //option 1
//        By searchbox = By.id("searchbox_input");
//        driver.findElement(searchbox).sendKeys("Selenium WebDriver" + Keys.ENTER);
//
//        //option 2
//        WebElement searchboxInput = driver.findElement(By.id("searchbox_input"));
//        searchboxInput.sendKeys("Selenium WebDriver" + Keys.ENTER);
//
//        //option 3
//        driver.findElement(By.id("searchbox_input")).sendKeys("Selenium WebDriver" + Keys.ENTER);

        By searchbox = By.id("searchbox_input");
        bot.sendKeys(searchbox, "Selenium WebDriver" + Keys.ENTER);

        // Then the first result should be 'https://www.selenium.dev/documentation/webdriver/'
        By firstResultLink = By.xpath("(//a[@data-testid='result-extras-url-link'])[1]");
        //TODO: which is better? writing an index in the xpath or using the findElements method?

        String firstResultLinkText = bot.getAttribute(firstResultLink, "href");
        Assert.assertEquals(firstResultLinkText, "https://www.selenium.dev/documentation/webdriver/");
    }
}
