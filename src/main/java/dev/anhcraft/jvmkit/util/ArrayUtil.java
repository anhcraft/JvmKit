package dev.anhcraft.jvmkit.util;

import dev.anhcraft.jvmkit.lang.annotation.NotEmpty;
import dev.anhcraft.jvmkit.lang.annotation.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class provides utility methods for array manipulation.
 */
@SuppressWarnings("unchecked")
public class ArrayUtil {
    /**
     * An immutable empty {@code int} array.
     */
    public static final int[] EMPTY_INT_ARRAY = new int[0];

    /**
     * An immutable empty {@code boolean} array.
     */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];

    /**
     * An immutable empty {@code long} array.
     */
    public static final long[] EMPTY_LONG_ARRAY = new long[0];

    /**
     * An immutable empty {@code byte} array.
     */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    /**
     * An immutable empty {@code short} array.
     */
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];

    /**
     * An immutable empty {@code float} array.
     */
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];

    /**
     * An immutable empty {@code double} array.
     */
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];

    /**
     * An immutable empty {@code char} array.
     */
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];

    /**
     * An immutable empty {@code Object} array.
     */
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    /**
     * Converts the given {@code int} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Integer> toList(@NotNull int[] array){
        Condition.argNotNull("array", array);
        List<Integer> list = new ArrayList<>();
        for(int a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code boolean} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Boolean> toList(@NotNull boolean[] array){
        Condition.argNotNull("array", array);
        List<Boolean> list = new ArrayList<>();
        for(boolean a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code long} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Long> toList(@NotNull long[] array){
        Condition.argNotNull("array", array);
        List<Long> list = new ArrayList<>();
        for(long a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code byte} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Byte> toList(@NotNull byte[] array){
        Condition.argNotNull("array", array);
        List<Byte> list = new ArrayList<>();
        for(byte a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code short} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Short> toList(@NotNull short[] array){
        Condition.argNotNull("array", array);
        List<Short> list = new ArrayList<>();
        for(short a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code float} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Float> toList(@NotNull float[] array){
        Condition.argNotNull("array", array);
        List<Float> list = new ArrayList<>();
        for(float a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code double} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Double> toList(@NotNull double[] array){
        Condition.argNotNull("array", array);
        List<Double> list = new ArrayList<>();
        for(double a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code char} array into an array list.
     * @param array array
     * @return new list
     */
    public static List<Character> toList(@NotNull char[] array){
        Condition.argNotNull("array", array);
        List<Character> list = new ArrayList<>();
        for(char a : array) list.add(a);
        return list;
    }

    /**
     * Converts the given {@code Object} array into an array list.
     * @param array array
     * @param <T> element type
     * @return new list
     */
    public static <T> List<T> toList(@NotNull T[] array){
        Condition.argNotNull("array", array);
        return Arrays.asList(array);
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(int[] array, int elem){
        if(array == null) return false;
        for(int e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(boolean[] array, boolean elem){
        if(array == null) return false;
        for(boolean e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(long[] array, long elem){
        if(array == null) return false;
        for(long e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(byte[] array, byte elem){
        if(array == null) return false;
        for(byte e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(short[] array, short elem){
        if(array == null) return false;
        for(short e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(float[] array, float elem){
        if(array == null) return false;
        for(float e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(double[] array, double elem){
        if(array == null) return false;
        for(double e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @return result
     */
    public static boolean contains(char[] array, char elem){
        if(array == null) return false;
        for(char e : array){
            if(e == elem) return true;
        }
        return false;
    }

    /**
     * Checks if the given element exists in the array.
     * @param elem element
     * @param array array
     * @param <T> element type
     * @return result
     */
    public static <T> boolean contains(T[] array, T elem){
        if(array == null) return false;
        if(elem == null){
            for(T e : array) {
                if(e == null) return true;
            }
        } else {
            for(T e : array) {
                if(elem.equals(e)) return true;
            }
        }
        return false;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(int[] arr, int elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(boolean[] arr, boolean elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(!arr[mid]) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(long[] arr, long elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(byte[] arr, byte elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(short[] arr, short elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(float[] arr, float elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(double[] arr, double elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static int binarySearch(char[] arr, char elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            if(arr[mid] == elem) return mid;
            else if(arr[mid] < elem) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Searches for the index of an element in the given array.<br>
     * Only works with sorted arrays.
     * @param arr an array
     * @param elem the element to be searched for
     * @param <T> element type
     * @return the index of that element in the array (or <b>-1</b> if not found)
     */
    public static <T> int binarySearch(T[] arr, T elem){
        if(arr == null || arr.length == 0) return -1;
        var low = 0;
        var high = arr.length-1;
        while(low <= high){
            var mid = (low + high) >>> 1;
            var x = ObjectUtil.deepCompare(arr[mid], elem);
            if(x == 0) return mid;
            else if(x > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static int[] add(@NotNull int[] array, int elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static boolean[] add(@NotNull boolean[] array, boolean elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static long[] add(@NotNull long[] array, long elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static byte[] add(@NotNull byte[] array, byte elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static short[] add(@NotNull short[] array, short elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static float[] add(@NotNull float[] array, float elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static double[] add(@NotNull double[] array, double elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @return the new array which was added the given element
     */
    public static char[] add(@NotNull char[] array, char elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then adds the given element to the end of that array.
     * @param array current array
     * @param elem element
     * @param <T> element type
     * @return the new array which was added the given element
     */
    public static <T> T[] add(@NotNull T[] array, T elem){
        Condition.argNotNull("array", array);
        var na = Arrays.copyOf(array, array.length+1);
        na[array.length] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static int[] insert(@NotNull int[] array, int elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        int[] na = (int[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static boolean[] insert(@NotNull boolean[] array, boolean elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        boolean[] na = (boolean[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static long[] insert(@NotNull long[] array, long elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        long[] na = (long[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static byte[] insert(@NotNull byte[] array, byte elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        byte[] na = (byte[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static short[] insert(@NotNull short[] array, short elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        short[] na = (short[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static float[] insert(@NotNull float[] array, float elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        float[] na = (float[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static double[] insert(@NotNull double[] array, double elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        double[] na = (double[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @return the new array which was added the given element
     */
    public static char[] insert(@NotNull char[] array, char elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        char[] na = (char[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then inserts the specific element to the array at the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array current array
     * @param elem element
     * @param index index
     * @param <T> element type
     * @return the new array which was added the given element
     */
    public static <T> T[] insert(@NotNull T[] array, T elem, int index){
        Condition.argNotNull("array", array);
        index = Math.max(0, Math.min(array.length, index));
        T[] na = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length+1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index, na, index+1, array.length-index);
        na[index] = elem;
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static int[] remove(@NotNull int[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        int[] na = (int[]) Array.newInstance(int.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static boolean[] remove(@NotNull boolean[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        boolean[] na = (boolean[]) Array.newInstance(boolean.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static long[] remove(@NotNull long[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        long[] na = (long[]) Array.newInstance(long.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static byte[] remove(@NotNull byte[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        byte[] na = (byte[]) Array.newInstance(byte.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static short[] remove(@NotNull short[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        short[] na = (short[]) Array.newInstance(short.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static float[] remove(@NotNull float[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        float[] na = (float[]) Array.newInstance(float.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static double[] remove(@NotNull double[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        double[] na = (double[]) Array.newInstance(double.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @return the new array which was removed the given element
     */
    public static char[] remove(@NotNull char[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        char[] na = (char[]) Array.newInstance(char.class, array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Copies the entire given array, then removes the element at the given index out of that array.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.<br>
     * This method will skip if the array is empty.
     * @param array current array
     * @param index index
     * @param <T> element type
     * @return the new array which was removed the given element
     */
    public static <T> T[] remove(@NotNull T[] array, int index){
        Condition.argNotNull("array", array);
        if(array.length == 0) return array;
        index = Math.max(0, index);
        index = Math.min(array.length, index);
        T[] na = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length-1);
        System.arraycopy(array, 0, na, 0, index);
        System.arraycopy(array, index+1, na, index, array.length-index-1);
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static int[] concat(@NotNull @NotEmpty int[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(int[] a : arrays) length += (a == null ? 0 : a.length);
        int[] na = (int[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(int[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static boolean[] concat(@NotNull @NotEmpty boolean[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(boolean[] a : arrays) length += (a == null ? 0 : a.length);
        boolean[] na = (boolean[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(boolean[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static long[] concat(@NotNull @NotEmpty long[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(long[] a : arrays) length += (a == null ? 0 : a.length);
        long[] na = (long[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(long[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static byte[] concat(@NotNull @NotEmpty byte[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(byte[] a : arrays) length += (a == null ? 0 : a.length);
        byte[] na = (byte[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(byte[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static short[] concat(@NotNull @NotEmpty short[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(short[] a : arrays) length += (a == null ? 0 : a.length);
        short[] na = (short[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(short[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static float[] concat(@NotNull @NotEmpty float[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(float[] a : arrays) length += (a == null ? 0 : a.length);
        float[] na = (float[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(float[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static double[] concat(@NotNull @NotEmpty double[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(double[] a : arrays) length += (a == null ? 0 : a.length);
        double[] na = (double[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(double[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @return new array
     */
    public static char[] concat(@NotNull @NotEmpty char[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(char[] a : arrays) length += (a == null ? 0 : a.length);
        char[] na = (char[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(char[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Concatenates given arrays into a new one.<br>
     * There must be at least one array.<br>
     * If an array is null, it will be ignored.
     * @param arrays arrays
     * @param <T> element type
     * @return new array
     */
    public static <T> T[] concat(@NotNull @NotEmpty T[]... arrays){
        Condition.argNotEmpty("arrays", arrays);
        var length = 0;
        for(T[] a : arrays) length += (a == null ? 0 : a.length);
        T[] na = (T[]) Array.newInstance(arrays[0].getClass().getComponentType(), length);
        var current = 0;
        for(T[] a : arrays){
            if(a == null) continue;
            System.arraycopy(a, 0, na, current, a.length);
            current += a.length;
        }
        return na;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(int[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(boolean[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(long[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(byte[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(short[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(float[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(double[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     */
    public static void swap(char[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Swaps two elements at two given indexes.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param array array
     * @param first the index of the first element
     * @param second the index of the second element
     * @param <T> element type
     */
    public static <T> void swap(T[] array, int first, int second){
        if(array == null || array.length == 0) return;
        first = Math.max(0, Math.min(array.length, first));
        second = Math.max(0, Math.min(array.length, second));
        var temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(int[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(boolean[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(long[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(byte[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(short[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(float[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(double[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     */
    public static void reverse(char[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Reverses the order of elements in the given array.
     * @param array array
     * @param <T> element type
     */
    public static <T> void reverse(T[] array){
        if(array == null || array.length == 0) return;
        var left = 0;
        var right = array.length - 1;

        while(left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static int pickRandom(@NotNull @NotEmpty int[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static boolean pickRandom(@NotNull @NotEmpty boolean[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static long pickRandom(@NotNull @NotEmpty long[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static byte pickRandom(@NotNull @NotEmpty byte[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static short pickRandom(@NotNull @NotEmpty short[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static float pickRandom(@NotNull @NotEmpty float[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static double pickRandom(@NotNull @NotEmpty double[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @return a random element
     */
    public static char pickRandom(@NotNull @NotEmpty char[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Picks a random element from the given array.
     * @param array array
     * @param <T> element type
     * @return a random element
     */
    public static <T> T pickRandom(@NotNull @NotEmpty T[] array){
        Condition.argNotEmpty("array", array);
        return array[RandomUtil.randomInt(0, array.length-1)];
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(int[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(boolean[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(long[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(byte[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(short[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(float[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(double[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     */
    public static void shuffle(char[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Shuffles the order of elements in the given array.
     * @param array array
     * @param <T> element type
     */
    public static <T> void shuffle(T[] array){
        if(array == null || array.length == 0) return;
        for (var i = 0; i < array.length; i++) swap(array, i, RandomUtil.randomInt(0, array.length-1));
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static int[] uniquify(@NotNull @NotEmpty int[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static boolean[] uniquify(@NotNull @NotEmpty boolean[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static long[] uniquify(@NotNull @NotEmpty long[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static byte[] uniquify(@NotNull @NotEmpty byte[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static short[] uniquify(@NotNull @NotEmpty short[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static float[] uniquify(@NotNull @NotEmpty float[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static double[] uniquify(@NotNull @NotEmpty double[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @return array
     */
    public static char[] uniquify(@NotNull @NotEmpty char[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(array[i] == array[j]) array = remove(array, j);
            }
        }
        return array;
    }

    /**
     * Eliminates duplicate elements from the given array.
     * @param array array
     * @param <T> element type
     * @return array
     */
    public static <T> T[] uniquify(@NotNull @NotEmpty T[] array){
        Condition.argNotEmpty("array", array);
        for(var i = 0; i < array.length-1; i++){
            for(var j = i+1; j < array.length; j++){
                if(ObjectUtil.deepCompare(array[i], array[j]) == 0) array = remove(array, j);
            }
        }
        return array;
    }
}
