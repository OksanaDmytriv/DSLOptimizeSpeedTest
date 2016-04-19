package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Visible extends ElementCondition {

    private boolean currentState;

    @Override
    public boolean check(WebElement element) {
        currentState = element.isDisplayed();
        return currentState;
    }

    @Override
    public String actual() {
        return currentState ? "Visible" : "Invisible";
    }

    @Override
    public String expected() {
        return "Visible";
    }
}
