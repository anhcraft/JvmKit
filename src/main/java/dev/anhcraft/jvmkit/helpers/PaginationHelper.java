package dev.anhcraft.jvmkit.helpers;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * This class helps you to divide a set of data into small ones per page.<br>
 * All pages have the same slot. Each slot can hold one element.
 * @param <T> data type
 */
public class PaginationHelper<T> {
    private T[] data;
    private int slotPerPage;
    private int totalSlot;
    private int currentPage;
    private int totalPage;

    /**
     * Constructs an instance of {@code PaginationHelper}.
     * @param data an array of data
     * @param slot the number of slots per page
     */
    public PaginationHelper(T[] data, int slot){
        this.data = data;
        this.slotPerPage = slot;
        this.totalSlot = data.length;
        this.currentPage = 1;
        this.totalPage = (data.length % slot == 0) ? data.length/slot : (data.length/slot + 1);
    }

    /**
     * Opens a page with the given index.<br>
     * If the index is out of bound, the first index or the last one will be selected instead.
     * @param index the page index (starting from one)
     * @return this object whose given page is opened
     */
    public PaginationHelper<T> open(int index){
        currentPage = Math.max(1, Math.min(totalPage, index));
        return this;
    }

    /**
     * Opens the next page.
     * @return this object whose next page is opened
     */
    public PaginationHelper<T> next(){
        return open(currentPage+1);
    }

    /**
     * Opens the previous page.
     * @return this object whose previous page is opened
     */
    public PaginationHelper<T> prev(){
        return open(currentPage-1);
    }

    /**
     * Returns the data
     * @return data
     */
    public T[] getData() {
        return data;
    }

    /**
     * Returns the number of slots per page.
     * @return slot per page
     */
    public int getSlotPerPage() {
        return slotPerPage;
    }

    /**
     * Returns the total number of slots.
     * @return total number of slots
     */
    public int getTotalSlot() {
        return totalSlot;
    }

    /**
     * Returns the current page.
     * @return page index
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * Returns the total number of pages.
     * @return total number of pages.
     */
    public int getTotalPage() {
        return totalPage;
    }

    /**
     * Collects all elements in the current page.
     * @return an array of elements
     */
    public T[] collect(){
        return Arrays.copyOfRange(data, (currentPage-1)*slotPerPage, Math.min(totalSlot, currentPage*slotPerPage));
    }

    /**
     * Executes the given operation for each element in the current page.
     * @param consumer consumer
     * @return this object
     */
    public PaginationHelper<T> each(Consumer<T> consumer){
        for(T e : collect()) consumer.accept(e);
        return this;
    }
}