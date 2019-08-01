package dev.anhcraft.jvmkit.experiment.utils;

import java.util.Arrays;

/**
 * Represents a table implementation.
 * @param <V> the data type of cells
 */
@SuppressWarnings("unchecked")
public class Table<V> {
    private V[][] data;
    private int rows;
    private int columns;
    private long emptySlots;
    private long nextEmptySlot;

    public Table(int rows, int columns){
        data = (V[][]) new Object[rows][columns];
        this.rows = rows;
        this.columns = columns;
        this.emptySlots = rows*columns;
        this.nextEmptySlot = emptySlots == 0 ? -1 : 0;
    }

    public Table(Table<V> table){
        data = Arrays.copyOf(table.data, table.data.length);
        rows = table.rows;
        columns = table.columns;
        emptySlots = table.emptySlots;
        nextEmptySlot = table.nextEmptySlot;
    }

    public void insertRow(){

    }
}
