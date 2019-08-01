package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

/**
 * This class provides utility methods for {@link String} manipulation.
 */
public class StringUtil {
    /**
     * Escapes the given string.
     * @param str a string
     * @return escaped string
     */
    public static String escape(@NotNull String str){
        Condition.argNotNull("str", str);
        return str.replace("\\", "\\\\").replace("'", "\\'").replace("\0", "\\0").replace("\n", "\\n").replace("\r", "\\r").replace("\"", "\\\"").replace("\\x1a", "\\Z");
    }

    /**
     * Unescapes a string.
     * @param str a string
     * @return unescaped string
     */
    public static String unescape(@NotNull String str){
        Condition.argNotNull("str", str);
        return str.replace("\\\\\\", "\\").replace("\\'", "'").replace("\\0", "\0").replace("\\n", "\n").replace("\\r", "\r").replace("\\\"", "\"").replace("\\Z", "\\xla");
    }

    private static String toCamelCase(String str, boolean lower){
        Condition.argNotNull("str", str);

        StringBuilder builder = new StringBuilder();
        // split the sentence into words
        String[] words = str.split(" ");
        for(int w = 0; w < words.length; w++) {
            String word = words[w];
            if (word.isEmpty()) continue; // ignore the word if it is empty

            StringBuilder word_builder = new StringBuilder(word);
            int i = 0;
            while (i < word_builder.length()) {
                // remove any characters except letters
                if (!Character.isLetter(word_builder.charAt(i))) word_builder.deleteCharAt(i);
                else i++;
            }
            word_builder.setCharAt(0, w == 0 && lower ? Character.toLowerCase(word_builder.charAt(0)) : Character.toUpperCase(word_builder.charAt(0)));

            // continue to handle if this word has more than one character
            if (word_builder.length() > 1) {
                // lowercase the last character in this word
                word_builder.setCharAt(word_builder.length() - 1,
                        Character.toLowerCase(word_builder.charAt(word_builder.length() - 1)));

                int j = 0;
                while (j < word_builder.length() - 1) {
                    // if there are two capitalised letter next to each other, we will remove the first
                    if (Character.isUpperCase(word_builder.charAt(j)) &&
                            Character.isUpperCase(word_builder.charAt(j + 1))) {
                        word_builder.setCharAt(j + 1, Character.toLowerCase(word_builder.charAt(j + 1)));
                        // continue to the next two characters
                        j += 2;
                    } else j++;
                }
            }
            builder.append(word_builder);
        }
        return builder.toString();
    }

    /**
     * Convert the string to lower camel case (or Pascal case).
     * @param str a string
     * @return the string which was converted
     */
    public static String toUpperCamelCase(@NotNull String str){
        return toCamelCase(str, false);
    }

    /**
     * Convert the string to upper camel case.
     * @param str a string
     * @return the string which was converted
     */
    public static String toLowerCamelCase(@NotNull String str){
        return toCamelCase(str, true);
    }

    private static String toSnakeCase(String str, boolean scream){
        Condition.argNotNull("str", str);

        // split the sentence into words
        String[] words = str.split(" ");
        for(int w = 0; w < words.length; w++) {
            String word = words[w];
            if (word.isEmpty()) continue; // ignore the word if it is empty

            StringBuilder word_builder = new StringBuilder(word);
            int i = 0;
            while (i < word_builder.length()) {
                char c = word_builder.charAt(i);
                if (c == '_' || Character.isDigit(c)) i++;
                else if(Character.isWhitespace(c)) {
                    word_builder.setCharAt(i, '_');
                    i++;
                } else if (Character.isLetter(c)) {
                    word_builder.setCharAt(i, scream ? Character.toUpperCase(c) : Character.toLowerCase(c));
                    i++;
                } else word_builder.deleteCharAt(i); // remove other characters
            }
            words[w] = word_builder.toString();
        }
        return String.join("_", words);
    }

    /**
     * Convert the string to screaming sneak case.
     * @param str a string
     * @return the string which was converted
     */
    public static String toScreamSnakeCase(@NotNull String str){
        return toSnakeCase(str, true);
    }

    /**
     * Convert the string to sneak case.
     * @param str a string
     * @return the string which was converted
     */
    public static String toSnakeCase(@NotNull String str){
        return toSnakeCase(str, false);
    }

    /**
     * Reverses the order of characters in the given string.
     * @param str a string
     * @return reversed string
     */
    public static String reverse(@NotNull String str){
        Condition.argNotNull("str", str);
        char[] chars = str.toCharArray();
        ArrayUtil.reverse(chars);
        return new String(chars);
    }

    /**
     * Removes all digits from the given string.
     * @param str a string
     * @return a string with no digits
     */
    public static String removeDigits(@NotNull String str) {
        Condition.argNotNull("str", str);
        return str.chars().filter(value -> !Character.isDigit(value)).collect(
                StringBuilder::new,
                (sb, i) -> sb.append((char)i),
                StringBuilder::append
        ).toString();
    }

    /**
     * Removes all letters from the given string.
     * @param str a string
     * @return a string with no letters
     */
    public static String removeLetters(@NotNull String str) {
        Condition.argNotNull("str", str);
        return str.chars().filter(value -> !Character.isLetter(value)).collect(
                StringBuilder::new,
                (sb, i) -> sb.append((char)i),
                StringBuilder::append
        ).toString();
    }
}
