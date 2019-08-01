package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.Beta;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Represents a {@link Collection} which can clean its expired elements automatically.
 * @param <E> element type
 */
@Beta
public abstract class TimedCollection<E> implements Iterable<E> {
    protected Collection<Pair<E, Long>> data;

    TimedCollection(Collection<Pair<E, Long>> data) {
        Condition.argNotNull("data", data);
        this.data = data;
    }

    private boolean isExpired(long time) {
        return System.currentTimeMillis() >= time;
    }

    private void cleanExpiredElements() {
        data.removeIf(pair -> isExpired(pair.getSecond()));
    }

    /**
     * Checks if the given element was expired.
     * @param elem element
     * @return {@code true} if it was expired. Otherwise is {@code false}
     */
    public boolean isExpired(E elem) {
        for(Pair<E, Long> pair : data) {
            if(pair.getFirst().equals(elem)) return isExpired(pair.getSecond());
        }
        return true;
    }

    /**
     * Gets the expiry time of the given element.
     * @param elem element
     * @return expiry time (or {@code -1} if the element did not exist)
     */
    public long getExpiryTime(E elem) {
        for(Pair<E, Long> pair : data) {
            if(pair.getFirst().equals(elem)) return pair.getSecond();
        }
        return -1L;
    }

    /**
     * Returns the total number of elements.
     * @return total number of elements.
     */
    public int size() {
        cleanExpiredElements();
        return data.size();
    }

    /**
     * Checks if this collection is empty.
     * @return {@code true} if it is empty. Otherwise is {@code false}
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Checks whether this collection contains the given element.
     * @param elem element
     * @return {@code true} if it contains that element. Otherwise is {@code false}
     */
    public boolean contains(E elem) {
        cleanExpiredElements();
        return data.stream().anyMatch(pair -> pair.getFirst().equals(elem));
    }

    /**
     * Adds the given element to this collection.
     * @param elem the element
     * @param aliveTime the alive time (in milliseconds)
     */
    public void add(E elem, long aliveTime) {
        cleanExpiredElements();
        data.add(new Pair<>(elem, System.currentTimeMillis() + aliveTime));
    }

    /**
     * Removes any elements, which is equal with the given one, out of this collection.
     * @param elem element
     */
    public void removeAll(E elem) {
        data.removeIf(pair -> isExpired(pair.getSecond()) || pair.getFirst().equals(elem));
    }

    /**
     * Removes the element at given index.
     * @param index index
     */
    public void removeAt(int index) {
        cleanExpiredElements();
        if(index < 0 || index >= data.size()) throw new IndexOutOfBoundsException("Index out of range: "+index);

        Iterator<Pair<E, Long>> it = data.iterator();
        for(int i = 0; i <= index; i++) it.next();
        it.remove();
    }

    /**
     * Gets the element at given index.
     * @param index index
     * @return element (or null if it is not existed)
     */
    public E get(int index){
        cleanExpiredElements();
        return data.stream().skip(index).findFirst().map(Pair::getFirst).orElse(null);
    }

    /**
     * Clears this collection.
     */
    public void clear() {
        data.clear();
    }

    /**
     * Adds the given collection to this one.
     * @param collection the timed collection
     */
    public void addAll(TimedCollection<E> collection) {
        cleanExpiredElements();
        this.data.addAll(collection.data);
    }

    /**
     * Returns the sequential {@link Stream} of this collection.
     * @return stream
     */
    public Stream<E> stream(){
        return StreamSupport.stream(spliterator(), false);
    }

    /**
     * Returns the parallel {@link Stream} of this collection.
     * @return stream
     */
    public Stream<E> parallelStream(){
        return StreamSupport.stream(spliterator(), true);
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimedCollection<?> that = (TimedCollection<?>) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
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
            E current = get(next);
            next++;
            return current;
        }

        @Override
        public void remove() {
            next--;
            removeAt(next);
        }
    }
}