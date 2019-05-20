//03. Count Uppercase Words
package E_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Predicate<String> isCapitalWord = s -> s.charAt(0) == s.toUpperCase().charAt(0);

        List<String> capitalWords = Arrays.stream(words)
                .filter(isCapitalWord)
                .collect(Collectors.toList());

        System.out.println(capitalWords.size());
        capitalWords.forEach(System.out::println);

    }
}
