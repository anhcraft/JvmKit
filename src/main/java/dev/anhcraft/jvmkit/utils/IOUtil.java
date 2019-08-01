package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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

    /**
     * Converts the given input stream into a {@code byte} array.
     * @param stream input stream
     * @param buff buffer size
     * @return an array of bytes
     * @throws IOException if I/O errors occur
     */
    public static byte[] toByteArray(@NotNull InputStream stream, int buff) throws IOException {
        Condition.argNotNull("stream", stream);
        byte[] data = new byte[buff];
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        int n;
        while((n = stream.read(data, 0, buff)) != -1) buffer.write(data, 0, n);
        return buffer.toByteArray();
    }

    /**
     * Transfers all data from the given input to the output
     * @param in input stream
     * @param out output stream
     * @param buff buffer size
     * @throws IOException if I/O errors occur
     */
    public static void transfer(@NotNull InputStream in, @NotNull OutputStream out, int buff) throws IOException {
        Condition.argNotNull("in", in);
        Condition.argNotNull("out", out);
        byte[] data = new byte[buff];
        int n;
        while((n = in.read(data, 0, buff)) != -1) out.write(data, 0, n);
    }
}
