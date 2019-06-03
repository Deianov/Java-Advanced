package H_Generics.Exercises.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class CustomList<T extends Comparable<T>> {
    private List<T> list;

    CustomList() {
        this.list = new ArrayList<>();
    }

    void add(T element) {
        this.list.add(element);
    }

    T get(int index) {
        if (isEmpty() || !isValidIndex(index)) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        return this.list.get(index);
    }

    T remove(int index) {
        if (isEmpty() || !isValidIndex(index)) {
            return null;
        }
        T temp = list.get(index);
        this.list.remove(index);
        return temp;
    }

    boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }

        for (T item : this.list) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }

    void swap(int a, int b) {
        if (!isEmpty() && isValidIndex(a, b)) {
            Collections.swap(this.list, a, b);
        }
    }

    void sort() {
        Collections.sort(this.list);
    }

    private boolean isEmpty() {
        return this.list.size() == 0;
    }

    private boolean isValidIndex(int... indexes) {
        for (int index : indexes) {
            if (index < 0 || index >= this.list.size()) {
                return false;
            }
        }
        return true;
    }

    long countGreaterThan(T element) {
        return this.list.stream().filter(e -> e.compareTo(element) > 0).count();
    }

    T getMax() {
        return this.list.stream().max(T::compareTo).orElse(null);
    }

    T getMin() {
        return this.list.stream().min(T::compareTo).orElse(null);
    }

    void forEach (Consumer<T> consumer) {
        for (T element : this.list) {
            consumer.accept(element);
        }
    }

    void printAll() {
        forEach(System.out::println);
    }
}
