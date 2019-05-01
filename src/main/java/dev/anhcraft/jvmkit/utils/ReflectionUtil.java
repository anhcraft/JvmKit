package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * This class provides utility methods for interacting with Java Reflection.
 */
public class ReflectionUtil {
    /**
     * Returns the value of a field.<br>
     * If the {@code object} argument is null, the field must have the {@code static} modifier.
     * @param clazz the class represents the object
     * @param object the object which contains the value of the field
     * @param fieldName the name of the field
     * @return the value of the field
     */
    public static Object getField(@NotNull Class<?> clazz, Object object, @NotNull String fieldName){
        Condition.argNotNull("clazz", clazz);
        Condition.argNotNull("fieldName", fieldName);
        try {
            Field f = clazz.getField(fieldName);
            f.setAccessible(true);
            return f.get(object);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Returns the value of a {@code static} field.
     * @param clazz the class which contains that field
     * @param fieldName the name of the field
     * @return the value of the field
     */
    public static Object getStaticField(@NotNull Class<?> clazz, String fieldName){
        return getField(clazz, null, fieldName);
    }

    /**
     * Returns the value of an enum.
     * @param clazz the class which contains that enum
     * @param enumName the name of the enum
     * @return the value of the enum
     */
    public static Object getEnum(@NotNull Class<? extends Enum> clazz, @NotNull String enumName){
        return getField(clazz, null, enumName);
    }

    /**
     * Set a field to the given value.<br>
     * If the {@code object} argument is null, the field must have the {@code static} modifier.
     * @param clazz the class represents the object
     * @param object the object which contains the value of the field
     * @param fieldName the name of the field
     * @param fieldValue the new value
     */
    public static void setField(@NotNull Class<?> clazz, Object object, @NotNull String fieldName, Object fieldValue){
        Condition.argNotNull("clazz", clazz);
        Condition.argNotNull("fieldName", fieldName);
        try {
            Field f = clazz.getField(fieldName);
            f.setAccessible(true);
            f.set(object, fieldValue);
        } catch(NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set a {@code static} field to the given value.
     * @param clazz the class which contains that field
     * @param fieldName the name of the field
     * @param fieldValue the new value
     */
    public static void setStaticField(@NotNull Class<?> clazz, @NotNull String fieldName, Object fieldValue){
        setField(clazz, null, fieldName, fieldValue);
    }

    /**
     * Invokes a method with the given arguments, then returns the result.<br>
     * If the {@code object} argument is null, the method must have the {@code static} modifier.
     * @param clazz the class represents the object
     * @param object the object which contains the method
     * @param method the method name
     * @param params all parameters of the method
     * @param args all arguments to be passed into parameters
     * @return the received result after called the method
     */
    public static Object invokeMethod(@NotNull Class<?> clazz, Object object, @NotNull String method, Class<?>[] params, Object[] args){
        Condition.argNotNull("clazz", clazz);
        Condition.argNotNull("method", method);
        try {
            Method f = clazz.getMethod(method, params);
            f.setAccessible(true);
            return f.invoke(object, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Invokes a method with no arguments, then returns the result.<br>
     * If the {@code object} argument is null, the method must have the {@code static} modifier.
     * @param clazz the class represents the object
     * @param object the object which contains the method
     * @param method the method name
     * @return the received result after called the method
     */
    public static Object invokeMethod(@NotNull Class<?> clazz, Object object, @NotNull String method){
        return invokeMethod(clazz, object, method, null, null);
    }

    /**
     * Invokes a {@code static} method with the given arguments, then returns the result.
     * @param clazz the class which contains the method
     * @param method the method name
     * @param params all parameters of the method
     * @param args all arguments to be passed into parameters
     * @return the received result after called the method
     */
    public static Object invokeStaticMethod(@NotNull Class<?> clazz, @NotNull String method, Class<?>[] params, Object[] args){
        return invokeMethod(clazz, null, method, params, args);
    }

    /**
     * Invokes a {@code static} method with no arguments, then returns the result.
     * @param clazz the class which contains the method
     * @param method the method name
     * @return the received result after called the method
     */
    public static Object invokeStaticMethod(@NotNull Class<?> clazz, @NotNull String method){
        return invokeMethod(clazz, null, method, null, null);
    }

    /**
     * Calls a constructor with the given arguments to create a new instance, then returns it.
     * @param clazz the class which contains the constructor
     * @param params all parameters of the constructor
     * @param args all arguments to be passed into parameters
     * @return the new object which is a result of calling the constructor
     */
    public static Object newInstance(@NotNull Class<?> clazz, Class<?>[] params, Object[] args){
        Condition.argNotNull("clazz", clazz);
        try {
            Constructor<?> f = clazz.getConstructor(params);
            f.setAccessible(true);
            return f.newInstance(args);
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Calls a constructor with no arguments to create a new instance, then returns it.
     * @param clazz the class which contains the constructor
     * @return the new object which is a result of calling the constructor
     */
    public static Object newInstance(@NotNull Class<?> clazz){
        return newInstance(clazz, null, null);
    }

    /**
     * Gets all fields from the given class and its superclasses in the class hierarchy.
     * @param clazz the lowest class in the class hierarchy
     * @return array of fields
     */
    public static Field[] getAllFields(@NotNull Class<?> clazz) {
        Condition.argNotNull("clazz", clazz);
        var fields = clazz.getDeclaredFields();
        while(!(clazz = clazz.getDeclaringClass().getSuperclass()).equals(Object.class)){
            fields = ArrayUtil.concat(fields, clazz.getDeclaredFields());
        }
        return fields;
    }
}
