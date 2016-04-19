package core.conditions.element;

import core.conditions.ElementCondition;
import org.openqa.selenium.WebElement;

public class Text extends ElementCondition {

    public String currentText;
    public final String text;
    public WebElement element;

    public Text(String text) {
        this.text = text;
    }

    public boolean check(WebElement element) {
        currentText = element.getText();
        return checkElement();
    }

    public boolean checkElement() {
        return currentText.contains(text);
    }

    @Override
    public String actual() {
        return currentText;
    }

    @Override
    public String expected() {
        return text;
    }
}
