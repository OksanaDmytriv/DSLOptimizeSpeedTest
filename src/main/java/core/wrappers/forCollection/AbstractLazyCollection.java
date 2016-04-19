package core.wrappers.forCollection;

import core.WaitFor;
import core.conditions.CollectionCondition;
import core.conditions.ElementCondition;
import core.wrappers.LazyCollection;
import core.wrappers.LazyElement;
import core.wrappers.forElement.LazyCollectionFoundByConditionElement;
import core.wrappers.forElement.LazyCollectionNthElement;
import core.wrappers.forElement.LazyWrappedWebElement;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractLazyCollection implements LazyCollection {

    public List<WebElement> getWrappedEntity() {
        return fetchWrappedEntity();
    }

    public abstract List<WebElement> fetchWrappedEntity();

    public LazyElement get(int index) {
        return new LazyCollectionNthElement(this, index);
    }

    public LazyCollection filter(ElementCondition condition) {
        return new LazyFilteredCollection(this, condition);
    }

    public LazyElement find(ElementCondition condition) {
        return new LazyCollectionFoundByConditionElement(this, condition);
    }

    public LazyCollection should(CollectionCondition... conditions) {
        WaitFor.until(this, conditions);
        return this;
    }

    public LazyCollection shouldBe(CollectionCondition... conditions) {
        return should(conditions);
    }

    public LazyCollection shouldHave(CollectionCondition... conditions) {
        return should(conditions);
    }

    @Override
    public Iterator<LazyElement> iterator() {
        List<WebElement> elements = this.fetchWrappedEntity();
        List<LazyElement> newList = new ArrayList<>();
        for (WebElement element : elements) {
            newList.add((new LazyWrappedWebElement(this, element)));
        }
        return newList.iterator();
    }
}
