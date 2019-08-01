package dev.anhcraft.jvmkit.utils;

import java.security.SecureRandom;

/**
 * A utility class for interacting with {@link java.util.Random}.
 */
public class RandomUtil {
    private static final SecureRandom RANDOMIZER = new SecureRandom();

    /**
     * Generates a random {@code integer} between two given numbers.
     * @param min minimum number
     * @param max maximum number
     * @return random number
     */
    public static int randomInt(int min, int max){
        Condition.argLower("min", "max", min, max);
        return min + RANDOMIZER.nextInt(max-min+1);
    }

    /**
     * Generates a random {@code double} between two given numbers.
     * @param min minimum number
     * @param max maximum number
     * @return random number
     */
    public static double randomDouble(double min, double max){
        Condition.argLower("min", "max", min, max);
        return min + RANDOMIZER.nextDouble() * (max-min);
    }

    /**
     * Generates a random {@code float} between two given numbers.
     * @param min minimum number
     * @param max maximum number
     * @return random number
     */
    public static float randomFloat(float min, float max){
        Condition.argLower("min", "max", min, max);
        return min + RANDOMIZER.nextFloat() * (max-min);
    }

    /**
     * Generates an array of letters.
     * @param length array's length
     * @return {@code char} array
     */
    public static char[] randomLetters(int length){
        Condition.check(length >= 0, "'length' must not be negative");
        char[] chars = new char[length];
        for(char i = 0; i < length; i++) chars[i] = ArrayUtil.pickRandom(CharUtil.LETTERS);
        return chars;
    }

    /**
     * Generates an array of digits.
     * @param length array's length
     * @return {@code char} array
     */
    public static char[] randomDigits(int length){
        Condition.check(length >= 0, "'length' must not be negative");
        char[] chars = new char[length];
        for(char i = 0; i < length; i++) chars[i] = ArrayUtil.pickRandom(CharUtil.DIGITS);
        return chars;
    }
}
