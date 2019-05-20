//4. Add VAT
package E_FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        UnaryOperator<Double> addVat = price -> price * 1.2;

        System.out.println("Prices with VAT:");
        Arrays.stream(input.split(", "))
                .mapToDouble(Double::parseDouble)
                .map(addVat::apply)
                .forEach(e -> System.out.println(String.format("%1$.2f", e)));
    }
}
