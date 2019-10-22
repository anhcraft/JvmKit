package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

/**
 * This class provides utility methods for interacting with data types.
 */
public class DataTypeUtil {
    private static final HashMap<Class<?>, Class<?>> fromPrimitive = new HashMap<>();
    private static final HashMap<Class<?>, Class<?>> fromObject = new HashMap<>();

    private static void put(Class<?> primitiveClass, Class<?> objectClass) {
        fromPrimitive.put(primitiveClass, objectClass);
        fromObject.put(objectClass, primitiveClass);
    }

    static {
        put(byte.class, Byte.class);
        put(char.class, Character.class);
        put(short.class, Short.class);
        put(int.class, Integer.class);
        put(double.class, Double.class);
        put(float.class, Float.class);
        put(long.class, Long.class);
        put(boolean.class, Boolean.class);
        put(byte[].class, Byte[].class);
        put(char[].class, Character[].class);
        put(short[].class, Short[].class);
        put(int[].class, Integer[].class);
        put(double[].class, Double[].class);
        put(float[].class, Float[].class);
        put(long[].class, Long[].class);
        put(boolean[].class, Boolean[].class);
    }

    /**
     * Gets the suitable primitive class of the given object class.
     * @param objectClass object class
     * @return primitive class (or the old class if failed)
     */
    @NotNull
    public static Class<?> getPrimitiveClass(@NotNull Class<?> objectClass){
        Condition.argNotNull("objectClass", objectClass);
        return fromObject.getOrDefault(objectClass, objectClass);
    }

    /**
     * Gets the suitable object class of the given primitive class.
     * @param primitiveClass primitive class
     * @return object class (or the old class if failed)
     */
    @NotNull
    public static Class<?> getObjectClass(@NotNull Class<?> primitiveClass){
        Condition.argNotNull("primitiveClass", primitiveClass);
        return fromPrimitive.getOrDefault(primitiveClass, primitiveClass);
    }
}
