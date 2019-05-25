//08.Simple Text Editor
package A_StackAndQueue.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        StringBuffer text = new StringBuffer();
        Deque<StringBuffer> stack = new ArrayDeque<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0];
            String argument = data.length > 1 ? data[1] : "";

            switch (command) {
                // add string
                case "1" :
                    text.append(argument);
                    stack.push(new StringBuffer(text));
                    break;
                // erase last N characters
                case "2" :
                    int count = Integer.parseInt(argument);
                    int length = text.length();
                    text.setLength(count > length ? 0 : length - count);
                    stack.push(new StringBuffer(text));
                    break;
                // print character at index
                case "3" :
                    int index = Integer.valueOf(argument);
                    System.out.println(text.charAt(index - 1));
                    break;
                // undo group
                case "4" :
                    if (stack.size() > 0) {
                        stack.pop();
                        if (stack.size() > 0) {
                            text = stack.peek();
                        } else {
                            text.setLength(0);
                        }
                    }
                    break;
            }
        }
    }
}
