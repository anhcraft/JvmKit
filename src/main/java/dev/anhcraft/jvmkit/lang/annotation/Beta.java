package dev.anhcraft.jvmkit.lang.annotation;

import java.lang.annotation.*;

/**
 * An annotation to declare that the target is in the Beta stage.
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Beta {
}
