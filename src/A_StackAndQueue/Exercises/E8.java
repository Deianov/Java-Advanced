//08.Simple Text Editor
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class E8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Deque<String> deque = new ArrayDeque<>();
        Deque<Deque<String>> temp = new ArrayDeque<>();
        temp.push(new ArrayDeque<>());

        while (n-- > 0) {
            String input = scanner.nextLine();
            char command = input.charAt(0);
            String argument = input.substring(1).trim();

            switch (command) {
                // add string
                case '1' :
                    deque.add(argument);
                    break;
                // erase last N characters
                case '2' :
                    eraseLastCharacters(deque, Integer.parseInt(argument));
                    break;
                // print character at index
                case '3' :
                    int index = Integer.valueOf(argument);
                    String dequeAsString = deque.toString();
                    if (index > -1 && index <= (dequeAsString.length() - 2)) {
                        System.out.println(dequeAsString.charAt(index));
                    }
                    break;
                // undo group
                case '4' :
                    if (!temp.isEmpty()) {
                        deque = temp.pop();
                        if (!temp.isEmpty()) {
                            deque = temp.peek();
                        }
                    }
                    break;
            }

            if (command == '1' || command == '2') {
                Deque<String> history = new ArrayDeque<>(deque);
                temp.push(history);
            }
        }
    }

    // Recursive erasing of last characters
    private static void eraseLastCharacters(Deque<String> deque, int count) {
        if (count > 0 && !deque.isEmpty()) {
            String element = deque.pollLast();
            int length = element.length();

            if (count < length) {
                deque.add(element.substring(0, length - count));
            } else if (count > length) {
                eraseLastCharacters(deque, count - length);
            }
        }
    }
}
