package dev.anhcraft.jvmkit.lang.enumeration;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.regex.Pattern;

/**
 * A collection of useful regular expressions.
 */
public enum RegEx {
    URI("^([0-9a-zA-Z]([0-9a-zA-Z.+-])+):\\/{2}((.*@)|)([0-9a-zA-Z].([0-9a-zA-Z.-]+)|[0-9a-zA-Z:]+)(|:\\d+)(\\/(.*)|\\?(.*)|\\#(.*)|)$"),
    EMAIL("^.{1,}@([0-9a-zA-Z].([0-9a-zA-Z.-]+)|[0-9a-zA-Z:]+)$"),
    DECIMAL("(^(-|\\+|)\\d+$)|(^(-|\\+|)\\d+\\.\\d+$)"),
    POSITIVE_DECIMAL("(^(\\+|)\\d+$)|(^(\\+|)\\d+\\.\\d+$)"),
    NEGATIVE_DECIMAL("(^-\\d+$)|(^-\\d+\\.\\d+$)"),
    INTEGER("^(-|\\+|)\\d+$"),
    POSITIVE_INTEGER("^(\\+|)\\d+$"),
    NEGATIVE_INTEGER("^-\\d+$"),
    UUID("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$"),
    IP_V4("^((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$"),
    IP_V6("^(([0-9a-fA-F]{1,4}:){7,7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]{1,}|::(ffff(:0{1,4}){0,1}:){0,1}((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9])\\.){3,3}(25[0-5]|(2[0-4]|1{0,1}[0-9]){0,1}[0-9]))$");

    private String regex;
    private Pattern pattern;

    RegEx(String regex){
        this.regex = regex;
        pattern = Pattern.compile(regex);
    }

    /**
     * Returns this expression.
     * @return expression
     */
    @NotNull
    public String getExpression(){
        return this.regex;
    }

    /**
     * Validates whether the given string matches this expression.
     * @param str a string
     * @return {@code true} if matched or {@code false} if not
     */
    public boolean valid(@Nullable String str){
        if(str == null) return false;
        return pattern.matcher(str).matches();
    }
}
