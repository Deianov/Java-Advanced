//03. Count Uppercase Words
package E_FunctionalProgramming.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new Scanner(System.in).nextLine());

        Predicate<String> isUppercase = s -> s.charAt(0) == s.toUpperCase().charAt(0);
        List<String> words = new ArrayList<>();

        while (scanner.hasNext()) {

            String text = scanner.next();
            if (isUppercase.test(text)) words.add(text);
        }

        System.out.println(words.size());
        words.forEach(System.out::println);
    }
}
