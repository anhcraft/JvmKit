package dev.anhcraft.jvmkit.trackers;

import org.jetbrains.annotations.NotNull;
import dev.anhcraft.jvmkit.trackers.reports.StreamTransferReport;
import dev.anhcraft.jvmkit.utils.Condition;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.function.Consumer;

/**
 * This is the tracker of the reading actions of buffered streams.
 */
public class BufferedStreamReadTracker implements Tracker<StreamTransferReport> {
    private static final double p9 = Math.pow(10, 9);

    private final Object lock = new Object();
    private int bufferSize;
    private BufferedInputStream inputStream;
    private Consumer<byte[]> bufferCallback = bytes -> {};

    /**
     * Constructs an instance of {@code BufferedStreamReadTracker}.
     * @param bufferSize the buffer size
     * @param inputStream a buffered input stream
     */
    public BufferedStreamReadTracker(int bufferSize, @NotNull BufferedInputStream inputStream){
        this.bufferSize = bufferSize;
        this.inputStream = inputStream;
    }

    /**
     * Returns the buffer size.
     * @return buffer size
     */
    public int getBufferSize() {
        return bufferSize;
    }

    /**
     * Returns the buffer callback.
     * @return buffer callback
     */
    public Consumer<byte[]> getBufferCallback() {
        return bufferCallback;
    }

    /**
     * Sets the buffer callback
     * @param bufferCallback buffer callback
     */
    public void setBufferCallback(Consumer<byte[]> bufferCallback) {
        this.bufferCallback = bufferCallback;
    }

    @Override
    public void start(@NotNull StreamTransferReport report, @NotNull Runnable endCallback) {
        Condition.argNotNull("report", report);
        Condition.argNotNull("endCallback", endCallback);
        Condition.check(!report.isFinished(), "the report has already been used");
        synchronized(lock){
            try {
                byte[] buffer = new byte[bufferSize];
                int n;
                boolean eof;
                do {
                    long buffStartNanos = System.nanoTime();
                    n = inputStream.read(buffer, 0, bufferSize);
                    eof = n != -1;
                    if(eof) {
                        long buffEndNanos = System.nanoTime();
                        long deltaNanos = buffEndNanos - buffStartNanos;
                        report.setElapsedNanos(report.getElapsedNanos() + deltaNanos);
                        report.setTransferredBytes(report.getTransferredBytes() + n);
                        bufferCallback.accept(buffer);
                    }
                } while (eof);
                report.setFinished(true);
                endCallback.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
