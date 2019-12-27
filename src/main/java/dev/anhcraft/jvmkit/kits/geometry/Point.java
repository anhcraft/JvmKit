package dev.anhcraft.jvmkit.kits.geometry;

import org.jetbrains.annotations.NotNull;

public interface Point<T extends Point> {
    double distanceSquared(@NotNull T point);

    default double distance(@NotNull T point){
        return Math.sqrt(distanceSquared(point));
    }
}
