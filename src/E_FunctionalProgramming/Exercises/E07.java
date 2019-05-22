//07. Find The Smallest Element
package E_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        Consumer<int[]> minValue = arr -> {
            int min = arr[0];
            int index = 0;

            for (int i = 1; i < arr.length ; i++) {

                if (arr[i] <= min) {
                    min = arr[i];
                    index = i;
                }
            }
            System.out.println(index);
        };
        minValue.accept(numbers);
    }
}
