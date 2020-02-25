package dev.anhcraft.jvmkit.trackers;

import dev.anhcraft.jvmkit.helpers.HTTPConnectionHelper;
import dev.anhcraft.jvmkit.trackers.reports.FixedStreamTransferReport;
import dev.anhcraft.jvmkit.utils.FileUtil;
import dev.anhcraft.jvmkit.utils.MathUtil;
import dev.anhcraft.jvmkit.utils.RandomUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class Test1 {
    @Test
    public void BufferedStreamReadTracker(){
        File file = new File("./src/test/resources/50MB.zip");
        HTTPConnectionHelper conn = new HTTPConnectionHelper("http://212.183.159.230/50MB.zip").connect();
        BufferedStreamReadTracker tracker = new BufferedStreamReadTracker(4096, conn.getInput());
        FixedStreamTransferReport report = new FixedStreamTransferReport(conn.getContentLength());
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
}
