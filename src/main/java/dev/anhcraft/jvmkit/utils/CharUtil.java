package dev.anhcraft.jvmkit.utils;

/**
 * Utility methods which is related to {@link Character}.
 */
public class CharUtil {
    /**
     * An array of alphabet characters (A-Za-z).
     */
    public static final char[] ALPHA_CHARS = new char[52];
    /**
     * An array of uppercase alphabet characters (A-Z).
     */
    public static final char[] UPPERCASE_ALPHA_CHARS = new char[26];
    /**
     * An array of lowercase alphabet characters (a-z).
     */
    public static final char[] LOWERCASE_ALPHA_CHARS = new char[26];
    /**
     * An array of digits characters (0-9).
     */
    public static final char[] DIGIT_CHARS = new char[10];

    static {
        for(int i = 0; i < 26; i++) UPPERCASE_ALPHA_CHARS[i] = (char) (i+65);
        for(int i = 0; i < 26; i++) LOWERCASE_ALPHA_CHARS[i] = (char) (i+97);
        for(int i = 0; i < 10; i++) DIGIT_CHARS[i] = (char) (i+48);
        System.arraycopy(UPPERCASE_ALPHA_CHARS, 0, ALPHA_CHARS, 0, 26);
        System.arraycopy(LOWERCASE_ALPHA_CHARS, 0, ALPHA_CHARS, 26, 26);
    }
}
