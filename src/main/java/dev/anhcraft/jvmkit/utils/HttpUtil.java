package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.helpers.HTTPConnectionHelper;
import dev.anhcraft.jvmkit.utils.function.ByteArraySupplier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HttpUtil {
    @NotNull
    public static byte[] fetch(@NotNull String url) throws IOException {
        return fetch(url, null, UserAgent.CHROME_WINDOWS);
    }

    @NotNull
    public static byte[] fetch(@NotNull String url, @Nullable ByteArraySupplier output) throws IOException {
        return fetch(url, output, UserAgent.CHROME_WINDOWS);
    }

    @NotNull
    public static byte[] fetch(@NotNull String url, @Nullable String userAgent) throws IOException {
        return fetch(url, null, userAgent);
    }

    @NotNull
    public static byte[] fetch(@NotNull String url, @Nullable ByteArraySupplier output, @Nullable String userAgent) throws IOException {
        HTTPConnectionHelper helper = new HTTPConnectionHelper(url);
        if(userAgent != null) {
            helper.setProperty("User-Agent", userAgent);
        }
        if(output != null) {
            helper.doOutput();
        }
        helper.connect();
        if(output != null && helper.getOutput() != null) {
            helper.getOutput().write(output.get());
        }
        byte[] bytes = helper.read();
        if (output != null && helper.getOutput() != null) {
            helper.getOutput().close();
        }
        helper.getInput().close();
        helper.disconnect();
        return bytes;
    }

    @NotNull
    public static String fetchString(@NotNull String url) throws IOException {
        return new String(fetch(url), StandardCharsets.UTF_8);
    }

    @NotNull
    public static String fetchString(@NotNull String url, @Nullable ByteArraySupplier output) throws IOException {
        return new String(fetch(url, output), StandardCharsets.UTF_8);
    }

    @NotNull
    public static String fetchString(@NotNull String url, @Nullable String userAgent) throws IOException {
        return new String(fetch(url, userAgent), StandardCharsets.UTF_8);
    }

    @NotNull
    public static String fetchString(@NotNull String url, @Nullable ByteArraySupplier output, @Nullable String userAgent) throws IOException {
        return new String(fetch(url, output, userAgent), StandardCharsets.UTF_8);
    }
}
