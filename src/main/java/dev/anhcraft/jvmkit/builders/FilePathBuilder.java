package dev.anhcraft.jvmkit.builders;

import dev.anhcraft.jvmkit.utils.Condition;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * This class gives an easier way to create file paths from defined parent directories.
 */
public class FilePathBuilder implements Builder<String> {
    private AtomicBoolean locked = new AtomicBoolean();
    private StringBuilder path;

    /**
     * Constructs an instance of {@code FilePathBuilder}.<br>
     * The parent directory is set to the current working one.
     */
    public FilePathBuilder() {
        path = new StringBuilder(".").append(File.separator);
    }

    /**
     * Constructs an instance of {@code FilePathBuilder} with the given parent directory.
     * @param parentDir parent dir
     */
    public FilePathBuilder(@NotNull File parentDir){
        Condition.argNotNull("parentDir", parentDir);
        Condition.check(parentDir.isDirectory(), "given file object must represent a directory");
        try {
            path = new StringBuilder(parentDir.getCanonicalPath()).append(File.separator);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Appends sequence of children directories to the end of the path.
     * @param names list of directories
     * @return this object
     */
    public FilePathBuilder dir(String... names){
        if(names != null && !locked.get()) {
            for(var n : names) {
                if(n != null) path.append(n).append(File.separatorChar);
            }
        }
        return this;
    }

    /**
     * Appends the file name to the end of the path.<br>
     * Calling this method also announce that the path is finished. You can no longer call this method or {@link #dir(String...)} anymore.
     * @param name file name
     * @return this object
     */
    public FilePathBuilder file(String name){
        if(name != null && locked.compareAndSet(false, true)) path.append(name);
        return this;
    }

    /**
     * Builds the path and returns it.
     * @return path
     */
    @Override
    public String build() {
        return path.toString();
    }
}
