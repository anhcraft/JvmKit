package dev.anhcraft.jvmkit.builders;

import org.junit.Test;

public class Test1 {
    @Test
    public void SQLInsertOrUpdateBuilder(){
        System.out.println(new SQLInsertOrUpdateBuilder("students")
                .add("name", "Jim")
                .add("age", 17)
                .add("team", "none")
                .add("join_date", System.currentTimeMillis())
                .add("bio", "!@#$%\"'\\\\\"'\\\"''\"").build());
    }
}
