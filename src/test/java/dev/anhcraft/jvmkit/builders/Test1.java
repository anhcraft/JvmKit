package dev.anhcraft.jvmkit.builders;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

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

    @Test
    public void FilePathBuilder(){
        Assert.assertTrue(new File(new FilePathBuilder().dir("src", "test", "resources").file("hello world.txt").build()).exists());
    }
}
