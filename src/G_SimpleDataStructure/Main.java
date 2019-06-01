package G_SimpleDataStructure;

class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        for (int i = 0; i < 10 ; i++) {
            smartArray.add(i+1);
        }

//        for (int i = 0; i < 95 ; i++) {
//            smartArray.removeAt(0);
//        }

        smartArray.insertAt(9, -1);
        smartArray.print();
    }
}
