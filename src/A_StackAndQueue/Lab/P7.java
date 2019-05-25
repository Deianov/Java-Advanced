//07.Math Potato
package A_StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();

        for (String child: children) {
            queue.offer(child);
        }

        int count = 0;

        while (queue.size() > 1) {

            for (int i = 1; i < n ; i++) {
                queue.add(queue.poll());
            }

            if (!isPrime(++count)) {
                System.out.printf("Removed %s%n", queue.poll());
            } else {
                System.out.printf("Prime %s%n", queue.peek());
            }
        }

        if (!queue.isEmpty()) {
            System.out.printf("Last is %s%n", queue.poll());
        }
    }

    private static boolean isPrime(int n) {

        if (n == 2) {
            return true;
        }

        if (n < 2 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
