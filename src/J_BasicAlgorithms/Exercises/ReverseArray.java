//01. Reverse Array
package J_BasicAlgorithms.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class ReverseArray {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

        swap(numbers, 0, numbers.length - 1);

        for (int n : numbers) {
            System.out.print(n + " ");
        }
    }

    private static void swap(int[]arr, int a, int b) {
        if (a < b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            swap(arr, a+1, b-1);
        }
    }
}
