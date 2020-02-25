package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class JarUtil {
    private static Method addUrlMethod;

    static {
        try {
            addUrlMethod = URLClassLoader.class.getDeclaredMethod("addURL", URL.class);
            addUrlMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads the given jar to the class loader.
     * @param jarFile the .jar file
     * @param loader class loader
     * @throws IOException if failed
     * @throws InvocationTargetException if failed
     * @throws IllegalAccessException if failed
     */
    public static void loadJar(@NotNull File jarFile, @NotNull URLClassLoader loader) throws IOException, InvocationTargetException, IllegalAccessException {
        Condition.argNotNull("jarFile", jarFile);
        Condition.argNotNull("loader", loader);
        addUrlMethod.invoke(loader, jarFile.toURI().toURL());
    }
}
