package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.Immutable;

/**
 * Represents an immutable {@link TimedMap}.
 * @param <K> the data type of keys
 * @param <V> the data type of values
 */
@Immutable
public class ImmutableTimedMap<K, V> extends TimedMap<K, V> {
    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void put(K key, V value, long aliveTime) {
        throw new UnsupportedOperationException();
    }

    /**
     * Unsupported operation.
     */
    @Override
    @Deprecated
    public void remove(K key) {
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
    public void concat(TimedMap<K, V>... maps) {
        throw new UnsupportedOperationException();
    }
}
