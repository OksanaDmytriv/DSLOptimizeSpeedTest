package core.exceptions;


import org.openqa.selenium.WebDriverException;

public class ElementNotFoundException extends WebDriverException {

    public ElementNotFoundException(String text) {
        super(text);
    }
}
