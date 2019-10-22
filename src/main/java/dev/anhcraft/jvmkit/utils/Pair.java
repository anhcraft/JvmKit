package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.Nullable;

import java.io.Serializable;
import java.util.Objects;

/**
 * A pair of objects.
 * @param <F> The data type of the first
 * @param <S> The data type of the second
 */
public class Pair<F, S> implements Serializable {
    private static final long serialVersionUID = 8101761173614189785L;

    private F first;
    private S second;

    /**
     * Constructs an instance of {@code Pair} with both objects are set to null.
     */
    public Pair(){}

    /**
     * Constructs an instance of {@code Pair} with given objects
     * @param first the first object
     * @param second the second object
     */
    public Pair(@Nullable F first, @Nullable S second){
        this.first = first;
        this.second = second;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
