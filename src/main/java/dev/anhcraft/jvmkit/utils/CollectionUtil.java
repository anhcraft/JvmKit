package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.List;

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
    @NotNull
    public static <E> E[] toArray(@NotNull Collection<E> collection, @NotNull Class<? extends E> clazz){
        Condition.argNotNull("collection", collection);
        Condition.argNotNull("clazz", clazz);
        return collection.toArray((E[]) Array.newInstance(DataTypeUtil.getObjectClass(clazz), collection.size()));
    }

    @Nullable
    public static <E> E getElementAt(int index, @NotNull Collection<E> collection){
        Condition.argNotNull("collection", collection);
        if(collection instanceof List) {
            return ((List<E>) collection).get(index);
        } else {
            return collection.stream().skip(index).findFirst().orElse(null);
        }
    }
}
