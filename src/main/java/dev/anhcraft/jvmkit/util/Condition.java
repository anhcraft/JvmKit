package dev.anhcraft.jvmkit.util;

import dev.anhcraft.jvmkit.lang.IllegalValueException;

import java.util.Collection;

/**
 * This class provides methods for value validation.
 */
public class Condition {
    /**
     * Validates whether the given expression is true.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param expression expression
     */
    public static void check(boolean expression) {
        if(expression) return;
        try {
            throw new IllegalValueException(null);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given expression is true.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param expression expression
     * @param errorMessage error message
     */
    public static void check(boolean expression, String errorMessage) {
        if(expression) return;
        try {
            throw new IllegalValueException(errorMessage);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether two given objects are similar.<br>
     * If both of them are null, they will be recognized as similar.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param objectA first object
     * @param objectB second object
     */
    public static void equal(Object objectA, Object objectB){
        if(objectA == null && objectB == null) return;
        if(objectA != null && objectA.equals(objectB)) return;
        try {
            throw new IllegalValueException(null);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether two given objects are similar.<br>
     * If both of them are null, they will be recognized as similar.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param objectA first object
     * @param objectB second object
     * @param errorMessage error message
     */
    public static void equal(Object objectA, Object objectB, String errorMessage){
        if(objectA == null && objectB == null) return;
        if(objectA != null && objectA.equals(objectB)) return;
        try {
            throw new IllegalValueException(errorMessage);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given object is non-null.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param object object
     */
    public static void notNull(Object object){
        if(object != null) return;
        try {
            throw new IllegalValueException(null);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given object is non-null.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param object object
     * @param errorMessage error message
     */
    public static void notNull(Object object, String errorMessage){
        if(object != null) return;
        try {
            throw new IllegalValueException(errorMessage);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given array is non-empty.<br>
     * If the array is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param array array
     * @param <T> the element type
     */
    public static <T> void notEmpty(T[] array){
        if(array != null && array.length > 0) return;
        try {
            throw new IllegalValueException(null);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given array is non-empty.<br>
     * If the array is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param array array
     * @param errorMessage error message
     * @param <T> the element type
     */
    public static <T> void notEmpty(T[] array, String errorMessage){
        if(array != null && array.length > 0) return;
        try {
            throw new IllegalValueException(errorMessage);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given collection is non-empty.<br>
     * If the collection is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param collection collection
     * @param <E> the element type
     */
    public static <E> void notEmpty(Collection<E> collection){
        if(collection != null && collection.size() > 0) return;
        try {
            throw new IllegalValueException(null);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given collection is non-empty.<br>
     * If the collection is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param collection collection
     * @param errorMessage error message
     * @param <E> the element type
     */
    public static <E> void notEmpty(Collection<E> collection, String errorMessage){
        if(collection != null && collection.size() > 0) return;
        try {
            throw new IllegalValueException(errorMessage);
        } catch (IllegalValueException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given argument is non-null.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with a message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-null (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotNull(String param, Object arg){
        if(arg != null) return;
        var stacktrace = Thread.currentThread().getStackTrace()[2];
        try {
            throw new IllegalArgumentException("`"+param+"` must be non-null ("+stacktrace.getClassName()+"#"+stacktrace.getMethodName()+")");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with a message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     * @param <T> the element type of the given argument
     */
    public static <T> void argNotEmpty(String param, T[] arg){
        if(arg != null && arg.length > 0) return;
        var stacktrace = Thread.currentThread().getStackTrace()[2];
        try {
            throw new IllegalArgumentException("`"+param+"` must be non-empty ("+stacktrace.getClassName()+"#"+stacktrace.getMethodName()+")");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with a message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     * @param <T> the element type of the given argument
     */
    public static <T> void argNotEmpty(String param, Iterable<T> arg){
        if(arg != null && arg.iterator().hasNext()) return;
        var stacktrace = Thread.currentThread().getStackTrace()[2];
        try {
            throw new IllegalArgumentException("`"+param+"` must be non-empty ("+stacktrace.getClassName()+"#"+stacktrace.getMethodName()+")");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
