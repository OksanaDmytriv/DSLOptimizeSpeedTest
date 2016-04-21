package core.wrappers;

import core.conditions.Condition;
import core.wrappers.forElement.AbstractLazyElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import static core.Configuration.pollingInterval;
import static javafx.scene.input.KeyCode.T;

public class Wrapper {

    AbstractLazyElement element;

    public void until(LazyEntity lazyEntity, Condition<T> condition, int timeoutMs) {
        Exception cause;
        final long startTime = System.currentTimeMillis();
        do {
            try {
                AbstractLazyElement.clear();
            } catch (WebDriverException e) {
                cause = e;
            }
            sleep(pollingInterval);
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        throw new TimeoutException("\nfailed while waiting " + timeoutMs / 1000 + " seconds \nto assert " + condition, cause);
    }

    private void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

}
