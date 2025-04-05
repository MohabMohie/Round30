package flatPackage;

import engine.Bot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SynchronizationBotTests {
    @Test
    public void implicitWaitTest() {
        // driver initialization
        WebDriver driver;
        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        driver = new ChromeDriver(options);

        // Actions bot initialization
        Bot bot = new Bot(driver);

        // navigation to target screen
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        bot.click(By.id("adder")).isDisplayed(By.id("box0"));

        bot.click(By.id("reveal"))
                .sendKeys(By.id("revealed"), "Hello World!")
                .isDisplayed(By.id("revealed"));

        driver.quit();

    }
}
