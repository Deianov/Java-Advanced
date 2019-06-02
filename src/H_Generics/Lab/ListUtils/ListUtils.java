//04. List Utilities
package H_Generics.Lab.ListUtils;

import java.util.List;

class ListUtils {

    static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        T max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(max.compareTo(list.get(i)) < 0) {
                max = list.get(i);
            }
        }
        return max;
    }

    static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.size() == 0) {
            throw new IllegalArgumentException();
        }
        T min = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if(min.compareTo(list.get(i)) > 0) {
                min = list.get(i);
            }
        }
        return min;
    }
}
