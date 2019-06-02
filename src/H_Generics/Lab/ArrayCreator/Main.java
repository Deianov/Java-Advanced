package H_Generics.Lab.ArrayCreator;

import java.util.Arrays;

class Main {
    public static void main(String[] args) {

//        String[] strings = ArrayCreator.create(10, "none");
        Integer[] integers = ArrayCreator.create(Integer.class, 10, 0);

//        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(integers));

    }
}
