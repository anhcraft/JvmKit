package dev.anhcraft.jvmkit.kits.geometry;

import dev.anhcraft.jvmkit.utils.Condition;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class Point2d implements Serializable, Point<Point2d> {
    private static final long serialVersionUID = -2109017453485225252L;

    public static final Point2d ORIGIN = new Point2d(0, 0);

    protected double x;
    protected double y;

    public Point2d(double x, double y) {
        Condition.argNotNull("x", x);
        Condition.argNotNull("y", y);
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    @NotNull
    public Point2d setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    @NotNull
    public Point2d setY(double y) {
        this.y = y;
        return this;
    }

    @Override
    public double distanceSquared(@NotNull Point2d point) {
        double deltaX = point.x - x;
        double deltaY = point.y - y;
        return deltaX * deltaX + deltaY * deltaY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point2d point2d = (Point2d) o;
        return Double.compare(point2d.x, x) == 0 &&
                Double.compare(point2d.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
