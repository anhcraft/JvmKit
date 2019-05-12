package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.Beta;
import dev.anhcraft.jvmkit.lang.annotation.NotEmpty;
import dev.anhcraft.jvmkit.lang.annotation.NotNull;
import kotlin.Pair;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Represents a {@link HashMap} which can clean its expired entries automatically.
 * @param <K> the data type of keys
 * @param <V> the data type of values
 */
@Beta
public class TimedMap<K, V> implements Serializable {
    private static final long serialVersionUID = -1174873351669084661L;

    private HashMap<K, Pair<V, Long>> data;

    /**
     * Constructs an instance of {@code TimedMap} with no entries.
     */
    public TimedMap() {
        this.data = new HashMap<>();
    }

    /**
     * Constructs an instance of {@code TimedMap} by cloning existing one.
     * @param map timed map
     */
    public TimedMap(@NotNull TimedMap<K, V> map) {
        Condition.argNotNull("map", map);
        this.data = new HashMap<>(map.data);
    }

    private boolean isExpired(long time) {
        return System.currentTimeMillis() >= time;
    }

    private void cleanExpiredElements() {
        data.entrySet().removeIf(pair -> isExpired(pair.getValue().getSecond()));
    }

    /**
     * Checks whether the given entry was expired.
     * @param key entry's key
     * @return {@code true} if it was expired. Otherwise is {@code false}
     */
    public boolean isExpired(K key) {
        return !data.containsKey(key) || System.currentTimeMillis() >= data.get(key).getSecond();
    }

    /**
     * Gets the expiry time of an entry.
     * @param key entry's key
     * @return expiry time (or {@code -1} if the entry did not exist)
     */
    public long getExpiryTime(K key) {
        for(Map.Entry<K, Pair<V, Long>> pair : data.entrySet()) {
            if(pair.getKey().equals(key)) return pair.getValue().getSecond();
        }
        return -1L;
    }

    /**
     * Returns the total number of entries.
     * @return total number of entries.
     */
    public int size() {
        cleanExpiredElements();
        return data.size();
    }

    /**
     * Checks whether this map is empty.
     * @return {@code true} if it is empty. Otherwise is {@code false}
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Checks whether this map contains the given key.
     * @param key key
     * @return {@code true} if that key exists in this map. Otherwise is {@code false}
     */
    public boolean containsKey(K key) {
        cleanExpiredElements();
        return data.keySet().stream().anyMatch(p -> p.equals(key));
    }

    /**
     * Checks whether this map contains the given value.
     * @param value value
     * @return {@code true} if that value exists in this map. Otherwise is {@code false}
     */
    public boolean containsValue(V value) {
        cleanExpiredElements();
        return data.values().stream().anyMatch(p -> p.getSecond().equals(value));
    }

    /**
     * Puts the given entry into this map.<br>
     * If the key exists, its value will be overridden instead.
     * @param key the key
     * @param value the value
     * @param aliveTime the alive time (in milliseconds)
     */
    public void put(K key, V value, long aliveTime) {
        cleanExpiredElements();
        data.put(key, new Pair<>(value, System.currentTimeMillis()+aliveTime));
    }

    /**
     * Removes an entry by using its key to find.
     * @param key entry's key
     */
    public void remove(K key) {
        cleanExpiredElements();
        data.remove(key);
    }

    /**
     * Removes the entry at given index.
     * @param index index
     */
    public void removeAt(int index) {
        cleanExpiredElements();
        Iterator<Map.Entry<K, Pair<V, Long>>> it = data.entrySet().iterator();
        for(int i = 0; i <= index && it.hasNext(); i++) it.next();
        it.remove();
    }

    /**
     * Gets the entry at given index.
     * @param index index
     * @return the entry (or {@code null} if it did not exist)
     */
    public Map.Entry<K, V> getEntry(int index){
        cleanExpiredElements();
        var opt = data.entrySet().stream().skip(index).findFirst();
        if(opt.isPresent()){
            var ent = opt.get();
            return new Map.Entry<>() {
                @Override
                public K getKey() {
                    return ent.getKey();
                }

                @Override
                public V getValue() {
                    return ent.getValue().getFirst();
                }

                @Override
                public V setValue(V value) {
                    var val = ent.getValue();
                    var old = val.getFirst();
                    ent.setValue(ent.getValue().copy(value, val.getSecond()));
                    return old;
                }
            };
        } return null;
    }

    /**
     * Gets the value of an entry.
     * @param key entry's key
     * @return the value
     */
    public V getValue(K key) {
        cleanExpiredElements();
        return data.get(key).getFirst();
    }

    /**
     * Clears this map.
     */
    public void clear() {
        data.clear();
    }

    /**
     * Concatenate given timed maps into this one.
     * @param maps maps
     */
    public void concat(@NotNull @NotEmpty TimedMap<K, V>... maps) {
        Condition.argNotEmpty("maps", maps);
        cleanExpiredElements();
        for(var map : maps){
            if(map == null || map.isEmpty()) continue;
            data.putAll(map.data);
        }
    }

    /**
     * Returns all keys.
     * @return set of keys
     */
    public Set<K> keySet(){
        cleanExpiredElements();
        return data.keySet();
    }

    /**
     * Returns all values.
     * @return collection of values
     */
    public Collection<V> values(){
        cleanExpiredElements();
        return data.values().stream().map(Pair::getFirst).collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimedMap<?, ?> timedMap = (TimedMap<?, ?>) o;
        return Objects.equals(data, timedMap.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}