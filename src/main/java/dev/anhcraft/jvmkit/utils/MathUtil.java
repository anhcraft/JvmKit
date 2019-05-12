package dev.anhcraft.jvmkit.utils;

import java.text.DecimalFormat;

public class MathUtil {
    private static final DecimalFormat format = new DecimalFormat();

    static {
        format.setGroupingUsed(false);
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
    public static boolean isPrime(int num){
        if(num < 2) return false;
        else if(num == 2 | num == 3) return true;
        else if(num % 2 == 0) return false;

        var i = 3;
        var m = num/2+1;
        while(i < m){
            if(num % i == 0) return false;
            i += 2;
        }
        return true;
    }
}
