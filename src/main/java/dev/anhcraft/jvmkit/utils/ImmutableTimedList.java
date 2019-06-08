package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashSet;

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
    public ImmutableTimedList(@NotNull TimedList<E> list) {
        super(new HashSet<>(list.data));
    }
}