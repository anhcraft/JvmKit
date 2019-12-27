package dev.anhcraft.jvmkit.kits.geometry;

import org.jetbrains.annotations.NotNull;

public class Vector3d extends Point3d implements Vector<Vector3d, Point3d> {
    private static final long serialVersionUID = -3348225143251499072L;

    public static final Vector3d ZERO = new Vector3d(0, 0, 0);
    public static final Vector3d X_UNIT = new Vector3d(1, 0, 0);
    public static final Vector3d Y_UNIT = new Vector3d(0, 1, 0);
    public static final Vector3d Z_UNIT = new Vector3d(0, 0, 1);

    public Vector3d(double x, double y, double z) {
        super(x, y, z);
    }

    public Vector3d(@NotNull Point3d origin, @NotNull Point3d target) {
        super(target.x - origin.x, target.y - origin.y, target.z - origin.z);
    }

    @NotNull
    public Vector3d add(double x, double y, double z){
        this.x += x;
        this.y += y;
        this.z += z;
        return this;
    }

    @NotNull
    public Vector3d sub(double x, double y, double z){
        this.x -= x;
        this.y -= y;
        this.z -= z;
        return this;
    }

    @Override
    public double lengthSquared() {
        return distanceSquared(ZERO);
    }

    @Override
    public double length() {
        return distance(ZERO);
    }

    @Override
    public double cos​(@NotNull Vector3d other) {
        return dot(other) / (lengthSquared() * other.lengthSquared());
    }

    @NotNull
    @Override
    public Vector3d add(@NotNull Point3d other) {
        x += other.x;
        y += other.y;
        z += other.z;
        return this;
    }

    @NotNull
    @Override
    public Vector3d sub(@NotNull Point3d other) {
        x -= other.x;
        y -= other.y;
        z -= other.z;
        return this;
    }

    @NotNull
    @Override
    public Vector3d multi(double f) {
        this.x *= f;
        this.y *= f;
        this.z *= f;
        return this;
    }

    @NotNull
    @Override
    public Vector3d div(double f) {
        this.x /= f;
        this.y /= f;
        this.z /= f;
        return this;
    }

    @Override
    public double dot(@NotNull Vector3d other) {
        return x * other.x + y * other.y + z * other.z;
    }

    @NotNull
    @Override
    public Vector3d normalize​() {
        double len = lengthSquared();
        x /= len;
        y /= len;
        z /= len;
        return this;
    }

    @NotNull
    @Override
    public Vector3d duplicate() {
        return new Vector3d(x, y, z);
    }
}
