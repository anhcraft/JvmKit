package dev.anhcraft.jvmkit.utils;

import java.text.DecimalFormat;

public class MathUtil {
    private static final DecimalFormat format = new DecimalFormat();

    static {
        format.setGroupingUsed(false);
        format.setMaximumFractionDigits(2);
    }

    /**
     * Rounds up the given a number.
     * @param number the number
     * @return rounded number as string
     */
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
}
