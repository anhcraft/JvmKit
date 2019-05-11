package dev.anhcraft.jvmkit.helpers;

import org.junit.Assert;
import org.junit.Test;

public class Test1 {
    @Test
    public void HTTPConnectionHelper(){
        new HTTPConnectionHelper("https://raw.githubusercontent.com/anhcraft/JvmKit/master/README.md").setProperty("User-Agent", HTTPConnectionHelper.USER_AGENT_CHROME).connect().read();
    }

    @Test
    public void PaginationHelper(){
        PaginationHelper<Integer> x = new PaginationHelper<>(new Integer[]{6, 4, 0, 2, 7}, 2);
        Assert.assertArrayEquals(new Integer[]{6, 4}, x.collect());
        Assert.assertArrayEquals(new Integer[]{0, 2}, x.next().collect());
        Assert.assertArrayEquals(new Integer[]{7}, x.next().collect());

        x = new PaginationHelper<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 4);
        Assert.assertArrayEquals(new Integer[]{1, 2, 3, 4}, x.collect());
        Assert.assertArrayEquals(new Integer[]{5, 6, 7, 8}, x.next().collect());
        Assert.assertArrayEquals(new Integer[]{9}, x.next().collect());
    }
}
