package dev.anhcraft.jvmkit.helpers;

import dev.anhcraft.jvmkit.utils.IOUtil;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import dev.anhcraft.jvmkit.utils.ArrayUtil;
import dev.anhcraft.jvmkit.utils.Condition;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * A helper class provides methods for making a new HTTP Connection and manipulates it later.
 */
public class HTTPConnectionHelper {
    private final Map<String, String> properties = new HashMap<>();
    private URL url;
    private HttpURLConnection conn;
    private boolean doOutput;
    private String method = "GET";
    private BufferedInputStream input;
    private BufferedOutputStream output;

    /**
     * Constructs an instance of {@code HTTPConnectionHelper} with the given url.
     * @param url the URL to connect
     */
    public HTTPConnectionHelper(@NotNull String url) {
        Condition.argNotNull("url", url);
        try {
            this.url = new URL(url);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructs an instance of {@code HTTPConnectionHelper} with the given url.
     * @param url the URL to connect
     */
    public HTTPConnectionHelper(@NotNull URL url) {
        Condition.argNotNull("url", url);
        this.url = url;
    }

    /**
     * Sets the connection method.
     * @param method method (e.g: get, post, etc)
     * @return this object
     */
    @Contract("_ -> this")
    public HTTPConnectionHelper setMethod(@NotNull String method){
        Condition.argNotNull("method", method);
        this.method = method;
        return this;
    }

    /**
     * Sets the value of the given property.
     * @param name property name
     * @param value property value
     * @return this object
     */
    @Contract("_, _ -> this")
    public HTTPConnectionHelper setProperty(@NotNull String name, @NotNull String value){
        Condition.argNotNull("name", name);
        Condition.argNotNull("value", value);
        properties.put(name, value);
        return this;
    }

    /**
     * Enables the output.
     * @return this object
     */
    @Contract("-> this")
    public HTTPConnectionHelper doOutput(){
        this.doOutput = true;
        return this;
    }

    /**
     * Connects to the url.
     * @return this object
     */
    @Contract("-> this")
    public HTTPConnectionHelper connect(){
        return connect((Runnable) null);
    }

    /**
     * Connects to the url.
     * @param onError callback on having connection errors.
     * @return this object
     */
    public HTTPConnectionHelper connect(@Nullable Runnable onError){
        return this.connect(e -> { });
    }

    /**
     * Connects to the url.
     * @param onError callback on having connection errors.
     * @return this object
     */
    @Contract("_, -> this")
    public HTTPConnectionHelper connect(@Nullable Consumer<Exception> onError){
        try {
            conn = (HttpURLConnection) this.url.openConnection();
            conn.setRequestMethod(method);
            for(Map.Entry<String, String> entry : properties.entrySet()) {
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
            if(doOutput) {
                conn.setDoOutput(true);
                output = new BufferedOutputStream(conn.getOutputStream());
            }
            input = new BufferedInputStream(conn.getInputStream());
        } catch(IOException e) {
            if(onError != null) {
                onError.accept(e);
            }
        }
        return this;
    }

    /**
     * Write the given byte to the connection output.<br>
     * This method only works after use the method {@link #connect()}.
     * @param b a byte
     * @return this object
     */
    @Contract("_ -> this")
    public HTTPConnectionHelper write(byte b){
        if(output != null) {
            try {
                this.output.write(b);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Write the given data to the connection output.<br>
     * This method only works after use the method {@link #connect()}.
     * @param bytes an array of bytes
     * @return this object
     */
    @Contract("_ -> this")
    public HTTPConnectionHelper write(byte @NotNull [] bytes){
        Condition.argNotNull("bytes", bytes);
        if(output != null) {
            Condition.argNotNull("bytes", bytes);
            try {
                this.output.write(bytes);
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    /**
     * Reads the connection input and returns it as an array of bytes.<br>
     * This method only works after use the method {@link #connect()}.
     * @return data
     */
    public byte[] read(){
        if(input == null) {
            throw new UnsupportedOperationException("Please connect first");
        }
        try {
            return IOUtil.toByteArray(input, 4096);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ArrayUtil.EMPTY_BYTE_ARRAY;
    }

    /**
     * Reads the connection input and returns it as a string.<br>
     * This method only works after use the method {@link #connect()}.
     * @return text
     */
    @NotNull
    public String readText(){
        if(input == null) {
            throw new UnsupportedOperationException("Please connect first");
        }
        try {
            return new String(IOUtil.toByteArray(input, 4096));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Returns the input stream of this connection.
     * @return input stream
     */
    @NotNull
    public BufferedInputStream getInput(){
        if(input == null) {
            throw new UnsupportedOperationException("Please connect first");
        }
        return input;
    }

    /**
     * Returns the output stream of this connection.
     * @return output stream
     */
    @Nullable
    public BufferedOutputStream getOutput(){
        return output;
    }

    /**
     * Disconnects from the current connection.
     */
    public void disconnect(){
        if(conn == null) {
            throw new UnsupportedOperationException("Please connect first");
        }
        conn.disconnect();
    }

    /**
     * Returns the length of content.
     * @return content's length (or {@code -1} if this connection did not start)
     */
    public long getContentLength(){
        if(conn == null) {
            throw new UnsupportedOperationException("Please connect first");
        }
        return conn.getContentLengthLong();
    }

    /**
     * Returns this connection.
     * @return connection
     */
    @NotNull
    public HttpURLConnection getConnection(){
        if(conn == null) {
            throw new UnsupportedOperationException("Please connect first");
        }
        return conn;
    }
}
