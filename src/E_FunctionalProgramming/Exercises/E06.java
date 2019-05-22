//06. Predicate For Names
package E_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        Predicate<String> condition = str -> str.length() <= number;

        Arrays.stream(scanner.nextLine().split("\\s+")).filter(condition).forEach(System.out::println);
    }
}

