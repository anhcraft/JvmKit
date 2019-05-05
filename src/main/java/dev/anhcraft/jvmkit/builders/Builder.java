package dev.anhcraft.jvmkit.builders;

/**
 * This class represents a builder implementation. A builder has the capacity of creating complex things in easier steps than the usual way.
 * @param <T> the data type of the result
 */
public interface Builder<T> {
    /**
     * Starts to build and returns the result.
     * @return result
     */
    T build();
}
