// Workshop Create SmartArray
package G_SimpleDataStructure;

import java.util.Arrays;
import java.util.function.Consumer;

class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int size;
    private int capacity;

    SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
        this.size = 0;
    }

    void add(int element) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.data[this.size++] = element;
    }

    int get(int index) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(String.format("Index <%d> out of bounds for SmartArray with size of %d", index, this.size));
        }
        return this.data[index];
    }

    boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element) {
                return true;
            }
        }
        return false;
    }

    int removeAt(int index){
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(String.format("Index <%d> out of bounds for SmartArray with size of %d", index, this.size));
        }
        int element = this.data[index];

        // remove index
        this.shift(index);
        this.removeLast();
        // free some memory
        this.shrink();

        return element;
    }

    private void removeLast(){
        this.data[this.size - 1] = 0;
        this.size--;
    }

    void insertAt(int index, int element) {
        if (index < 0 || index > this.size - 1) {
            throw new IndexOutOfBoundsException(String.format("Index <%d> out of bounds for SmartArray with size of %d", index, this.size));
        }
        if (this.size == this.capacity) {
            this.resize();
        }
        if (index == this.size - 1) {
            this.data[this.size] = this.data[this.size - 1];
            this.data[this.size - 1] = element;
        } else {
            this.shiftRight(index);
            this.data[index] = element;
        }
        this.size++;
    }

    // move index to last index
    private void shift(int index){
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index ; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    private void resize() {
        this.capacity *= 2;
        int[] newData = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    private void shrink() {
        int temp = this.capacity;

        // check if it is 4 times smaller than the capacity
        while (this.capacity > this.size * 4) {
            this.capacity /= 2;
        }

        if (this.capacity == temp) {
            return;
        }

        int[] newData = new int[this.capacity];
        System.arraycopy(this.data, 0, newData, 0, this.size);

        this.data = newData;
    }

    private void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }

    void print(){
        System.out.println(Arrays.toString(this.data));
    }
}
