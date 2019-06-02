package H_Generics.Exercises.SwapMethodInteger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Box<T> {
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

    @Override
    public String toString() {
        String type = this.list.get(0).getClass().getName();
        StringBuilder stringBuilder = new StringBuilder(this.list.size());
        this.list.forEach(e -> {
            stringBuilder.append(String.format("%s: %s%n", type, e));
        });
        return stringBuilder.toString();
    }
}
