package core.wrappers.forCollection;

import core.wrappers.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyElementInnerCollection extends AbstractLazyCollection {

    private By locator;
    private LazyElement parentElement;

    public LazyElementInnerCollection(LazyElement parentElement, By locator) {
        this.parentElement=parentElement;
        this.locator = locator;
    }

    public String toString() {
        return parentElement.toString() + " " + locator + "";
    }

    public List<WebElement> fetchWrappedEntity() {
        return parentElement.getWrappedEntity().findElements(locator);
    }
}
