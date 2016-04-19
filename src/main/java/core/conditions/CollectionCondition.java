package core.conditions;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class CollectionCondition extends AbstractCondition<List<WebElement>> {

    public String identity() {
        return "elements";
    }
}
