package dev.anhcraft.jvmkit.utils;


import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * A tuple of non-null three objects.
 * @param <F> The data type of the first
 * @param <S> The data type of the second
 * @param <T> The data type of the third
 */
public class PresentTriplet<F, S, T> implements Serializable {
    private static final long serialVersionUID = 7531783469480959997L;

    private F first;
    private S second;
    private T third;

    /**
     * Constructs an instance of {@code Triplet} with given objects
     * @param first the first object
     * @param second the second object
     * @param third the third object
     */
    public PresentTriplet(@NotNull F first, @NotNull S second, @NotNull T third){
        Condition.argNotNull("first", first);
        Condition.argNotNull("second", second);
        Condition.argNotNull("third", third);
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Returns the first object
     * @return the object
     */
    @NotNull
    public F getFirst() {
        return first;
    }

    /**
     * Overrides the first object
     * @param first the object to be set
     */
    public void setFirst(@NotNull F first) {
        Condition.argNotNull("first", first);
        this.first = first;
    }

    /**
     * Returns the second object
     * @return the object
     */
    @NotNull
    public S getSecond() {
        return second;
    }

    /**
     * Overrides the second object
     * @param second the object to be set
     */
    public void setSecond(@NotNull S second) {
        Condition.argNotNull("second", second);
        this.second = second;
    }

    /**
     * Returns the third object
     * @return the object
     */
    @NotNull
    public T getThird() {
        return third;
    }

    /**
     * Overrides the third object
     * @param third the object to be set
     */
    public void setThird(@NotNull T third) {
        Condition.argNotNull("third", third);
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresentTriplet<?, ?, ?> pair = (PresentTriplet<?, ?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second) && third.equals(pair.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
