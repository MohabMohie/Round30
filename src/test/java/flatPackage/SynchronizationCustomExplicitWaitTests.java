package flatPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class SynchronizationCustomExplicitWaitTests {
    @Test
    public void implicitWaitTest() throws InterruptedException {
        // driver initialization
        WebDriver driver;
        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        driver = new ChromeDriver(options);

        // wait object initialization
        Wait<WebDriver> wait;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);

        // navigation to target screen
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        // fist element (is not present)
        driver.findElement(By.id("adder")).click();

        // wait for the red block to be present
        wait.until(d -> d.findElement(By.id("box0")));
        boolean isDisplayed = driver.findElement(By.id("box0")).isDisplayed();
//        boolean isDisplayed =  wait.until(d -> d.findElement(By.id("box0"))).isDisplayed();


        // second element (is present but not displayed)
        driver.findElement(By.id("reveal")).click();

        // wait for typing inside the textbox to be successful
        wait.until(d ->{
            d.findElement(By.id("revealed")).sendKeys("Hello World!");
            return true;
        });

        boolean isDisplayed2 = driver.findElement(By.id("revealed")).isDisplayed();

        driver.quit();

    }
}
