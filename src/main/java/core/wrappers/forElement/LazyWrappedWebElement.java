package core.wrappers.forElement;


import org.openqa.selenium.WebElement;
import core.wrappers.LazyEntity;

public class LazyWrappedWebElement extends AbstractLazyElement {

    private LazyEntity parentEntity;
    private WebElement element;

    public LazyWrappedWebElement(LazyEntity parentEntity, WebElement element) {
        this.parentEntity = parentEntity;
        this.element = element;
    }

    public String toString() {
        return parentEntity.toString() + " " + element.toString();
    }

    public WebElement fetchWrappedEntity() {
        return element;
    }
}
