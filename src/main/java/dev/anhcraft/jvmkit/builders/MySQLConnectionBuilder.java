package dev.anhcraft.jvmkit.builders;

import org.jetbrains.annotations.NotNull;
import dev.anhcraft.jvmkit.utils.Condition;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * A builder for creating MySQL connections.
 */
public class MySQLConnectionBuilder implements Builder<Connection> {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String hostname;
    private int port;
    private String database;
    private String username;
    private String password;
    private HashMap<String, String> properties;

    /**
     * Returns the host name of the server which the database is hosted on.
     * @return hostname
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Sets the host name of the server.
     * @param hostname host name
     */
    public void setHostname(@NotNull String hostname) {
        Condition.argNotNull("hostname", "hostname");
        this.hostname = hostname;
    }

    /**
     * Returns the port which the database is listening to.
     * @return port
     */
    public int getPort() {
        return port;
    }

    /**
     * Sets the connection port.
     * @param port port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Returns the database's name.
     * @return database
     */
    public String getDatabase() {
        return database;
    }

    /**
     * Sets the name of the database to connect to.
     * @param database database
     */
    public void setDatabase(@NotNull String database) {
        Condition.argNotNull("database", "database");
        this.database = database;
    }

    /**
     * Returns the name of the user who controls the database.
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the name of the user.
     * @param username username
     */
    public void setUsername(@NotNull String username) {
        Condition.argNotNull("username", "username");
        this.username = username;
    }

    /**
     * Returns the password of the user.
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password password
     */
    public void setPassword(@NotNull String password) {
        Condition.argNotNull("password", "password");
        this.password = password;
    }

    /**
     * Returns a map of extra properties for this connection.<br>
     * This map is mutable, so you can manipulate that map directly to make changes in this object.
     * @return map
     */
    public HashMap<String, String> getProperties() {
        return properties;
    }

    /**
     * Builds and gets the final connection.
     * @return connection
     */
    @Override
    public Connection build() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + database + "?"+properties.entrySet().stream().map(e -> e.getKey()+"="+e.getValue()).collect(Collectors.joining("&")), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
