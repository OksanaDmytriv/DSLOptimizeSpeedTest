package core.conditions;

import core.exceptions.WebDriverAssertionException;
import core.wrappers.LazyEntity;

public abstract class AbstractCondition<T> implements Condition<T>, DescribesResult {

    private LazyEntity lazyEntity;

    public String toString() {
        return "\n" + this.getClass() + "\n" +
                "for " + identity() + "\n" +
                "found by: " + lazyEntity + "\n" +
                "expected: " + expected() + "\n" +
                "actual: " + actual();
    }

    public T apply(LazyEntity lazyEntity) {
        this.lazyEntity = lazyEntity;
        T entity = (T) lazyEntity.getWrappedEntity();
        if (!check(entity)) {
            throw new WebDriverAssertionException(this.toString());
        }
        return entity;
    }

    public abstract boolean check(T entity);
}
