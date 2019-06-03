package H_Generics.Exercises.CustomList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> customList;


    CustomList() {
        this.customList = new ArrayList<>();
    }


    void add(T element) {
        this.customList.add(element);
    }


    T get(int index) {
        if (isEmpty() || !isValidIndex(index)) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        return this.customList.get(index);
    }


    T remove(int index) {
        if (isEmpty() || !isValidIndex(index)) {
            return null;
        }
        T temp = customList.get(index);
        this.customList.remove(index);
        return temp;
    }


    boolean contains(T element) {
        if (isEmpty()) {
            return false;
        }

        for (T item : this.customList) {
            if (item.compareTo(element) == 0) {
                return true;
            }
        }
        return false;
    }


    void swap(int a, int b) {
        if (!isEmpty() && isValidIndex(a, b)) {
            Collections.swap(this.customList, a, b);
        }
    }


    void sort() {
        Collections.sort(this.customList);
    }


    long countGreaterThan(T element) {
        return this.customList.stream().filter(e -> e.compareTo(element) > 0).count();
    }


    T getMax() {
        return this.customList.stream().max(T::compareTo).orElse(null);
    }


    T getMin() {
        return this.customList.stream().min(T::compareTo).orElse(null);
    }

    private boolean isEmpty() {
        return this.customList.size() == 0;
    }

    private boolean isValidIndex(int... indexes) {
        for (int index : indexes) {
            if (index < 0 || index >= this.customList.size()) {
                return false;
            }
        }
        return true;
    }


    void printAll() {
        forEach(System.out::println);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private  int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < customList.size();
            }

            @Override
            public T next() {
                return customList.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
