//02. Knights of Honor
package E_FunctionalProgramming.Exercises;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String prefix = "Sir ";

        Function<String, String> appendPrefix = text -> prefix + text;
        Consumer<String> printer = text -> System.out.println(text);

        for (String text : scanner.nextLine().split("\\s+")) {

            printer.accept(appendPrefix.apply(text));
        }
    }
}
