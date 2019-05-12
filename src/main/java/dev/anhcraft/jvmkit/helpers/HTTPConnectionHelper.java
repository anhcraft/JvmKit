package dev.anhcraft.jvmkit.helpers;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;
import dev.anhcraft.jvmkit.utils.ArrayUtil;
import dev.anhcraft.jvmkit.utils.Condition;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * A helper class provides methods for making a new HTTP Connection and manipulates it later.
 */
public class HTTPConnectionHelper {
    /**
     * The Firefox user-agent string.
     */
    public static final String USER_AGENT_FIREFOX = "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0";

    /**
     * The Chrome (or Chromium-based browsers) user-agent string.
     */
    public static final String USER_AGENT_CHROME = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36";

    private final HashMap<String, String> properties = new HashMap<>();
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
    public HTTPConnectionHelper doOutput(){
        this.doOutput = true;
        return this;
    }

    /**
     * Connects to the url.
     * @return this object
     */
    public HTTPConnectionHelper connect(){
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
            e.printStackTrace();
        }
        return this;
    }

    /**
     * Write the given byte to the connection output.<br>
     * This method only works after use the method {@link #connect()}.
     * @param b a byte
     * @return this object
     */
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
    public HTTPConnectionHelper write(byte[] bytes){
        if(output != null) {
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
        if(input != null) {
            try {
                return input.readAllBytes();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return ArrayUtil.EMPTY_BYTE_ARRAY;
    }

    /**
     * Reads the connection input and returns it as a string.<br>
     * This method only works after use the method {@link #connect()}.
     * @return text
     */
    public String readText(){
        if(input != null) {
            try {
                return new String(input.readAllBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * Returns the input stream of this connection.
     * @return input stream
     */
    public BufferedInputStream getInput(){
        return input;
    }

    /**
     * Returns the output stream of this connection.
     * @return output stream
     */
    public BufferedOutputStream getOutput(){
        return output;
    }

    /**
     * Disconnects from the current connection.
     */
    public void disconnect(){
        conn.disconnect();
    }

    /**
     * Returns the length of content.
     * @return content's length (or {@code -1} if this connection did not start)
     */
    public long getContentLength(){
        return conn.getContentLengthLong();
    }

    /**
     * Returns this connection.
     * @return connection
     */
    public HttpURLConnection getConnection(){
        return conn;
    }
}
