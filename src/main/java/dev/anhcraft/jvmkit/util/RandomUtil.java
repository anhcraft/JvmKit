package dev.anhcraft.jvmkit.util;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

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
}
