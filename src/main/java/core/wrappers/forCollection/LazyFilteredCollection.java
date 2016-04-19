package core.wrappers.forCollection;

import core.conditions.ElementCondition;
import core.wrappers.LazyCollection;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LazyFilteredCollection extends AbstractLazyCollection {

    private ElementCondition condition;
    private LazyCollection parentCollection;

    public LazyFilteredCollection(LazyCollection parentCollection, ElementCondition condition) {
        this.parentCollection = parentCollection;
        this.condition = condition;
    }

    public String toString() {
        return parentCollection.toString() + " filter(" + condition.getClass() + ')';
    }

    public List<WebElement> fetchWrappedEntity() {
        List<WebElement> newList = new ArrayList<WebElement>();
        List<WebElement> elements = parentCollection.getWrappedEntity();
        for (WebElement element : elements) {
            if (condition.check(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
