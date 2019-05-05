package dev.anhcraft.jvmkit.builders;

import dev.anhcraft.jvmkit.lang.annotation.NotNull;
import dev.anhcraft.jvmkit.utils.Condition;
import dev.anhcraft.jvmkit.utils.StringUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * A builder for creating {@code INSERT INTO ... ON DUPLICATE KEY UPDATE ...} SQL statement.
 */
public class SQLInsertOrUpdateBuilder implements Builder<String> {
    private final HashMap<String, String> data = new HashMap<>();
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
    public SQLInsertOrUpdateBuilder add(String name, String value){
        data.put(name, value == null ? "null" : value);
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, double value){
        data.put(name, Double.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, float value){
        data.put(name, Float.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, short value){
        data.put(name, Short.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, long value){
        data.put(name, Long.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, int value){
        data.put(name, Integer.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, boolean value){
        data.put(name, Boolean.toString(value));
        return this;
    }

    /**
     * Adds the given entry.
     * @param name entry name
     * @param value entry value
     * @return this object
     */
    public SQLInsertOrUpdateBuilder add(String name, Enum<?> value) {
        data.put(name, value == null ? "null" : value.toString());
        return this;
    }

    /**
     * Builds and gets the final statement.
     * @return statement
     */
    @Override
    public String build(){
        StringBuilder x = new StringBuilder("INSERT INTO `" + tableName + "`(" +
                String.join(",", data.keySet()) + ") VALUES(");
        var i = 0;
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
