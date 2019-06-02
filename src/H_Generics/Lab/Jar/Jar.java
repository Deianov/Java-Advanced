package H_Generics.Lab.Jar;

import java.util.ArrayDeque;
import java.util.Deque;

class Jar<T> {

    Deque<T> stack;

    Jar() {
        this.stack = new ArrayDeque<>();
    }

    void add(T element){
        this.stack.push(element);
    }

    T remove() {
        return this.stack.pop();
    }

    T peek() {return this.stack.peek();}
}
