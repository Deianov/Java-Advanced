package J_BasicAlgorithms.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        bubbleSort(numbers);
        System.out.println(Arrays.toString(numbers).replaceAll("[\\[\\],]", ""));
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
}
