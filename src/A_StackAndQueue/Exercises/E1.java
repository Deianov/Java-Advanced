//1.Reverse Numbers with a Stack
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(e -> stack.push(e));

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
