package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.enumeration.ComparisonOption;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Test1 {
    private static final Integer[] ARRAY_1 = new Integer[]{2, 5, 8, 9};
    private static final Integer[] ARRAY_2 = new Integer[]{6, 4, 0, 2, 7};

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
        Assert.assertFalse(ArrayUtil.contains(ARRAY_2, 1));
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
        Integer[] array = new Integer[]{3, 0, -4, -7, 6, -2};
        ArrayUtil.swap(array, 0, 3);
        Assert.assertArrayEquals(new Integer[]{-7, 0, -4, 3, 6, -2}, array);
        ArrayUtil.reverse(array);
        Assert.assertArrayEquals(new Integer[]{-2, 6, 3, -4, 0, -7}, array);
        array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50};
        ArrayUtil.shuffle(array);
        Assert.assertArrayEquals(new Integer[]{0, 2, 4, 1, 3, 8, 6, 5}, ArrayUtil.uniquify(new Integer[]{0, 2, 4, 1, 2, 0, 3, 0, 8, 6, 4, 5, 2, 3, 0, 6}));
        Assert.assertEquals(9, (int) ArrayUtil.last(ARRAY_1));
        Assert.assertEquals(8, (int) ArrayUtil.mid(ARRAY_1));
        Assert.assertEquals(0, (int) ArrayUtil.mid(ARRAY_2));
    }

    @Test
    public void collectionUtil(){
        Assert.assertArrayEquals(CollectionUtil.toArray(new ArrayList<>(), byte.class), new Byte[0]);
    }

    @Test
    public void IOUtil(){
        try {
            FileInputStream in1 = new FileInputStream("JvmKit.iml");
            FileInputStream in2 = new FileInputStream("pom.xml");
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

    @Test
    public void fileUtil(){
        File f1 = new File("./src/test/resources/hello world.txt");
        File f2 = new File("./src/test/resources/temp.hello world.txt");
        File f3 = new File("./src/test/resources/temp.hello world.dat");
        try {
            Assert.assertEquals("hello world", FileUtil.readText(f1));
            try {
                f2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Assert.assertTrue(FileUtil.copy(f1, f2));
            Assert.assertEquals("hello world", FileUtil.readText(f2));
            FileUtil.clean(f2);
            Assert.assertTrue(FileUtil.readText(f2).isEmpty());

            BufferedInputStream if1 = new BufferedInputStream(new FileInputStream(f1));
            FileUtil.append(f2, if1);
            if1.close();
            if1 = new BufferedInputStream(new FileInputStream(f1));
            FileUtil.append(f2, if1);
            if1.close();
            String tf1 = FileUtil.readText(f1);
            Assert.assertEquals(tf1+tf1, FileUtil.readText(f2));

            FileUtil.compress(f1, f1);
            FileUtil.decompress(f1, f1);
            Assert.assertEquals(tf1, FileUtil.readText(f1));
            f2.delete();
            f3.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void stringUtil(){
        Assert.assertEquals("TheQuickBrownFoxJumpsOverTheLazyDog",
                StringUtil.toUpperCamelCase("The _quick brown fox j-um-ps over the lazy dog"));
        Assert.assertEquals("TheQuickBrOwnFoxJumpsOverTheLazyDog",
                StringUtil.toUpperCamelCase("ThE Quick _brOwN F$ox jUmps, oveR tHe lAzy dOg"));
        Assert.assertEquals("TheQuIckBrOwnFoxJumpsOverTheLaZyDog",
                StringUtil.toUpperCamelCase("T!he quI!ck_BrOwN foxJ!umps overThe laZyDog."));
        Assert.assertEquals("theQuickBrownFoxJumpsOverTheLazyDog",
                StringUtil.toLowerCamelCase("The _quick brown fox j-um-ps over the lazy dog"));
        Assert.assertEquals("theQuickBrOwnFoxJumpsOverTheLazyDog",
                StringUtil.toLowerCamelCase("ThE Quick _brOwN F$ox jUmps, oveR tHe lAzy dOg"));
        Assert.assertEquals("theQuIckBrOwnFoxJumpsOverTheLaZyDog",
                StringUtil.toLowerCamelCase("T!he quI!ck_BrOwN foxJ!umps overThe laZyDog."));
        Assert.assertEquals("2__driven__jocks_help_f_ax_my_big_q_u_iz",
                StringUtil.toSnakeCase("2 _driven _jocks help f_ax my big q_u_iz."));
        Assert.assertEquals("2__driven__jocks_he___lp_f_ax_my_big_q_u_iz",
                StringUtil.toSnakeCase("2. -_dr.ivEn _-Jo-Cks. he.___lp f_.Ax m.y b.-ig q_u_i-z."));
        Assert.assertEquals("TW0__DRIVEN_JOCKS_HE1P_FAX_MY_BIG_QUIZ",
                StringUtil.toScreamSnakeCase("T.w*.0_ dr.i-v$e.n joc-ks h@e.1p f.ax& my. b.i-#g quiz"));
        Assert.assertEquals("dlrow olleh", StringUtil.reverse("hello world"));
        Assert.assertEquals("he wrd", StringUtil.removeDigits("he110 w0r1d"));
        Assert.assertEquals("110 01", StringUtil.removeLetters("he110 w0r1d"));
    }

    @Test
    public void mathUtil(){
        Assert.assertEquals(1.0, MathUtil.round(0.987, 0), 0);
        Assert.assertEquals(1.0, MathUtil.round(0.987, 1), 0);
        Assert.assertEquals(0.99, MathUtil.round(0.987, 2), 0);
        Assert.assertEquals(0.12346, MathUtil.round(0.123456789, 5), 0);
        Assert.assertTrue(MathUtil.isPrime(2));
        Assert.assertTrue(MathUtil.isPrime(3));
        Assert.assertTrue(MathUtil.isPrime(5));
        Assert.assertTrue(MathUtil.isPrime(7));
        Assert.assertTrue(MathUtil.isPrime(11));
        Assert.assertTrue(MathUtil.isPrime(13));
        Assert.assertFalse(MathUtil.isPrime(4));
        Assert.assertFalse(MathUtil.isPrime(6));
    }

    @Test
    public void timedCollection(){
        TimedList<Integer> list = new TimedList<>();
        list.add(0, 1500);
        Assert.assertTrue(list.contains(0));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(list.contains(0));

        list.add(1, 1500);
        list.removeAt(0);
        Assert.assertFalse(list.contains(1));

        list.add(1, 1500);
        list.add(1, 1500);
        list.add(1, 1500);
        list.removeAll(1);
        Assert.assertFalse(list.contains(1));

        list.add(2, 300);
        Assert.assertEquals(2, list.get(0).intValue());
        Assert.assertEquals(2, list.stream().findFirst().orElse(0).intValue());

        TimedMap<String, Integer> map = new TimedMap<>();
        map.put("a", 1, 200);
        Assert.assertTrue(map.containsKey("a"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertFalse(map.containsValue(1));
    }

    @Test
    public void charUtil(){
        //System.out.println(CharUtil.DIGITS);
    }
}
