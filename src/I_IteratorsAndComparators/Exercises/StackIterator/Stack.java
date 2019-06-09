package I_IteratorsAndComparators.Exercises.StackIterator;

import java.util.Iterator;

class Stack<T> implements Iterable<T> {

    private Node top;

    private class Node {
        private T element;
        private Node next;
        private Node prev;


        private Node(T element) {
            this.element = element;
            this.next = top;
            this.prev = null;
            top = this;
            if (this.next != null) {
                this.next.prev = this;
            }
        }
    }

    void push(T element) {
        new Node(element);
    }

    T pop() {
        if (this.top == null) {
            throw new IndexOutOfBoundsException("No elements");
        }

        Node remove = this.top;
        T result = remove.element;

        this.top = remove.next;
        remove = null;

        if (this.top != null) {
            this.top.prev = null;
        }

        return result;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            Node currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public T next() {
                T result = currentNode.element;
                currentNode = currentNode.next;
                return result;
            }
        };
    }
}
