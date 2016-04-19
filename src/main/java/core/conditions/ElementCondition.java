package core.conditions;

import org.openqa.selenium.WebElement;

public abstract class ElementCondition extends AbstractCondition<WebElement> {

    public String identity() {
        return "element";
    }
}
