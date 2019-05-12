package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;

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
    public ImmutableTimedSet(@NotNull TimedSet<E> set) {
        super(new HashSet<>(set.data));
    }
}