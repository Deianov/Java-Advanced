//04. List Utilities
package H_Generics.Lab.ListUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {
    public static void main(String[] args) {

        List<Integer> integers = new ArrayList<>();
        Collections.addAll(integers, 1, 2, 18, 2, -1);

        System.out.println(ListUtils.getMax(integers));
        System.out.println(ListUtils.getMin(integers));

        List<String> strings = new ArrayList<>();
        Collections.addAll(strings, "a", "b", "c");

        System.out.println(ListUtils.getMax(strings));
        System.out.println(ListUtils.getMin(strings));
    }
}
