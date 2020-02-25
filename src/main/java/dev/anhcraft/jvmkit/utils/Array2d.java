package dev.anhcraft.jvmkit.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

/**
 * This class is a wrapper of two-dimensional arrays.<br>
 * It provides helpful methods for working with 2d array, e.g: it is safe<br>
 * to get an element at any index, if it is out of bound, {@code null} will<br>
 * be returned, and no exceptions will throw.<br>
 * That also means all elements in the array must be <b>non-null.</b>
 * @param <T> element type
 */
public class Array2d<T> {
    private T[][] backend;
    private Point2d cursor;
    private Consumer<Point2d> consumer;

    /**
     * Constructs {@link Array2d} from the given 2d array.
     * @param backend backend array
     */
    public Array2d(@NotNull T[][] backend) {
        this.backend = backend;
    }

    /**
     * Making a loop through all elements in this array starting<br>
     * from the given coordinate.
     * @param cursorX starting point (X-axis)
     * @param cursorY starting point (Y-axis)
     * @param callback the consumer to be called with each element
     */
    public void forEach(int cursorX, int cursorY, @NotNull Consumer<Point2d> callback){
        cursor = new Point2d(cursorX, cursorY);
        this.consumer = callback;
        callback.accept(cursor);
    }

    @NotNull
    public T[][] getBackend(){
        return backend;
    }

    /**
     * Two-dimensional point for used in {@link Array2d}.
     */
    public class Point2d {
        private int cursorX;
        private int cursorY;

        public Point2d(int cursorX, int cursorY) {
            this.cursorX = cursorX;
            this.cursorY = cursorY;
        }

        /**
         * Gets the x-axis position of this point.
         * @return position in x-axis
         */
        public int getX() {
            return cursorX;
        }

        /**
         * Gets the y-axis position of this point.
         * @return position in y-axis
         */
        public int getY() {
            return cursorY;
        }

        /**
         * Gets the data stored in the current point.
         * @return the data
         */
        @NotNull
        public T get(){
            return backend[cursorX][cursorY];
        }

        /**
         * Gets the data stored in relative point.
         * @param deltaX the distance between this point and the target in x-axis
         * @param deltaY the distance between this point and the target in y-axis
         * @return the data; it should be non-null, however in some cases it
         *         can be null (e.g: because the target point is out of bound)
         */
        @Nullable
        public T get(int deltaX, int deltaY) {
            int nx = cursorX + deltaX;
            int ny = cursorY + deltaY;
            if(nx < 0 || nx >= backend.length) return null;
            if(ny < 0 || ny >= backend[nx].length) return null;
            return backend[nx][ny];
        }

        /**
         * Gets the data stored in relative point.
         * @param direction the direction to the target point
         * @return the data; it should be non-null, however in some cases it
         *         can be null (e.g: because the target point is out of bound)
         */
        @Nullable
        public T get(@NotNull Direction direction) {
            return get(direction.deltaX, direction.deltaY);
        }

        /**
         * Gets the data stored in relative point.
         * @param direction the direction to the target point
         * @param distance the distance between this point and the target
         * @return the data; it should be non-null, however in some cases it
         *         can be null (e.g: because the target point is out of bound)
         */
        @Nullable
        public T get(@NotNull Direction direction, int distance) {
            return get(direction.deltaX * distance, direction.deltaY * distance);
        }

        /**
         * Checks if the current point is in corner.
         * @return {@code true} if it is, otherwise {@code false} returned
         */
        public boolean isInCorner() {
            if(cursorX == 0){
                return cursorY == 0 || cursorY == backend[cursorX].length - 1;
            } else if(cursorX == backend.length - 1){
                return cursorY == 0 || cursorY == backend[cursorX].length - 1;
            }
            return false;
        }

        /**
         * Checks if the current point is in edge.
         * @return {@code true} if it is, otherwise {@code false} returned
         */
        public boolean isInEdge() {
            if(cursorX == 0 || cursorX == backend.length - 1) return true;
            return cursorY == 0 || cursorY == backend[cursorX].length - 1;
        }

        /**
         * Goes to another points in given distances.
         * @param deltaX the distance between this point and the target in x-axis
         * @param deltaY the distance between this point and the target in y-axis
         * @return this object (but the context is of the next point)
         */
        @Nullable
        public Point2d go(int deltaX, int deltaY) {
            int nx = cursorX + deltaX;
            int ny = cursorY + deltaY;
            if(nx < 0 || nx >= backend.length) return null;
            if(ny < 0 || ny >= backend[nx].length) return null;
            cursorX = nx;
            cursorY = ny;
            consumer.accept(cursor);
            return this;
        }

        /**
         * Goes to another points in given direction.
         * @param direction the direction to the target point
         * @return this object (but the context is of the next point)
         */
        @Nullable
        public Point2d go(@NotNull Direction direction) {
            return go(direction.deltaX, direction.deltaY);
        }

        /**
         * Go to the next element.<br>
         * The next element will be in the right side.<br>
         * If the end of the row reached, the first element<br>
         * in the next row will be chosen.
         * @return {@code true} if success, or {@code false} if not (e.g: out of bound)
         */
        public boolean next(){
            cursorX++;
            if(cursorX == backend.length){
                cursorX = 0;
                cursorY++;
            }
            if(cursorY == backend[cursorX].length){
                return false;
            }
            consumer.accept(cursor);
            return true;
        }

        /**
         * Clones this point.
         * @return cloned point.
         */
        @NotNull
        public Point2d duplicate(){
            return new Point2d(cursorX, cursorY);
        }
    }

    /**
     * Points direction.
     */
    public enum Direction {
        UPWARD(0, 1),
        DOWNWARD(0, -1),
        LEFT(1, 0),
        RIGHT(-1, 0);

        private int deltaX;
        private int deltaY;

        Direction(int deltaX, int deltaY) {
            this.deltaX = deltaX;
            this.deltaY = deltaY;
        }

        public int getDeltaX() {
            return deltaX;
        }

        public int getDeltaY() {
            return deltaY;
        }
    }
}
