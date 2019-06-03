package H_Generics.Exercises.CountMethodDouble;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Box<T extends Comparable<T>> {
    private List<T> list;

    Box() {
        this.list = new ArrayList<>();
    }

    T get(int index) {
        return this.list.get(index);
    }

    void add(T element) {
        this.list.add(element);
    }

    void swap(int a, int b) {
        Collections.swap(this.list, a, b);
    }

    int countGreater(T element) {
        int cnt = 0;
        for (T value : this.list) {
            if (value.compareTo(element) > 0) cnt++;
        }
        return cnt;
    }
}
