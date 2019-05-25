//02.Basic Stack Operations
package A_StackAndQueue.Exercises;

import java.util.*;

class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] commands = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();
        int[] data = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < commands[0] ; i++) {
            stack.push(data[i]);
        }

        for (int i = 0; i < commands[1] ; i++) {
            if (!stack.isEmpty())
                stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (stack.stream().anyMatch(e -> e.equals(commands[2]))) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(stack));
        }
    }
}
