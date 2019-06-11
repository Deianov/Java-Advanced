package J_BasicAlgorithms.Lab;

import java.util.Random;

class Sorting {

    private static int[] array;
    private static int[] numbers;
    private static long startTime = 0;
    private static long endTime;
    private static int RANGE = 10000;

    public static void main(String[] args) {

        Random random = new Random(System.currentTimeMillis());

        // init array
        array = new int[RANGE];
        for (int i = 0; i < RANGE; i++) { array[i] = random.nextInt(RANGE); }

        numbers = new int[array.length];
        print();

        startTime = System.nanoTime();
        bubbleSort(numbers);
        print("Bubble Sort");

        startTime = System.nanoTime();
        insertionSort(numbers);
        print("Insertion Sort");

        startTime = System.nanoTime();
        shellSort(numbers);
        print("Shell Sort");
    }



    private static void shellSort(int[] numbers) {
        // Start with a big gap, then reduce the gap
        int length = numbers.length;

        for (int gap = length/2; gap > 0; gap /= 2) {
            // Do a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already
            // in gapped order keep adding one more element
            // until the entire array is gap sorted

            for (int i = gap; i < length; i += 1) {
                // add a[i] to the elements that have been gap
                // sorted save a[i] in temp and make a hole at
                // position i
                int temp = numbers[i];

                // shift earlier gap-sorted elements up until
                // the correct location for a[i] is found
                int j;
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap)
                    numbers[j] = numbers[j - gap];

                // put temp (the original a[i]) in its correct
                // location
                numbers[j] = temp;
            }
        }
    }



    private static void bubbleSort(int[] numbers) {
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

    private static void insertionSort(int[] numbers) {

        int length = numbers.length;

        for (int i = 1; i < length ; i++) {

            int current = numbers[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key, to one position ahead of their current position.
            while (j >= 0 && numbers[j] > current) {

                numbers[j + 1] = numbers[j];
                j--;
            }
            numbers[j + 1] = current;
        }
    }

    private static void print(String... name) {
        endTime = System.nanoTime();
        if (startTime != 0) {
            System.out.println(name[0]);
            System.out.println(String.format("Time: %d milliseconds.", ((endTime - startTime)/1000000)));
            for (int i = 0; i < RANGE; ++i) {
                System.out.print(numbers[i] + " ");
            }
            System.out.println();
        }
        System.arraycopy(array, 0, numbers, 0, array.length);
    }
}
