//06.Hot Potato
package A_StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();

        for (String child: children) {
            queue.offer(child);
        }

        while (queue.size() > 1) {
            for (int i = 1; i < n ; i++) {
                queue.add(queue.poll());
            }
            System.out.printf("Removed %s%n", queue.poll());
        }

        if (!queue.isEmpty()) {
            System.out.printf("Last is %s%n", queue.poll());
        }
    }
}
