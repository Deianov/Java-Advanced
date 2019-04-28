//07.Recursive Fibonacci from 0 (1, 1, 2, 3, 5, 8, 13, 21, 34… )
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E7 {

    private static Deque<Long> numbers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        numbers = new ArrayDeque<>();
        numbers.push(1l);
        numbers.push(1l);
        if (n < 2) {
            System.out.println(1);
            return;
        }

        long result = recursiveFibonacci(n);
        System.out.println(result);
    }

    private static long recursiveFibonacci(int n) {

        if (n > 1) {
            long a = numbers.pop();
            long b = numbers.peek();
            numbers.push(a);
            numbers.push(a + b);
            recursiveFibonacci(n - 1);
        }

        return numbers.peek();
    }
}
