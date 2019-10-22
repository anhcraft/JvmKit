package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.io.*;

/**
 * This class provides utility methods for serialization and deserialization.
 */
public class SerializationUtil {
    /**
     * Serializes the given object to a byte array.
     * @param object object
     * @return an array of bytes which represents that object
     */
    @Contract("null -> null")
    public static byte[] serialize(@Nullable Object object) {
        if(object == null) return null;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try {
            ObjectOutputStream os = new ObjectOutputStream(b);
            os.writeObject(object);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b.toByteArray();
    }

    /**
     * Deserializes the byte array into an object.
     * @param bytes an array of bytes which represents the object
     * @return the object
     */
    @Contract("null -> null")
    public static Object deserialize(@Nullable byte[] bytes) {
        if (bytes == null) return null;
        try {
            ObjectInputStream is = new ObjectInputStream(new ByteArrayInputStream(bytes));
            return is.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
