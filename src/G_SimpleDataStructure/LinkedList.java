package G_SimpleDataStructure;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.function.Consumer;

class LinkedList {

    private class Node{
        private Node next;
        private Node previous;
        int element;

        private Node(int element){
            this.element = element;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    void addFirst(int element){

        Node newHead = new Node(element);
        if(this.size == 0){
            this.head = this.tail = newHead;
        }else {
            newHead.next = this.head;
            this.head.previous = newHead;
            this.head = newHead;
        }

        this.size++;
    }

    void addLast(int element){

        Node newTail = new Node(element);
        if(this.size == 0){
            this.head = this.tail = newTail;
        } else {
            newTail.previous = this.tail;
            this.tail.next = newTail;
            this.tail = newTail;
        }

        this.size++;
    }

    int removeFirst(){
        if (this.size == 0) {
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }
        int firstElement = this.head.element;
        this.head = this.head.next;
        if (this.head != null) {
            this.head.previous = null;
        } else {
            this.tail = null;
        }
        this.size--;
        return firstElement;
    }

    int removeLast() {
        if (this.size == 0) {

            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }
        int lastElement = this.tail.element;
        this.tail = this.tail.previous;
        if (this.tail != null) {
            this.tail.next = null;
        } else {
            this.head = null;
        }
        this.size--;
        return lastElement;
    }

    // linkedList.forEach(System.out::println);
    void  forEach(Consumer<Integer> consumer) {
        Node tempNode = this.head;
        while (tempNode != null) {
            consumer.accept(tempNode.element);
            tempNode = tempNode.next;
        }
    }

    int[] toArray() {
        int[] result = new int[this.size];

        Node tempNode = this.head;
        int index = 0;
        while (tempNode != null){
            result[index++] = tempNode.element;
            tempNode = tempNode.next;
        }

        return result;
    }

    void addAfter(int searchElement, int newElement){
        if(this.size == 0){
            throw new InvalidDnDOperationException("AddAfter method on empty list");
        }
        Node tempNode = this.head;
        while (tempNode != null){
            if(tempNode.element == searchElement){
                break;
            }
            tempNode = tempNode.next;
        }
        if(tempNode == null){
            throw new InvalidDnDOperationException("Element not found");
        }
        Node newNode = new Node(newElement);

        newNode.next = tempNode.next;
        newNode.previous = tempNode;

        tempNode.next = newNode;
        newNode.next.previous = newNode;
    }

    Node removeAfter(int searchElement, int removeElement){
        if (this.size == 0) {
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }
        Node tempNode = this.head;
        Node removeNode = null;
        while (tempNode != null){
            if(tempNode.element == searchElement){
                removeNode = tempNode.next;
                break;
            }
            tempNode = tempNode.next;
        }
        if(tempNode == null){
            throw new InvalidDnDOperationException("Search element not found");
        }
        if(removeNode == null || removeNode.element != removeElement){
            throw new InvalidDnDOperationException("Element for remove not found");
        }

        tempNode.next = removeNode.next;

        if (tempNode.next != null) {
            tempNode.next.previous = tempNode;
        }
        // remove element
        removeNode = null;

        this.size--;
        return tempNode.next;
    }
}
