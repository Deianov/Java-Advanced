//10. Poisonous Plants
package A_StackAndQueue.Exercises;

import java.util.*;

class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        int[] plants = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int length = plants.length;
        int[] days = new int[length];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        for (int i = 1; i < length ; i++) {
            int maxDays = 0;

            while (stack.size() > 0 && plants[stack.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[stack.pop()]);
            }

            if (stack.size() > 0) {
                days[i] = maxDays + 1;
            }

            stack.push(i);
        }

        System.out.println(Arrays.stream(days).max().getAsInt());
    }
}
