//08.Browser History Upgrade
package A_StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class P8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Deque<String> browser = new ArrayDeque<>();
        Deque<String> forward = new ArrayDeque<>();

        while (!(input = scanner.nextLine()).equals("Home")) {
            if (input.equals("back")) {
                if (browser.size() > 1) {
                    forward.push(browser.poll());
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else if (input.equals("forward")) {
                if (!forward.isEmpty()) {
                    browser.push(forward.poll());
                } else {
                    System.out.println("no next URLs");
                    continue;
                }
            } else {
                browser.push(input);
                if (!forward.isEmpty()) forward.clear();
            }

            System.out.println(browser.isEmpty() ? "" : browser.peek());
        }
    }
}
