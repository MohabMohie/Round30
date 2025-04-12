package flatPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class A1BrowserInteractionTests {

    /**
     * This test will follow these steps using Selenium WebDriver
     * Open Google Chrome
     * Navigate to [https://duckduckgo.com/]
     * Assert that the page title is [Google]
     * Close Google Chrome
     */
    @Test
    public void testMethod() throws InterruptedException {
        WebDriver driver;

        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        options.setImplicitWaitTimeout(Duration.ofSeconds(30));
        driver = new ChromeDriver(options);

//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


        driver.navigate().to("http://duckduckgo.com/");
        String windowHandle = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.google.com/");
        String windowHandle2 = driver.getWindowHandle();

        driver.switchTo().window(windowHandle);
//        Thread.sleep(Duration.ofSeconds(10));
//        System.out.println(driver.getCurrentUrl());
        String duckduckgo = driver.getCurrentUrl();

        driver.switchTo().window(windowHandle2);
//        Thread.sleep(Duration.ofSeconds(10));
//        System.out.println(driver.getCurrentUrl());
        String google = driver.getCurrentUrl();

//        driver.navigate().back();



        driver.quit();
    }
}
