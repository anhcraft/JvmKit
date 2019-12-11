package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * A pair of non-null objects.
 * @param <F> The data type of the first
 * @param <S> The data type of the second
 */
public class PresentPair<F, S> implements Serializable {
    private static final long serialVersionUID = 8101761173614189785L;

    private F first;
    private S second;

    /**
     * Constructs an instance of {@code Pair} with given objects
     * @param first the first object
     * @param second the second object
     */
    public PresentPair(@NotNull F first, @NotNull S second){
        Condition.argNotNull("first", first);
        Condition.argNotNull("second", second);
        this.first = first;
        this.second = second;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PresentPair<?, ?> pair = (PresentPair<?, ?>) o;
        return first.equals(pair.first) && second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
