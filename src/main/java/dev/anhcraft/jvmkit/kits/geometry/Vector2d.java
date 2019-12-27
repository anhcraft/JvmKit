package dev.anhcraft.jvmkit.kits.geometry;

import org.jetbrains.annotations.NotNull;

public class Vector2d extends Point2d implements Vector<Vector2d, Point2d> {
    private static final long serialVersionUID = -1126507625165030711L;

    public static final Vector2d ZERO = new Vector2d(0, 0);
    public static final Vector2d X_UNIT = new Vector2d(1, 0);
    public static final Vector2d Y_UNIT = new Vector2d(0, 1);

    public Vector2d(double x, double y) {
        super(x, y);
    }

    public Vector2d(@NotNull Point2d origin, @NotNull Point2d target) {
        super(target.x - origin.x, target.y - origin.y);
    }

    @NotNull
    public Vector2d add(double x, double y){
        this.x += x;
        this.y += y;
        return this;
    }

    @NotNull
    public Vector2d sub(double x, double y){
        this.x -= x;
        this.y -= y;
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
    public double cos​(@NotNull Vector2d other) {
        return dot(other) / (lengthSquared() * other.lengthSquared());
    }

    @NotNull
    @Override
    public Vector2d add(@NotNull Point2d other) {
        x += other.x;
        y += other.y;
        return this;
    }

    @NotNull
    @Override
    public Vector2d sub(@NotNull Point2d other) {
        x -= other.x;
        y -= other.y;
        return this;
    }

    @NotNull
    @Override
    public Vector2d multi(double f) {
        this.x *= f;
        this.y *= f;
        return this;
    }

    @NotNull
    @Override
    public Vector2d div(double f) {
        this.x /= f;
        this.y /= f;
        return this;
    }

    @Override
    public double dot(@NotNull Vector2d other) {
        return x * other.x + y * other.y;
    }

    @NotNull
    @Override
    public Vector2d normalize​() {
        double len = lengthSquared();
        x /= len;
        y /= len;
        return this;
    }

    @NotNull
    @Override
    public Vector2d duplicate() {
        return new Vector2d(x, y);
    }
}
