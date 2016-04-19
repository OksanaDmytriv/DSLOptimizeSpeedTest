package core.exceptions;


import org.openqa.selenium.WebDriverException;

public class WebDriverAssertionException extends WebDriverException {

    public WebDriverAssertionException(String text) {
        super(text);
    }
}
