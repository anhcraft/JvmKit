package dev.anhcraft.jvmkit.trackers.reports;

import java.io.Serializable;
import java.util.Objects;

/**
 * This is the report for the data-transferring action of a stream whose length is unknown.
 */
public class StreamTransferReport extends Report implements Serializable {
    private static final long serialVersionUID = -1311690460729324796L;
    protected static final double p3 = Math.pow(10, 3);
    protected static final double p6 = Math.pow(10, 6);
    private static final double p9 = Math.pow(10, 9);

    private double bytesPerSecs;
    private long transferredBytes;
    private long elapsedNanos;
    private boolean isFinished;

    /**
     * Returns how many bytes which the stream transferred.
     * @return transferred bytes
     */
    public long getTransferredBytes() {
        return transferredBytes;
    }

    /**
     * Returns how many kilo bytes which the stream transferred.
     * @return transferred kilo bytes
     */
    public double getTransferredKBytes() {
        return transferredBytes/p3;
    }

    /**
     * Returns how many mega bytes which the stream transferred.
     * @return transferred mega bytes
     */
    public double getTransferredMBytes() {
        return transferredBytes/p6;
    }

    /**
     * Sets the amount of bytes which the stream transferred.
     * @param transferredBytes bytes
     */
    public void setTransferredBytes(long transferredBytes) {
        this.transferredBytes = transferredBytes;
    }

    /**
     * Returns the elapsed time since the action started.
     * @return elapsed time (in nanoseconds)
     */
    public long getElapsedNanos() {
        return elapsedNanos;
    }

    /**
     * Returns the elapsed time since the action started.
     * @return elapsed time (in milliseconds)
     */
    public double getElapsedMillis() {
        return elapsedNanos/p6;
    }

    /**
     * Returns the elapsed time since the action started.
     * @return elapsed time (in seconds)
     */
    public double getElapsedSecs() {
        return elapsedNanos/p9;
    }

    /**
     * Returns the elapsed time since the action started.
     * @return elapsed time (in minutes)
     */
    public double getElapsedMins() {
        return getElapsedSecs()/60;
    }

    /**
     * Returns the elapsed time since the action started.
     * @return elapsed time (in hours)
     */
    public double getElapsedHours() {
        return getElapsedSecs()/3600;
    }

    /**
     * Sets the elapsed time since the action started.
     * @param elapsedNanos nanoseconds
     */
    public void setElapsedNanos(long elapsedNanos) {
        this.elapsedNanos = elapsedNanos;
    }

    /**
     * Returns the transfer speed in {@code B/s} (byte-per-second).
     * @return speed
     */
    public double getBytesPerSecs() {
        return transferredBytes/getElapsedSecs();
    }

    /**
     * Returns the transfer speed in {@code KB/s} (kilobyte-per-second).
     * @return speed
     */
    public double getKBytesPerSecs() {
        return getBytesPerSecs()/p3;
    }

    /**
     * Returns the transfer speed in {@code MB/s} (megabyte-per-second).
     * @return speed
     */
    public double getMBytesPerSecs() {
        return getBytesPerSecs()/p6;
    }

    /**
     * Checks if the action was finished.
     * @return {@code true} if it was, or {@code false} if not
     */
    public boolean isFinished() {
        return isFinished;
    }

    /**
     * Sets the finish status for the action.
     * @param finished finish status
     */
    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StreamTransferReport that = (StreamTransferReport) o;
        return Double.compare(that.bytesPerSecs, bytesPerSecs) == 0 &&
                transferredBytes == that.transferredBytes &&
                elapsedNanos == that.elapsedNanos &&
                isFinished == that.isFinished;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bytesPerSecs, transferredBytes, elapsedNanos, isFinished);
    }
}
