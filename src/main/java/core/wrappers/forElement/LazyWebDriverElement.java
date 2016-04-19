package core.wrappers.forElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static core.ConciseAPI.getDriver;

public class LazyWebDriverElement extends AbstractLazyElement {

    private By locator;

    public LazyWebDriverElement(By locator) {
        this.locator = locator;
    }

    public String toString() {
        return locator.toString();
    }

    public WebElement fetchWrappedEntity() {
        return getDriver().findElement(locator);
    }
}
