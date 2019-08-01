package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.Immutable;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Represents an immutable {@link TimedCollection}.
 * @param <E> element type
 */
@Immutable
public class ImmutableTimedCollection<E> extends TimedCollection<E> {
    ImmutableTimedCollection(Collection<Pair<E, Long>> data) {
        super(data);
    }

    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void add(E elem, long aliveTime) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void removeAll(E elem) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void removeAt(int index) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void addAll(TimedCollection<E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        private int next;

        @Override
        public boolean hasNext(){
            return next < size();
        }

        @Override
        public E next(){
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return get(next++);
        }

        /**
         * Unsupported operation.
         */
        @Override
        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
