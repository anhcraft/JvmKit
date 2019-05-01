package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;

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
}
