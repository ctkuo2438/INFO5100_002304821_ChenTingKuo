package exercise7;

import java.util.List;

public class ListMaxFinder {
    // (c) Generic method to find maximal element in a range
    public static <T extends Comparable<T>> T findMax(List<T> list, int begin, int end) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        if (begin < 0 || end > list.size() || begin >= end) {
            throw new IllegalArgumentException("Invalid range");
        }

        T max = list.get(begin);
        for (int i = begin + 1; i < end; i++) {
            T current = list.get(i);
            if (current != null && current.compareTo(max) > 0) {
                max = current;
            }
        }
        return max;
    }
}
