package dev.anhcraft.jvmkit.utils;


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
    public Triplet(F first, S second, T third){
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * Returns the first object
     * @return the object
     */
    public F getFirst() {
        return first;
    }

    /**
     * Overrides the first object
     * @param first the object to be set
     */
    public void setFirst(F first) {
        this.first = first;
    }

    /**
     * Returns the second object
     * @return the object
     */
    public S getSecond() {
        return second;
    }

    /**
     * Overrides the second object
     * @param second the object to be set
     */
    public void setSecond(S second) {
        this.second = second;
    }

    /**
     * Returns the third object
     * @return the object
     */
    public T getThird() {
        return third;
    }

    /**
     * Overrides the third object
     * @param third the object to be set
     */
    public void setThird(T third) {
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
