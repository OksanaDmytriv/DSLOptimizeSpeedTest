package core;

import core.conditions.Condition;
import core.wrappers.LazyEntity;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;

import static core.Configuration.pollingInterval;

public class WaitFor {

    public static <T> T until(LazyEntity lazyEntity, Condition<T>... conditions) {
        T result = null;
        for (Condition<T> condition : conditions) {
            result = until(lazyEntity, condition, Configuration.timeout);
        }
        return result;
    }

    public static <T> T until(LazyEntity lazyEntity, Condition<T> condition, int timeoutMs) {
        Exception cause;
        final long startTime = System.currentTimeMillis();
        do {
            try {
                return condition.apply(lazyEntity);
            } catch (WebDriverException e) {
                cause = e;
            }
            sleep(pollingInterval);
        }
        while (System.currentTimeMillis() - startTime < timeoutMs);
        throw new TimeoutException("\nfailed while waiting " + timeoutMs / 1000 + " seconds \nto assert " + condition, cause);
    }

    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
