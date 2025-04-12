package flatPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;

public class A2SynchronizationTests {
    @Test
    public void implicitWaitTest() throws InterruptedException {
        WebDriver driver;

        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        options.setImplicitWaitTimeout(Duration.ofSeconds(30));
        driver = new ChromeDriver(options);

        // navigate to https://www.selenium.dev/selenium/web/dynamic.html
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        // click add a box button
        driver.findElement(By.id("adder")).click();

        // confirm that the box is displayed
        boolean isDisplayed = driver.findElement(By.id("box0")).isDisplayed();

        // click reveal a new input button
        driver.findElement(By.id("reveal")).click();

        // confirm that the input is displayed
//        driver.findElement(By.id("revealed")).sendKeys("Hello World!");
//        boolean isDisplayed2 = driver.findElement(By.id("revealed")).isDisplayed();

//        Thread.sleep(Duration.ofSeconds(1));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        Wait<WebDriver> wait;

//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //expected conditions (the old way) // do not use it // it will be removed
//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("revealed"))));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revealed")));
//        driver.findElement(By.id("revealed")).sendKeys("Hello World!");




//        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("revealed"))))
//                .sendKeys("Hello World!");

        //lambda expression (the new way) applicable since JDK 11
        // simple implementation
//        wait.until(d -> d.findElement(By.id("revealed")).isDisplayed());
//        driver.findElement(By.id("revealed")).sendKeys("Hello World!");


        // objective is not to wait until the element is in the desired state. the real objective is to succeed in typing my text.
        wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(300))
                        .ignoring(NotFoundException.class)
                        .ignoring(StaleElementReferenceException.class)
                        .ignoring(ElementNotInteractableException.class);

        wait.until(d ->{
            d.findElement(By.id("revealed")).sendKeys("Hello World!");
            return true;
        });

        driver.quit();

    }
}
