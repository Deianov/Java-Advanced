//03. Custom Min Function
package E_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<int[], Integer> min = arr -> {
            int minValue = Integer.MAX_VALUE;
            for (int num : arr) {

                if (num < minValue) minValue = num;
            }
            return minValue;
        };

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        System.out.println(min.apply(numbers));

    }
}
