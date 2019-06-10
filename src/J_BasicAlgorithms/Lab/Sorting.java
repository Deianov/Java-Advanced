package J_BasicAlgorithms.Lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Sorting {

    private static int[] array;
    private static int[] numbers;

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        array = new int[] {9, 1, 7, 4, 2, 5, 6, 0, 3, 8};
        numbers = new int[array.length];
        print();

        bubbleSort();
        print();

    }

    private static void print() {
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
        System.arraycopy(array, 0, numbers, 0, array.length);
    }

    private static void bubbleSort() {
        boolean swap = true;
        int last = numbers.length;

        while (swap) {
            swap = false;

            for (int i = 0; i < last - 1; i++) {

                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    swap = true;
                }
            }
            last--;
        }
    }
}
