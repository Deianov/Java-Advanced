//02. Recursive Factorial
package J_BasicAlgorithms.Lab;

import java.util.Scanner;

class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(factorial(Integer.parseInt(scanner.nextLine())));
    }

    private static int factorial(int number) {

        if (number <= 0) return 1;

        return number * factorial(number - 1);
    }
}
