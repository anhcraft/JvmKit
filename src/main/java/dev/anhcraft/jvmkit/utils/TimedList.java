package dev.anhcraft.jvmkit.utils;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a {@link ArrayList} which can clean its expired elements automatically.
 * @param <E> element type
 */
public class TimedList<E> extends TimedCollection<E> implements Serializable {
    private static final long serialVersionUID = -3359037536578640135L;

    /**
     * Constructs an instance of {@code TimedList} with no elements.
     */
    public TimedList() {
        super(new ArrayList<>());
    }

    /**
     * Constructs an instance of {@code TimedList} by cloning existing one.
     * @param list timed list
     */
    public TimedList(TimedList<E> list) {
        super(list.data);
    }
}