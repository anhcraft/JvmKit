package dev.anhcraft.jvmkit.utils;


import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Objects;

/**
 * A tuple of three objects.
 * @param <F> The data type of the first
 * @param <S> The data type of the second
 * @param <T> The data type of the third
 */
public class Triplet<F, S, T> implements Serializable {
    private static final long serialVersionUID = -5618681661713280433L;

    private F first;
    private S second;
    private T third;

    /**
     * Constructs an instance of {@code Triplet} with both objects are set to null.
     */
    public Triplet(){}

    /**
     * Constructs an instance of {@code Triplet} with given objects
     * @param first the first object
     * @param second the second object
     * @param third the third object
     */
    public Triplet(@Nullable F first, @Nullable S second, @Nullable T third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Returns the first object
     * @return the object
     */
    @Nullable
    public F getFirst() {
        return first;
    }

    /**
     * Overrides the first object
     * @param first the object to be set
     */
    public void setFirst(@Nullable F first) {
        this.first = first;
    }

    /**
     * Returns the second object
     * @return the object
     */
    @Nullable
    public S getSecond() {
        return second;
    }

    /**
     * Overrides the second object
     * @param second the object to be set
     */
    public void setSecond(@Nullable S second) {
        this.second = second;
    }

    /**
     * Returns the third object
     * @return the object
     */
    @Nullable
    public T getThird() {
        return third;
    }

    /**
     * Overrides the third object
     * @param third the object to be set
     */
    public void setThird(@Nullable T third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triplet<?, ?, ?> pair = (Triplet<?, ?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second) &&
                Objects.equals(third, pair.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }
}
