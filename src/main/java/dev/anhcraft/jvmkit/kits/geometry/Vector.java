package dev.anhcraft.jvmkit.kits.geometry;

import org.jetbrains.annotations.NotNull;

public interface Vector<T extends Vector, P extends Point> extends Point<P> {
    double lengthSquared();

    double length();

    double cos​(@NotNull T other);

    default double angle​(@NotNull T other) {
        return Math.acos(cos​(other));
    }

    @NotNull
    T add(@NotNull P other);

    @NotNull
    T sub(@NotNull P other);

    @NotNull
    T multi(double f);

    @NotNull
    T div(double f);

    double dot(@NotNull T other);

    @NotNull
    T normalize​();

    @NotNull
    default T negate() {
        return multi(-1);
    }

    @NotNull
    T duplicate();
}
