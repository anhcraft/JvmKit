package dev.anhcraft.jvmkit.utils;

import java.util.ArrayList;

/**
 * Represents an immutable {@link TimedList}.
 * @param <E> element type
 */
public class ImmutableTimedList<E> extends ImmutableTimedCollection<E> {
    /**
     * Constructs an instance of {@code ImmutableTimedList} with no elements.
     */
    public ImmutableTimedList() {
        super(new ArrayList<>());
    }

    /**
     * Constructs an instance of {@code ImmutableTimedList} by cloning given mutable one.
     * @param list timed list
     */
    public ImmutableTimedList(TimedList<E> list) {
        super(list.data);
    }
}