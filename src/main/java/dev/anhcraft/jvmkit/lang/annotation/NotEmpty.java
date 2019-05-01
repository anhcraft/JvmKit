package dev.anhcraft.jvmkit.lang.annotation;

import java.lang.annotation.*;

/**
 * An annotation to declare that the target can not be empty.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface NotEmpty {
}
