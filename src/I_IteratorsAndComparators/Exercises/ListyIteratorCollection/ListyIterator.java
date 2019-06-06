package I_IteratorsAndComparators.Exercises.ListyIteratorCollection;

import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private static final int INIT_START_INDEX = 0;

    private List<String> list;
    private int index;

    public ListyIterator(List<String> list) {
        this.list = list;
        this.index = INIT_START_INDEX;
    }

    public boolean Move() {
        if (this.index < this.list.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    public void Print() {
        if (this.index < this.list.size()) {
            System.out.println(this.list.get(this.index));
        } else {
            System.out.println(("Invalid Operation!"));
        }
    }

    public boolean hasNext() {
        return this.index + 1 < this.list.size();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {

            private int currentIndex = INIT_START_INDEX;

            @Override
            public boolean hasNext() {
                return currentIndex < list.size();
            }

            @Override
            public String next() {
                return list.get(currentIndex++);
            }
        };
    }
}
