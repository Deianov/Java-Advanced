//05. Longest Increasing Subsequence
package J_BasicAlgorithms.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] numbers = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int length = numbers.length;

        int[] lens = new int[length];
        int[] prev = new int[length];

        int maxSequence = -1;
        int maxSequenceIndex = -1;

        for (int i = 0; i < length; i++) {

            int number = numbers[i];
            int len = 0;
            int prevIndex = -1;

            for (int j = 0; j < i ; j++) {

                if (numbers[j] < number && lens[j] > len) {
                    len = lens[j];
                    prevIndex = j;
                }
            }

            lens[i] = ++len;
            prev[i] = prevIndex;

            if (len > maxSequence) {
                maxSequence = len;
                maxSequenceIndex = i;
            }
        }

        System.out.println(getSequenceEndsAtIndex(numbers, prev, maxSequenceIndex));
    }

    private static String getSequenceEndsAtIndex(int[] numbers, int[] prev, int index) {
        if (index < 0)
            return "";

        String result = numbers[index] + "";

        if (prev[index] >= 0) {
            result = getSequenceEndsAtIndex(numbers, prev, prev[index])+ " " + result;
        }
        return result;
    }
}
