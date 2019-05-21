//06. Find Evens or Odds
package E_FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fromNumber = scanner.nextInt();
        int toNumber = scanner.nextInt();
        scanner.nextLine();
        String condition = scanner.nextLine();

        Predicate<Integer> accepter = number -> condition.equals("even") == (number % 2 == 0);
        Consumer<Integer> printer = number -> System.out.print(number + " ");

        for (int i = fromNumber; i <= toNumber ; i++) {

            filterAndPrint(i, accepter, printer);
        }
    }

    private static void filterAndPrint (int number, Predicate<Integer> accept, Consumer<Integer> print) {

        if (accept.test(number)) {
            print.accept(number);
        }
    }
}
