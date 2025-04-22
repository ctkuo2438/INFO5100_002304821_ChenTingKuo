package exercise7;

import java.util.Collection;
import java.util.function.Predicate;

public class CollectionCounter {
    // (a) Generic method to count elements with a specific property
    public static <T> int countElements(Collection<T> collection, Predicate<T> property) {
        if (collection == null || property == null) {
            throw new IllegalArgumentException("Collection and predicate must not be null");
        }
        int count = 0;
        for (T element : collection) {
            if (property.test(element)) {
                count++;
            }
        }
        return count;
    }
}
