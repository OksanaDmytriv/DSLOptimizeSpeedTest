package core.wrappers;

public interface LazyEntity<T> {

    T fetchWrappedEntity();

    T getWrappedEntity();
}
