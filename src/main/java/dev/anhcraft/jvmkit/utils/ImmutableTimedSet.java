package dev.anhcraft.jvmkit.utils;

import java.util.HashSet;

/**
 * Represents an immutable {@link TimedSet}.
 * @param <E> element type
 */
public class ImmutableTimedSet<E> extends ImmutableTimedCollection<E> {
    /**
     * Constructs an instance of {@code ImmutableTimedSet} with no elements.
     */
    public ImmutableTimedSet() {
        super(new HashSet<>());
    }

    /**
     * Constructs an instance of {@code ImmutableTimedSet} by cloning given mutable one.
     * @param set timed set
     */
    public ImmutableTimedSet(TimedSet<E> set) {
        super(set.data);
    }
}