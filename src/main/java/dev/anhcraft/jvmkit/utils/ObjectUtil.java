package dev.anhcraft.jvmkit.utils;

import dev.anhcraft.jvmkit.lang.annotation.Beta;
import dev.anhcraft.jvmkit.lang.annotation.Label;
import dev.anhcraft.jvmkit.lang.enumeration.ComparisonOption;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * This class provides utility methods for {@link Object} manipulation.
 */
@SuppressWarnings("unchecked")
public class ObjectUtil {
    /**
     * Compares two given object deeply with extra options.<br>
     * For more details about those options, check out {@link ComparisonOption}.
     * @param a first object
     * @param b second object
     * @param options extra options
     * @return result (If the result is negative, it means the first object is "lower" than the second.
     * If the result is positive, it means the first object is "higher" than the second.
     * Otherwise, both of them are equal)
     */
    @Beta
    public static int deepCompare(@Nullable Object a, @Nullable Object b, @Nullable ComparisonOption... options){
        if(a == null && b == null) return 0;
        else if(a == null) return -1;
        else if(b == null) return 1;
        else if(a.getClass() == Object.class && b.getClass() == Object.class) return 0;
        else if(a.getClass().isArray() && b.getClass().isArray()) {
            int ma = Array.getLength(a);
            int mb = Array.getLength(b);
            if(ma != mb) return ma - mb;
            for(int i = 0; i < ma; i++) {
                int x = deepCompare(Array.get(a, i), Array.get(b, i), options);
                if(x != 0) return x;
            }
            return 0;
        }

        if(ArrayUtil.contains(options, ComparisonOption.IGNORE_DECIMAL)){
            if(a instanceof Number) a = ((Number) a).intValue();
            if(b instanceof Number) b = ((Number) b).intValue();
        }
        if(ArrayUtil.contains(options, ComparisonOption.CASE_INSENSITIVE)){
            if(a instanceof Character) a = Character.toLowerCase((Character) a);
            else if(a instanceof String) a = ((String) a).toLowerCase();
            if(b instanceof Character) b = Character.toLowerCase((Character) b);
            else if(b instanceof String) b = ((String) b).toLowerCase();
        }

        if(a.getClass() != b.getClass()) return a.hashCode() - b.hashCode();
        if(a instanceof Comparable) return ((Comparable) a).compareTo(b);

        Field[] fields = a.getClass().getDeclaredFields();
        try{
            if(a.getClass().isAnnotationPresent(Label.class) &&
                    Arrays.binarySearch(a.getClass().getAnnotation(Label.class).value(), Label.COMPARISON_LABEL) >= 0){
                for(Field f : fields){
                    f.setAccessible(true);
                    if(!f.isAnnotationPresent(Label.class) || Arrays.binarySearch(f.getAnnotation(Label.class).value(), Label.COMPARISON_LABEL) < 0) continue;
                    int x = deepCompare(f.get(a), f.get(b), options);
                    if(x != 0) return x;
                }
            } else {
                for(Field f : fields) {
                    f.setAccessible(true);
                    int x = deepCompare(f.get(a), f.get(b), options);
                    if(x != 0) return x;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return a.hashCode() - b.hashCode();
        }
        return 0;
    }
}
