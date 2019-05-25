//03.Maximum Element
package A_StackAndQueue.Exercises;

import java.util.*;

class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        while (n-- > 0) {

            int[] command = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::valueOf).toArray();

            switch (command[0]) {
                case 1:
                    stack.push(command[1]);
                    break;
                case 2:
                    stack.poll();
                    break;
                case 3:
                    int maxValue = stack.isEmpty() ? 0 : Collections.max(stack);
                    System.out.println(maxValue);
                    break;
            }
        }
    }
}
