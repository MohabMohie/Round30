package engine;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

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
        return wait.until(d -> {
            boolean isDisplayed = d.findElement(by).isDisplayed();
            System.out.println("Element display state: " + isDisplayed);
            return isDisplayed;
        });
    }

    public String getAttribute(By firstResultLink, String attribute) {
        return wait.until(d -> {
            String attributeValue = d.findElement(firstResultLink).getDomAttribute(attribute);
            System.out.println("The value of the " + attribute + " attribute is: " + attributeValue);
            return attributeValue;
        });
    }

    public String getText(By xpath) {
        return wait.until(d -> {
            String text = d.findElement(xpath).getText();
            System.out.println("Text: " + text);
            return text;
        });
    }
}
