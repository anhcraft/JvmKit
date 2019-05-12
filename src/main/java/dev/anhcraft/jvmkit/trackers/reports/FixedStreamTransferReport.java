package dev.anhcraft.jvmkit.trackers.reports;

import java.io.Serializable;
import java.util.Objects;

/**
 * This is the report for the data-transferring action of a stream whose length is known.
 */
public class FixedStreamTransferReport extends StreamTransferReport implements Serializable {
    private static final long serialVersionUID = 629050739560933809L;
    private long totalBytes;

    /**
     * Constructs an instance of {@code FixedStreamTransferReport}.
     * @param totalBytes total of bytes in the stream
     */
    public FixedStreamTransferReport(long totalBytes){
        this.totalBytes = totalBytes;
    }

    /**
     * Returns the total bytes.
     * @return total bytes
     */
    public long getTotalBytes(){
        return totalBytes;
    }

    /**
     * Returns the total kilo bytes.
     * @return total kilo bytes
     */
    public double getTotalKBytes(){
        return totalBytes/p3;
    }

    /**
     * Returns the total mega bytes.
     * @return total mega bytes
     */
    public double getTotalMBytes(){
        return totalBytes/p6;
    }

    /**
     * Returns how many remaining bytes are waiting to be transferred.
     * @return remaining bytes
     */
    public long getRemainingBytes() {
        return totalBytes-getTransferredBytes();
    }

    /**
     * Returns how many remaining kilo bytes are waiting to be transferred.
     * @return remaining kilo bytes
     */
    public double getRemainingKBytes() {
        return getTotalKBytes()-getTransferredKBytes();
    }

    /**
     * Returns how many remaining mega bytes are waiting to be transferred.
     * @return remaining mega bytes
     */
    public double getRemainingMBytes() {
        return getTotalMBytes()-getTransferredMBytes();
    }

    /**
     * Returns the remaining time until the action is complete.
     * @return remaining time (in seconds)
     */
    public double getRemainingSecs() {
        return getRemainingBytes()/getBytesPerSecs();
    }

    /**
     * Returns the remaining time until the action is complete.
     * @return remaining time (in minutes)
     */
    public double getRemainingMins() {
        return getRemainingSecs() / 60;
    }

    /**
     * Returns the remaining time until the action is complete.
     * @return remaining time (in hours)
     */
    public double getRemainingHours() {
        return getRemainingSecs() / 3600;
    }

    /**
     * Returns the finish progress.
     * @return progress
     */
    public double getProgress() {
        return 100.0d/totalBytes*getTransferredBytes();
    }

    /**
     * Validates whether the action is successful.<br>
     * This means that the action must have finished, and there are not any missing bytes.
     * @return {@code true} if the action is successful. Otherwise is {@code false}
     */
    public boolean validate(){
        return isFinished() && totalBytes == getTransferredBytes();
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedStreamTransferReport that = (FixedStreamTransferReport) o;
        return totalBytes == that.totalBytes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalBytes);
    }
}
