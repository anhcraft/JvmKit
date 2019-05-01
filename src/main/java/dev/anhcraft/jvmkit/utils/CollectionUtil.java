package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;

import java.lang.reflect.Array;
import java.util.Collection;

/**
 * This class provides utility methods for {@link Collection} manipulation.
 */
public class CollectionUtil {
    /**
     * Converts the given collection into an array.<br>
     * If the {@code clazz} argument is a primitive class, it will be turned into a similar object class.
     * @param <E> the element type
     * @param collection collection
     * @param clazz the class represents elements type
     * @return new list
     */
    @SuppressWarnings(value = "unchecked")
    public static <E> E[] toArray(@NotNull Collection<E> collection, @NotNull Class<? extends E> clazz){
        Condition.argNotNull("collection", collection);
        Condition.argNotNull("clazz", clazz);
        return collection.toArray((E[]) Array.newInstance(DataTypeUtil.getObjectClass(clazz), collection.size()));
    }
}
