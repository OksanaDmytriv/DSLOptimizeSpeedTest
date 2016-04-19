package core.wrappers.forElement;

import core.conditions.ElementCondition;
import core.exceptions.ElementNotFoundException;
import core.wrappers.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LazyCollectionFoundByConditionElement extends AbstractLazyElement {

    private LazyCollection parentCollection;
    private ElementCondition condition;

    public LazyCollectionFoundByConditionElement(LazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " find(" + condition.getClass() + ")";
    }

    public WebElement fetchWrappedEntity() {
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (WebElement element : elements) {
            if (condition.check(element)) {
                return element;
            }
        }
        throw new ElementNotFoundException(this.toString());
    }
}
