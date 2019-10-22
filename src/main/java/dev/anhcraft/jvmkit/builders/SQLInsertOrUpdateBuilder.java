package dev.anhcraft.jvmkit.builders;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import dev.anhcraft.jvmkit.utils.Condition;
import dev.anhcraft.jvmkit.utils.StringUtil;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * A builder for creating {@code INSERT INTO ... ON DUPLICATE KEY UPDATE ...} SQL statement.
 */
public class SQLInsertOrUpdateBuilder implements Builder<String> {
    private final Map<String, String> data = new HashMap<>();
    private String tableName;

    /**
     * Constructs an instance of {@code SQLInsertOrUpdateBuilder} with the given table name.
     * @param tableName the name of a table
     */
    public SQLInsertOrUpdateBuilder(@NotNull String tableName){
        Condition.argNotNull("tableName", tableName);
        this.tableName = tableName;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, @Nullable String value){
        Condition.argNotNull("name", name);
        data.put(name, value == null ? "null" : value);
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, double value){
        Condition.argNotNull("name", name);
        data.put(name, Double.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, float value){
        Condition.argNotNull("name", name);
        data.put(name, Float.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, short value){
        Condition.argNotNull("name", name);
        data.put(name, Short.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, long value){
        Condition.argNotNull("name", name);
        data.put(name, Long.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, int value){
        Condition.argNotNull("name", name);
        data.put(name, Integer.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, boolean value){
        Condition.argNotNull("name", name);
        data.put(name, Boolean.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    @Contract("_, _ -> this")
    public SQLInsertOrUpdateBuilder add(@NotNull String name, @Nullable Enum<?> value) {
        Condition.argNotNull("name", name);
        data.put(name, value == null ? "null" : value.name());
        return this;
    }

    /**
     * Builds and gets the final statement.
     * @return statement
     */
    @Override
    @NotNull
    public String build(){
        StringBuilder x = new StringBuilder("INSERT INTO `" + tableName + "`(" +
                String.join(",", data.keySet()) + ") VALUES(");
        int i = 0;
        for(String n : data.values()){
            x.append("\"").append(StringUtil.escape(n)).append("\"");
            if(i < data.size() - 1) x.append(",");
            i++;
        }
        x.append(") ON DUPLICATE KEY UPDATE ");
        i = 0;
        for(Map.Entry<String, String> entry : data.entrySet()){
            x.append(entry.getKey()).append("=\"").append(StringUtil.escape(entry.getValue())).append("\"");
            if(i < data.size() - 1) x.append(", ");
            i++;
        }
        return x.toString();
    }
}
