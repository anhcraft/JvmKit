package dev.anhcraft.jvmkit.builders;

import dev.anhcraft.jvmkit.utils.Condition;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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
    private int port = 3306;
    private String database;
    private String username;
    private String password;
    private final Map<String, String> propertyMap = new HashMap<>();

    /**
     * Sets the host name of the server.
     * @param hostname host name
     * @return this object
     */
    @Contract("_ -> this")
    public MySQLConnectionBuilder setHostname(@NotNull String hostname) {
        Condition.argNotNull("hostname", "hostname");
        this.hostname = hostname;
        return this;
    }

    /**
     * Sets the connection port.
     * @param port port
     * @return this object
     */
    @Contract("_ -> this")
    public MySQLConnectionBuilder setPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Sets the name of the database to connect to.
     * @param database database
     * @return this object
     */
    @Contract("_ -> this")
    public MySQLConnectionBuilder setDatabase(@NotNull String database) {
        Condition.argNotNull("database", "database");
        this.database = database;
        return this;
    }

    /**
     * Sets the name of the user.
     * @param username username
     * @return this object
     */
    @Contract("_ -> this")
    public MySQLConnectionBuilder setUsername(@NotNull String username) {
        Condition.argNotNull("username", "username");
        this.username = username;
        return this;
    }

    /**
     * Sets the password of the user.
     * @param password password
     * @return this object
     */
    @Contract("_ -> this")
    public MySQLConnectionBuilder setPassword(@NotNull String password) {
        Condition.argNotNull("password", "password");
        this.password = password;
        return this;
    }

    /**
     * Sets a property.
     * @param key the key
     * @param value the value
     * @return this object
     */
    @Contract("_, _ -> this")
    public MySQLConnectionBuilder setProperty(@NotNull String key, @NotNull String value) {
        Condition.argNotNull("key", key);
        Condition.argNotNull("value", value);
        propertyMap.put(key, value);
        return this;
    }

    /**
     * Builds and gets the final connection.
     * @return the connection
     */
    @Override
    @Nullable
    public Connection build() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + hostname + ":" + port + "/" + database + "?"+ propertyMap.entrySet().stream().map(e -> e.getKey()+"="+e.getValue()).collect(Collectors.joining("&")), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
