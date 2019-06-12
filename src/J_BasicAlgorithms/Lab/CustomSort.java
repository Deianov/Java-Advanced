// 04. Sorting
package J_BasicAlgorithms.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class CustomSort {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        shellSort(numbers);
        for (int i = 0; i < numbers.length; ++i) {
            System.out.print(numbers[i] + " ");
        }
    }

    private static void shellSort(int[] numbers) {
        int length = numbers.length;

        for (int gap = length/2; gap > 0; gap /= 2) {

            for (int i = gap; i < length; i += 1) {

                int temp = numbers[i];

                int j;
                for (j = i; j >= gap && numbers[j - gap] > temp; j -= gap)
                    numbers[j] = numbers[j - gap];

                numbers[j] = temp;
            }
        }
    }
}
