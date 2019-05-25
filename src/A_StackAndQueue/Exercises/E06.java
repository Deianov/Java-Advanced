//06.Balanced Parentheses
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Deque<Character> chars = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            chars.add(c);
        }

        Deque<Character> temp = new ArrayDeque<>();
        Character a = null;
        Character b = null;

        while (!chars.isEmpty()) {

            int lastSize = chars.size();

            while (!chars.isEmpty()) {
                a = chars.poll();
                b = chars.peek();
                if ((a == '(' && b == ')') || (a == '[' && b == ']') || (a == '{' && b == '}')) {
                    chars.poll();
                } else {
                    temp.offer(a);
                }
            }

            while (!temp.isEmpty()) {
                chars.add(temp.pop());
            }

            if (chars.size() == lastSize) {
                break;
            }
        }

        System.out.println(chars.isEmpty() ? "YES" : "NO");
    }
}
