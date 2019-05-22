//04. Applied Arithmetics
package E_FunctionalProgramming.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.function.Function;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        Function<Integer, Integer> add = x -> x + 1;
        Function<Integer, Integer> subtract = x -> x - 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        Function<int[], String> print = arr -> Arrays.toString(arr).replaceAll("[\\[\\],]", "");

        Deque<String> queue = new ArrayDeque<>();
        String command;

        while (!"end".equals(command = scanner.nextLine())) {

            Function<Integer, Integer> function = null;

            switch (command) {
                case "add": function = add;break;
                case "subtract": function = subtract;break;
                case "multiply": function = multiply;break;
            }

            if (function == null) {
                queue.offer(print.apply(numbers));
            }

            for (int i = 0; i < numbers.length && function != null ; i++) {
                numbers[i] = function.apply(numbers[i]);
            }
        }

        while (!queue.isEmpty() ) {
            System.out.println(queue.poll());
        }
    }
}
