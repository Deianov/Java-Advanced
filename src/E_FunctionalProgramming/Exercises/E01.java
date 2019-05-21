//01. Consumer Print
package E_FunctionalProgramming.Exercises;

import java.util.Scanner;
import java.util.function.Consumer;

class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Consumer<String> printer = text -> System.out.println(text);

        for (String word : scanner.nextLine().split("\\s+")) {

            printer.accept(word);
        }
    }
}
