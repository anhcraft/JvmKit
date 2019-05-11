package dev.anhcraft.jvmkit.lang.annotation;

import java.lang.annotation.*;

/**
 * An annotation to declare that the target is an immutable object.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Immutable {
}
