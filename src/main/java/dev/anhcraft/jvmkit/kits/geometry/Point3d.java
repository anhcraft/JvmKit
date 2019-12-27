package dev.anhcraft.jvmkit.kits.geometry;

import dev.anhcraft.jvmkit.utils.Condition;
import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.Objects;

public class Point3d implements Serializable, Point<Point3d> {
    private static final long serialVersionUID = -6845562905257335481L;

    public static final Point3d ORIGIN = new Point3d(0, 0, 0);

    protected double x;
    protected double y;
    protected double z;

    public Point3d(double x, double y, double z) {
        Condition.argNotNull("x", x);
        Condition.argNotNull("y", y);
        Condition.argNotNull("z", z);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    @NotNull
    public Point3d setX(double x) {
        this.x = x;
        return this;
    }

    public double getY() {
        return y;
    }

    @NotNull
    public Point3d setY(double y) {
        this.y = y;
        return this;
    }

    public double getZ() {
        return z;
    }

    @NotNull
    public Point3d setZ(double z) {
        this.z = z;
        return this;
    }

    @Override
    public double distanceSquared(@NotNull Point3d point) {
        double deltaX = point.x - x;
        double deltaY = point.y - y;
        double deltaZ = point.z - z;
        return deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3d point3d = (Point3d) o;
        return Double.compare(point3d.x, x) == 0 &&
                Double.compare(point3d.y, y) == 0 &&
                Double.compare(point3d.z, z) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
