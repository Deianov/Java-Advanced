//04.Basic Queue Operations
package A_StackAndQueue.Exercises;

import java.util.*;

class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] command = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < command[0] ; i++) {
            queue.add(numbers[i]);
        }

        for (int i = 0; i < command[1] ; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.stream().anyMatch(e -> e.equals(command[2]))) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }
    }
}
