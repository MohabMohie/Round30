package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.Objects;

public class Bot {
    private final Wait<WebDriver> wait;

    public Bot(WebDriver driver) {
        this.wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(NotFoundException.class)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(ElementNotInteractableException.class);
    }

    public Bot sendKeys (By by, CharSequence text) {
        wait.until(d ->{
            d.findElement(by).clear();
            d.findElement(by).sendKeys(text);
            System.out.println("Typed "+text+" into "+by);
            return true;
        });
        return this;
    }

    public Bot click (By by) {
        wait.until(d ->{
            d.findElement(by).click();
            System.out.println("Clicked "+by);
            return true;
        });
        return this;
    }

    public boolean isDisplayed (By by) {
        return wait.until(d -> d.findElement(by).isDisplayed());
    }

    public String getAttribute(By firstResultLink, String attribute) {
//        return wait.until(d -> d.findElement(firstResultLink).getDomAttribute(attribute));
        return wait.until(d -> Objects.requireNonNull(d.findElement(firstResultLink).getDomAttribute(attribute)));
    }
}
