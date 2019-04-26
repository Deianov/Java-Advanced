//4.Matching Brackets
package A_StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        int index = 0;
        for (char ch : expression.toCharArray()) {
            if (ch == '(') {
                stack.push(index);
            } else if (ch == ')') {
                int startIndex = stack.pop();
                System.out.println(expression.substring(startIndex, index + 1));
            }
            index++;
        }
    }
}
