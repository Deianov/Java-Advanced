package G_SimpleDataStructure;

class Main {
    public static void main(String[] args) {

//        SmartArray smartArray = new SmartArray();
//        for (int i = 0; i < 10 ; i++) {
//            smartArray.add(i+1);
//        }
//        smartArray.insertAt(9, -1);
//        smartArray.print();

        LinkedList linkedList = new LinkedList();

        // remove after
        for (int i = 0; i < 5 ; i++) { linkedList.addLast(i+1); }
        for (int i = 4; i > 0 ; i--) { linkedList.removeAfter(i, i+1); }
        linkedList.removeFirst();

        // remove first
        for (int i = 0; i < 5 ; i++) { linkedList.addLast(i+1); }
        for (int i = 0; i < 5 ; i++) { linkedList.removeFirst(); }

        // remove last
        for (int i = 0; i < 5 ; i++) { linkedList.addLast(i+1); }
        for (int i = 0; i < 5 ; i++) { linkedList.removeLast(); }

        // add after
        linkedList.addFirst(1);
        for (int i = 1; i < 5 ; i++) { linkedList.addAfter(i, i+1); }

        linkedList.forEach(System.out::println);
        System.out.println(String.format("Head: %d", linkedList.getHead()));
        System.out.println(String.format("Size: %d", linkedList.getSize()));
        System.out.println(String.format("Tail: %d", linkedList.getTail()));
    }
}
