package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Represents a {@link HashSet} which can clean its expired elements automatically.
 * @param <E> element type
 */
public class TimedSet<E> extends TimedCollection<E> implements Serializable {
    private static final long serialVersionUID = 8931340650461461921L;

    /**
     * Constructs an instance of {@code TimedSet} with no elements.
     */
    public TimedSet() {
        super(new HashSet<>());
    }

    /**
     * Constructs an instance of {@code TimedSet} by cloning existing one.
     * @param set timed set
     */
    public TimedSet(@NotNull TimedSet<E> set) {
        super(new HashSet<>(set.data));
    }
}