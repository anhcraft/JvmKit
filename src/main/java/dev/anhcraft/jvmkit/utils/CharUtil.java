package dev.anhcraft.jvmkit.utils;

/**
 * Utility methods which is related to {@link Character}.
 */
public class CharUtil {
    /**
     * An array of letters (A-Za-z).
     */
    public static final char[] LETTERS = new char[52];
    /**
     * An array of uppercase letters (A-Z).
     */
    public static final char[] UPPERCASE_LETTERS = new char[26];
    /**
     * An array of lowercase letters (a-z).
     */
    public static final char[] LOWERCASE_LETTERS = new char[26];
    /**
     * An array of digits (0-9).
     */
    public static final char[] DIGITS = new char[10];

    static {
        for(int i = 0; i < 26; i++) UPPERCASE_LETTERS[i] = (char) (i+65);
        for(int i = 0; i < 26; i++) LOWERCASE_LETTERS[i] = (char) (i+97);
        for(int i = 0; i < 10; i++) DIGITS[i] = (char) (i+48);
        System.arraycopy(UPPERCASE_LETTERS, 0, LETTERS, 0, 26);
        System.arraycopy(LOWERCASE_LETTERS, 0, LETTERS, 26, 26);
    }
}
