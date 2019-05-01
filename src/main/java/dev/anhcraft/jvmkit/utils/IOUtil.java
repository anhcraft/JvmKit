package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class provides utility methods for IO stream manipulation.
 */
public class IOUtil {
    /**
     * Compares the data of two given input streams.
     * @param sourceA first input stream
     * @param sourceB second input stream
     * @return result (If the result is negative, it means the first stream has less data than the second.
     * If the result is positive, it means the first stream has more data than the second.
     * Otherwise, both of them have the same data)
     * @throws IOException if I/O errors occur
     */
    public static int compare(@NotNull InputStream sourceA, @NotNull InputStream sourceB) throws IOException {
        Condition.argNotNull("sourceA", sourceA);
        Condition.argNotNull("sourceB", sourceB);
        int byteA, byteB;
        do {
            byteA = sourceA.read();
            byteB = sourceB.read();
            if(byteA != byteB) return byteA - byteB;
        } while(byteA != -1);
        return 0;
    }
}
