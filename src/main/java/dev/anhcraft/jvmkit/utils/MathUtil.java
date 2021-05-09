package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MathUtil {
    private static final DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);

    static {
        format.setGroupingUsed(false);
        format.setMaximumFractionDigits(1);
    }

    /**
     * Rounds up the given a number.
     * @param number the number
     * @return rounded number as string
     */
    @NotNull
    public static String formatRound(double number){
        return format.format(number);
    }

    /**
     * Rounds up the given a number.
     * @param number the number
     * @return rounded number
     */
    public static double round(double number){
        return Double.parseDouble(format.format(number));
    }

    /**
     * Rounds up the given a number.
     * @param number the number
     * @param fractionDigits the maximum numbers of digits in the fraction part.
     * @return rounded number as string
     */
    @NotNull
    public static String formatRound(double number, int fractionDigits){
        format.setMaximumFractionDigits(fractionDigits);
        return format.format(number);
    }

    /**
     * Rounds up the given a number.
     * @param number the number
     * @param fractionDigits the maximum numbers of digits in the fraction part.
     * @return rounded number
     */
    public static double round(double number, int fractionDigits){
        if(Double.isInfinite(number) || Double.isNaN(number)) return number;
        format.setMaximumFractionDigits(fractionDigits);
        return Double.parseDouble(format.format(number));
    }

    /**
     * Checks if the given number is not a whole number (e.g: -0.2, 1.7, 2.4 but not 0.0, 2.0, 3.0)
     * @param number the number
     * @return {@code true} if it is not a whole number. Otherwise is {@code false}
     */
    public static boolean isFraction(double number){
        return number % 1 != 0;
    }

    /**
     * Checks if the given number is a prime.
     * @param num number
     * @return {@code true} if that number is a prime, or {@code false} if not.
     */
    public static boolean isPrime(long num){
        if(num < 2) return false;
        else if(num == 2 | num == 3) return true;
        else if(num % 2 == 0) return false;

        long i = 3;
        long m = num/2+1;
        while(i < m){
            if(num % i == 0) return false;
            i += 2;
        }
        return true;
    }

    /**
     * Rounds the given number up to the next multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the next multiple
     */
    public static double nextMultiple(double num, double multiplier){
        if(num % multiplier != 0) num += multiplier - num % multiplier;
        return num;
    }

    /**
     * Rounds the given number to the previous multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the previous multiple
     */
    public static double prevMultiple(double num, double multiplier){
        if(num % multiplier != 0) num -= num % multiplier;
        return num;
    }

    /**
     * Rounds the given number up to the next multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the next multiple
     */
    public static float nextMultiple(float num, float multiplier){
        if(num % multiplier != 0) num += multiplier - num % multiplier;
        return num;
    }

    /**
     * Rounds the given number to the previous multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the previous multiple
     */
    public static float prevMultiple(float num, float multiplier){
        if(num % multiplier != 0) num -= num % multiplier;
        return num;
    }

    /**
     * Rounds the given number up to the next multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the next multiple
     */
    public static int nextMultiple(int num, int multiplier){
        if(num % multiplier != 0) num += multiplier - num % multiplier;
        return num;
    }

    /**
     * Rounds the given number to the previous multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the previous multiple
     */
    public static int prevMultiple(int num, int multiplier){
        if(num % multiplier != 0) num -= num % multiplier;
        return num;
    }

    /**
     * Rounds the given number up to the next multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the next multiple
     */
    public static long nextMultiple(long num, long multiplier){
        if(num % multiplier != 0) num += multiplier - num % multiplier;
        return num;
    }

    /**
     * Rounds the given number to the previous multiple.
     * @param num the number
     * @param multiplier the multiplier
     * @return the previous multiple
     */
    public static long prevMultiple(long num, long multiplier){
        if(num % multiplier != 0) num -= num % multiplier;
        return num;
    }

    /**
     * Clamps the given number to make it stay between the minimum and maximum.
     * @param value the value
     * @param min the minimum
     * @param max the maximum
     * @return the new value
     */
    public static int clampInt(int value, int min, int max){
        if(value < min) return min;
        else if(value > max) return max;
        else return value;
    }

    /**
     * Clamps the given number to make it stay between the minimum and maximum.
     * @param value the value
     * @param min the minimum
     * @param max the maximum
     * @return the new value
     */
    public static double clampDouble(double value, double min, double max){
        if(value < min) return min;
        else if(value > max) return max;
        else return value;
    }

    /**
     * Clamps the given number to make it stay between the minimum and maximum.
     * @param value the value
     * @param min the minimum
     * @param max the maximum
     * @return the new value
     */
    public static long clampLong(long value, long min, long max){
        if(value < min) return min;
        else if(value > max) return max;
        else return value;
    }

    /**
     * Clamps the given number to make it stay between the minimum and maximum.
     * @param value the value
     * @param min the minimum
     * @param max the maximum
     * @return the new value
     */
    public static float clampFloat(float value, float min, float max){
        if(value < min) return min;
        else if(value > max) return max;
        else return value;
    }

    /**
     * Converts the given number in {@link Float} to {@link Integer}.
     * @param v float
     * @return integer
     */
    public static int toInt(float v){
        if(v >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(v <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int i = (int) v;
        return (v - i) <= 0.5 ? i : i + 1;
    }

    /**
     * Converts the given number in {@link Double} to {@link Integer}.
     * @param v float
     * @return integer
     */
    public static int toInt(double v){
        if(v >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(v <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        int i = (int) v;
        return (v - i) <= 0.5 ? i : i + 1;
    }
}
