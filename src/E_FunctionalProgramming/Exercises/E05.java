//05. Reverse And Exclude
package E_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int divider = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> divisible = number -> number % divider != 0;

        Consumer<int[]> printer = arr -> {
            for (int i = arr.length-1; i >= 0 ; i--) {
                if (divisible.test(arr[i])) {
                    System.out.print(arr[i] + " ");
                }
            }
        };

        printer.accept(numbers);
    }
}
