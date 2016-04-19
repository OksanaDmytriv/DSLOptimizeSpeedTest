package core.wrappers.forElement;

import core.wrappers.LazyElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LazyElementInnerElement extends AbstractLazyElement {

    private By innerLocator;
    private LazyElement parentElement;

    public LazyElementInnerElement(LazyElement parentElement, By innerLocator) {
        this.parentElement=parentElement;
        this.innerLocator=innerLocator;
    }

    public String toString() {
        return parentElement.toString() + " " + innerLocator + "";
    }

    public WebElement fetchWrappedEntity() {
        return parentElement.getWrappedEntity().findElement(innerLocator);
    }

}
