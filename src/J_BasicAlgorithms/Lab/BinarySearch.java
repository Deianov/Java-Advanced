package J_BasicAlgorithms.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sortedNumbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(reader.readLine());

        System.out.println(binarySearch(sortedNumbers, key));
    }

    private static int binarySearch(int[] sortedNumbers, int key) {
        int start = 0;
        int end = sortedNumbers.length - 1;
        int mid;

        while (start <= end) {

            mid = (start + end) / 2;

            if (key > sortedNumbers[mid]) {
                start = mid + 1;

            } else if (key < sortedNumbers[mid]) {
                end = mid - 1;

            } else {
                return mid;
            }
        }
        return -1;
    }
}
