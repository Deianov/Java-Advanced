//01. Sort Even Numbers
package E_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // interface that accepts a parameter of type T and returns variable of type R.
        Function<String, Integer> parse = s -> Integer.parseInt(s);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(parse).collect(Collectors.toList());

        // lambda
        numbers.removeIf(number -> number % 2 != 0);

        // void interface
        Consumer<List<Integer>> printList = list ->  System.out.println(list.toString().replaceAll("[\\[\\]]", ""));
        printList.accept(numbers);

        // different ways:
        // lambda
        numbers.sort((a, b) -> a.compareTo(b));
        // method
        numbers.sort(Integer::compareTo);

        printList.accept(numbers);
    }
}
