package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.enumeration.ComparisonOption;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test1 {
    private static final Integer[] ARRAY_1 = new Integer[]{2, 5, 8, 9};
    private static final Integer[] ARRAY_2 = new Integer[]{6, 4, 5, 2, 7};

    private static class TestClass{
        public static int num = 3;
    }

    @Test
    public void arrayUtil(){
        Assert.assertEquals(ArrayUtil.toList(ArrayUtil.EMPTY_BYTE_ARRAY), new ArrayList<Byte>());
        Assert.assertEquals(1, ArrayUtil.binarySearch(ARRAY_1, 5));
        Assert.assertEquals(-1, ArrayUtil.binarySearch(ARRAY_1, 3));
        Assert.assertTrue(ArrayUtil.contains(ARRAY_1, 8));
        Assert.assertTrue(ArrayUtil.contains(ARRAY_2, 2));
        Assert.assertFalse(ArrayUtil.contains(ARRAY_2, 0));
        Assert.assertArrayEquals(new int[]{2, 4}, ArrayUtil.add(new int[]{2}, 4));
        Assert.assertArrayEquals(new Integer[]{4, 8, 3}, ArrayUtil.insert(new Integer[]{8, 3}, 4, 0));
        Assert.assertArrayEquals(new int[]{7, -2, -5}, ArrayUtil.insert(new int[]{7, -5}, -2, 1));
        Assert.assertArrayEquals(new Integer[]{2, -1}, ArrayUtil.remove(new Integer[]{8, 2, -1}, -999));
        Assert.assertArrayEquals(new Integer[]{8, -1}, ArrayUtil.remove(new Integer[]{8, 2, -1}, 1));
        Assert.assertArrayEquals(new Integer[]{8, 2}, ArrayUtil.remove(new Integer[]{8, 2, -1}, 2));
        Assert.assertArrayEquals(ArrayUtil.EMPTY_BYTE_ARRAY, ArrayUtil.remove(ArrayUtil.EMPTY_BYTE_ARRAY, 0));
        Assert.assertArrayEquals(new Integer[]{-1, -3, 9, 5, 0, -4, 7, 2}, ArrayUtil.concat(
                new Integer[]{-1},
                new Integer[]{-3, 9},
                new Integer[]{5, 0, -4},
                new Integer[]{7, 2}
        ));
        var array = new Integer[]{3, 0, -4, -7, 6, -2};
        ArrayUtil.swap(array, 0, 3);
        Assert.assertArrayEquals(new Integer[]{-7, 0, -4, 3, 6, -2}, array);
        ArrayUtil.reverse(array);
        Assert.assertArrayEquals(new Integer[]{-2, 6, 3, -4, 0, -7}, array);
        array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
        ArrayUtil.shuffle(array);
        Assert.assertArrayEquals(new Integer[]{0, 2, 4, 1, 3, 8, 6, 5}, ArrayUtil.uniquify(new Integer[]{0, 2, 4, 1, 2, 0, 3, 0, 8, 6, 4, 5, 2, 3, 0, 6}));
    }

    @Test
    public void collectionUtil(){
        Assert.assertArrayEquals(CollectionUtil.toArray(new ArrayList<>(), byte.class), new Byte[]{});
    }

    @Test
    public void IOUtil(){
        try {
            var in1 = new FileInputStream("JvmKit.iml");
            var in2 = new FileInputStream("pom.xml");
            Assert.assertNotEquals(0, IOUtil.compare(in1, in2));
            in1.close();
            in2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void objectUtil(){
        Assert.assertEquals(0, ObjectUtil.deepCompare(true, true));
        Assert.assertEquals(0, ObjectUtil.deepCompare(3, 3));
        Assert.assertEquals(0, ObjectUtil.deepCompare(5.7, 5.7));
        Assert.assertNotEquals(0, ObjectUtil.deepCompare(5, 5.7));
        Assert.assertEquals(0, ObjectUtil.deepCompare(5, 5.7, ComparisonOption.IGNORE_DECIMAL));
        Assert.assertEquals(0, ObjectUtil.deepCompare("abc", "abc"));
        Assert.assertNotEquals(0, ObjectUtil.deepCompare("ABC", "abc"));
        Assert.assertEquals(0, ObjectUtil.deepCompare("ABC", "abc", ComparisonOption.CASE_INSENSITIVE));
        Assert.assertEquals(0, ObjectUtil.deepCompare(ARRAY_1, ARRAY_1));
        Assert.assertNotEquals(0, ObjectUtil.deepCompare(ARRAY_1, ARRAY_2));
        Assert.assertEquals(0, ObjectUtil.deepCompare("abc", "abc"));
        Assert.assertTrue(ObjectUtil.deepCompare(2, 6) < 0);
        Assert.assertTrue(ObjectUtil.deepCompare("XYZ", "xyz") < 0);
        Assert.assertTrue(ObjectUtil.deepCompare(ARRAY_1, ARRAY_2) < 0);
    }

    @Test
    public void reflectionUtil(){
        ReflectionUtil.setStaticField(TestClass.class, "num", 5);
        Assert.assertSame(5, TestClass.num);
    }
}
