package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.IllegalValueException;

import java.util.Collection;
import java.util.Iterator;

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
     * Validates whether the given expression is true.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param expression expression
     * @param errorMessageFormat error message format
     * @param objects objects to be included the error message
     */
    public static void check(boolean expression, String errorMessageFormat, Object... objects) {
        if(expression) return;
        try {
            throw new IllegalValueException(String.format(errorMessageFormat, objects));
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
        check(object != null);
    }

    /**
     * Validates whether the given object is non-null.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param object object
     * @param errorMessage error message
     */
    public static void notNull(Object object, String errorMessage){
        check(object != null, errorMessage);
    }

    /**
     * Validates whether the given array is non-empty.<br>
     * If the array is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param array array
     * @param <T> the element type
     */
    public static <T> void notEmpty(T[] array){
        check(array != null && array.length > 0);
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
        check(array != null && array.length > 0);
    }

    /**
     * Validates whether the given collection is non-empty.<br>
     * If the collection is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param collection collection
     * @param <E> the element type
     */
    public static <E> void notEmpty(Collection<E> collection){
        check(collection != null && !collection.isEmpty());
    }

    /**
     * Validates whether the given iterator is non-empty.<br>
     * If the iterator is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param iterator iterator
     * @param <E> the element type
     */
    public static <E> void notEmpty(Iterator<E> iterator){
        check(iterator != null && iterator.hasNext());
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
        check(collection != null && !collection.isEmpty(), errorMessage);
    }

    /**
     * Validates whether the given iterator is non-empty.<br>
     * If the iterator is null, it will still be recognized as empty.<br>
     * If the condition is not met, {@link IllegalValueException} will be thrown.
     * @param iterator iterator
     * @param errorMessage error message
     * @param <E> the element type
     */
    public static <E> void notEmpty(Iterator<E> iterator, String errorMessage){
        check(iterator != null && iterator.hasNext(), errorMessage);
    }

    /**
     * Validates whether the given argument is non-null.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-null (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotNull(String param, Object arg){
        if(arg != null) return;
        StackTraceElement stacktrace = Thread.currentThread().getStackTrace()[2];
        try {
            throw new IllegalArgumentException("`"+param+"` must be non-null ("+stacktrace.getClassName()+"#"+stacktrace.getMethodName()+")");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    private static void emptyThrow(String param){
        StackTraceElement stacktrace = Thread.currentThread().getStackTrace()[2];
        try {
            throw new IllegalArgumentException("`"+param+"` must be non-empty ("+stacktrace.getClassName()+"#"+stacktrace.getMethodName()+")");
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, int[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, boolean[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, long[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, byte[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, short[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, float[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, double[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     */
    public static void argNotEmpty(String param, char[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     * @param <T> the element type of the given argument
     */
    public static <T> void argNotEmpty(String param, T[] arg){
        if(arg == null || arg.length == 0) emptyThrow(param);
    }

    /**
     * Validates whether the given argument is non-empty.<br>
     * Even if the argument is null, it still can't get accepted.<br>
     * If the condition is not met, {@link IllegalArgumentException} will be thrown with the following message:<br>
     * <em>&#96;&lt;param&gt;&#96; must be non-empty (&lt;previous class&gt;#&lt;previous method&gt;)</em>
     * @param param the parameter which the argument was passed into
     * @param arg the argument
     * @param <T> the element type of the given argument
     */
    public static <T> void argNotEmpty(String param, Iterable<T> arg){
        if(arg == null || !arg.iterator().hasNext()) emptyThrow("param");
    }
}
