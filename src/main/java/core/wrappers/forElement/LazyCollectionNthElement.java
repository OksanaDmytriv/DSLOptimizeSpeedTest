package core.wrappers.forElement;

import core.exceptions.LazyСollectionIndexOutOfBoundsException;
import core.wrappers.LazyCollection;
import org.openqa.selenium.WebElement;

public class LazyCollectionNthElement extends AbstractLazyElement {

    private int index;
    private LazyCollection parentCollection;

    public LazyCollectionNthElement(LazyCollection parentCollection, int index) {
        this.parentCollection = parentCollection;
        this.index = index;
    }

    public String toString() {
        return parentCollection.toString() + "[" + index + "]";
    }

    public WebElement fetchWrappedEntity() {
        try {
            return parentCollection.getWrappedEntity().get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new LazyСollectionIndexOutOfBoundsException(this.toString());
        }
    }
}
