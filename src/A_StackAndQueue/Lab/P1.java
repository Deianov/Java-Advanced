//1.Browser History
package A_StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        String current = "";

        ArrayDeque<String> browser = new ArrayDeque<>();

        while (!(line = scanner.nextLine()).equals("Home")) {

            if (line.equals("back")) {
                if (!browser.isEmpty()) {
                    current = browser.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                if(!current.equals("")) {browser.push(current);}
                current = line;
            }

            System.out.println(current);
        }
    }
}
