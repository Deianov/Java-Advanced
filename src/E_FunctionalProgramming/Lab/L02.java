//02. Sum Numbers
package E_FunctionalProgramming.Lab;

import java.util.Scanner;
import java.util.function.Function;

class L02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<String, Integer> parser = x->Integer.parseInt(x);

        int count = 0;
        int sum = 0;
        String input = scanner.nextLine();

        if (input.length() > 0) {
            for (String s : input.split(", ")) {
                count++;
                sum += parser.apply(s);
            }
        }

        System.out.printf("Count = %d%nSum = %d", count, sum);

    }
}
