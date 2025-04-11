package flatPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

public class TasksTests {
    WebDriver driver;

    @Test
    public void navigateToDuckuckGoAndCheckPageTitle(){
        // test steps
        driver.navigate().to("https://duckduckgo.com/");

        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Google");
//        Assert.assertNotEquals(pageTitle, "Google");
//
//        Assert.assertTrue(pageTitle.equals("Google"));
//        Assert.assertFalse(pageTitle.equals("Google"));
    }

    @BeforeMethod
    public void beforeMethod(){
        // driver initialization
        ChromeOptions options;
        options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setBrowserVersion("134");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void afterMethod(){
        // driver termination
        driver.quit();
    }

}
