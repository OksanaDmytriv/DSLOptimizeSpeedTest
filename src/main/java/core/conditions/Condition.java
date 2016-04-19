package core.conditions;

import core.wrappers.LazyEntity;

public interface Condition<T> {

    T apply(LazyEntity lazyEntity);
}
