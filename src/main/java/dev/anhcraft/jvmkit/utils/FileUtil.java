package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * A utility class which contains useful methods to interact with the file system safely.
 */
public class FileUtil {
    /**
     * This method will copy:
     * <ul>
     *     <li>the content of a file to another file</li>
     *     <li>a file to another directory</li>
     *     <li>the whole directory to another</li>
     * </ul>
     * However, this method can't copy a directory to a file.
     * @param source source file/directory
     * @param target target file/directory
     * @return {@code true} if the action was done. Otherwise is {@code false}.
     */
    public static boolean copy(@NotNull File source, @NotNull File target){
        Condition.argNotNull("source", source);
        Condition.argNotNull("target", target);
        Condition.check(source.exists(), "The source must be existed: "+source.getPath());
        Condition.check(target.exists(), "The target must be existed: "+target.getPath());
        if(source.isDirectory()){
            if(target.isDirectory()){
                var child = source.listFiles();
                if(child == null) return false;
                try {
                    for(File f : child) {
                        if(f.equals(target)) continue; // the target can't be a sub-folder of the source

                        var t = new File(target, f.getName());
                        if (f.isDirectory()) t.mkdir(); else t.createNewFile();
                        if (!copy(f, t)) return false;
                    }
                } catch(IOException e) {
                    e.printStackTrace();
                    return false;
                }
                return true;
            } else return false;
        } else {
            if(target.isDirectory()) target = new File(target, source.getName());
            try {
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(source));
                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(target));
                input.transferTo(output);
                input.close();
                output.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    /**
     * Cleans a directory or the content of a file without deleting it.
     * @param file file
     * @return {@code true} if the file/directory was cleaned successfully. Otherwise is {@code false}.
     */
    public static boolean clean(@NotNull File file){
        Condition.argNotNull("file", file);
        if(!file.exists()) return false;
        if(file.isDirectory()) {
            var child = file.listFiles();
            if(child == null) return false;
            for(File f : child){
                if(f.isDirectory()) clean(f);
                if(!f.delete()) return false;
            }
        } else{
            try {
                var f = new RandomAccessFile(file, "rwd");
                f.setLength(0);
                f.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    /**
     * Initializes a file for the first time with the data from the given input stream.<br>
     * If the file is already existed, this method won't work.
     * @param file file
     * @param stream input stream
     * @return {@code true} if the file was initialized. Otherwise is {@code false}.
     */
    public static boolean init(@NotNull File file, @NotNull InputStream stream){
        Condition.argNotNull("file", file);
        Condition.argNotNull("stream", stream);
        try {
            if(!file.createNewFile()) return false;
            write(file, stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Initializes a file for the first time with the given data.<br>
     * If the file is already existed, this method won't work.
     * @param file file
     * @param data data
     * @return {@code true} if the file was initialized. Otherwise is {@code false}.
     */
    public static boolean init(@NotNull File file, @NotNull byte[] data){
        Condition.argNotNull("file", file);
        Condition.argNotNull("data", data);
        try {
            if(!file.createNewFile()) return false;
            write(file, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Initializes a file for the first time with the given content.
     * @param file file
     * @param content content
     * @return {@code true} if the file was initialized. Otherwise is {@code false}.
     * @see #init(File, byte[])
     */
    public static boolean init(@NotNull File file, @NotNull String content){
        return init(file, content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Overrides the current data of a file with the data from the given input stream.<br>
     * This method will create the file automatically if it wasn't existed yet.<br>
     * This method won't work if the {@code File} object represents a directory.
     * @param file file
     * @param stream input stream
     * @return {@code true} if the file data was successfully overridden. Otherwise is {@code false}.
     */
    public static boolean write(@NotNull File file, @NotNull InputStream stream){
        Condition.argNotNull("file", file);
        Condition.argNotNull("stream", stream);
        try {
            if(!file.exists() && !file.createNewFile()) return false;
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file));
            stream.transferTo(output);
            output.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Overrides the current data of a file with the given new data.<br>
     * This method will create the file automatically if it wasn't existed yet.<br>
     * This method won't work if the {@code File} object represents a directory.
     * @param file file
     * @param data new data
     * @return {@code true} if the file data was successfully overridden. Otherwise is {@code false}.
     */
    public static boolean write(@NotNull File file, @NotNull byte[] data){
        Condition.argNotNull("file", file);
        Condition.argNotNull("data", data);
        if(file.exists() && !file.isFile()) return false;
        try {
            RandomAccessFile f = new RandomAccessFile(file, "rw");
            f.setLength(data.length);
            f.write(data);
            f.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Overrides the current content of a file with the given new content.
     * @param file file
     * @param content new content
     * @return {@code true} if the file content was successfully overridden. Otherwise is {@code false}.
     * @see #write(File, byte[])
     */
    public static boolean write(@NotNull File file, @NotNull String content){
        return write(file, content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Appends the data from the given input stream to the end of a file.<br>
     * This method will create the file automatically if it wasn't existed yet.<br>
     * This method won't work if the {@code File} object represents a directory.
     * @param file file
     * @param stream stream
     * @return {@code true} if the given data was successfully appended. Otherwise is {@code false}.
     */
    public static boolean append(@NotNull File file, @NotNull InputStream stream){
        Condition.argNotNull("file", file);
        Condition.argNotNull("stream", stream);
        try {
            if(!file.exists() && !file.createNewFile()) return false;
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(file, true));
            stream.transferTo(output);
            output.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Appends the given data to the end of a file.<br>
     * This method will create the file automatically if it wasn't existed yet.<br>
     * This method won't work if the {@code File} object represents a directory.
     * @param file file
     * @param data data to be appended
     * @return {@code true} if the given data was successfully appended. Otherwise is {@code false}.
     */
    public static boolean append(@NotNull File file, @NotNull byte[] data){
        Condition.argNotNull("file", file);
        Condition.argNotNull("data", data);
        if(file.exists() && !file.isFile()) return false;
        try {
            RandomAccessFile f = new RandomAccessFile(file, "rw");
            f.seek(f.length());
            f.write(data);
            f.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Appends the given content to the end of a file.
     * @param file file
     * @param content content to be appended
     * @return {@code true} if the given content was successfully appended. Otherwise is {@code false}.
     * @see #append(File, byte[])
     */
    public static boolean append(@NotNull File file, @NotNull String content){
        return append(file, content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Reads the given file and returns its data.<br>
     * This method won't work if the {@code File} object represents a directory or a non-existing file.
     * @param file file
     * @return an array of bytes which represents the file data
     */
    public static byte[] read(@NotNull File file){
        Condition.argNotNull("file", file);
        if(file.exists() && file.isFile()) {
            try {
                BufferedInputStream data = new BufferedInputStream(new FileInputStream(file));
                var bytes = data.readAllBytes();
                data.close();
                return bytes;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ArrayUtil.EMPTY_BYTE_ARRAY;
    }

    /**
     * Reads a plain text file and and returns its content.<br>
     * If you don't know what the type of the file is, use {@link #read(File)} instead.
     * @param file file
     * @return a string which represents the file content
     * @see #read(File)
     */
    public static String readText(@NotNull File file){
        return new String(read(file), StandardCharsets.UTF_8);
    }
}
