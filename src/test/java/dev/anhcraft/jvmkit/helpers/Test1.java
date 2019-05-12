package dev.anhcraft.jvmkit.helpers;

import dev.anhcraft.jvmkit.trackers.BufferedStreamReadTracker;
import dev.anhcraft.jvmkit.trackers.reports.FixedStreamTransferReport;
import dev.anhcraft.jvmkit.utils.FileUtil;
import dev.anhcraft.jvmkit.utils.MathUtil;
import dev.anhcraft.jvmkit.utils.RandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class Test1 {
    @Test
    public void HTTPConnectionHelper(){
        var file = new File("./src/test/resources/50MB.zip");
        var conn = new HTTPConnectionHelper("http://212.183.159.230/50MB.zip").connect();
        var tracker = new BufferedStreamReadTracker(2048, conn.getInput());
        var report = new FixedStreamTransferReport(conn.getContentLength());
        tracker.setBufferCallback(bytes -> {
            if(RandomUtil.randomInt(0, 30) == 0) {
                System.out.println("=============================================================================");
                System.out.println("Current size: " + report.getTransferredMBytes() + " MB/" + report.getTotalMBytes() + " MB (Remaining: " + report.getRemainingMBytes() + " MB)");
                System.out.println("Speed: " + MathUtil.round(report.getBytesPerSecs(), 3) + "b/s (" + MathUtil.round(report.getMBytesPerSecs(), 3) + " MB/s)");
                System.out.println("Elapsed time: " + MathUtil.round(report.getElapsedSecs(), 3) + "s");
                System.out.println("Remaining time: " + MathUtil.round(report.getRemainingSecs(), 3) + "s");
                System.out.println("Progress: " + MathUtil.round(report.getProgress(), 3) + "%");
                System.out.println("=============================================================================");
                System.out.println();
            }
            FileUtil.append(file, bytes);
        });
        tracker.start(report, () -> Assert.assertTrue(report.validate()));
        file.delete();
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
