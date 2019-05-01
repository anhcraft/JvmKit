package dev.anhcraft.jvmkit.lang;

/**
 * This exception throws when an object is not as same as expected.
 */
public class IllegalValueException extends Exception {
    private static final long serialVersionUID = 5124722079094584396L;

    /**
     * Constructs an instance of {@code IllegalValueException} with the given detail message.
     * @param message detail message
     */
    public IllegalValueException(String message) {
        super(message);
    }
}
