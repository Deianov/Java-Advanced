//09. List Of Predicates
package E_FunctionalProgramming.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int range = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        Predicate<Number> isDivisible = number -> {
            for (int d : number.getDivisors()) {
                if (number.getNumber() % d != 0) {
                    return false;
                }
            }
            return true;
        };

        for (int i = 1; i <= range ; i++) {

            Number number = new Number(i, numbers);

            if (isDivisible.test(number)) {
                System.out.print(i + " ");
            }
        }

    }
}

class Number {
    private int number;
    private int[] divisors;

    Number(int number, int[] divisors) {
        this.number = number;
        this.divisors = divisors;
    }

    int getNumber() { return number; }
    int[] getDivisors() { return divisors; }
}
