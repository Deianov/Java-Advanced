//05.Printer Queue
package A_StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class P5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Deque<String> printerQueue = new ArrayDeque<>();

        while (!(input = scanner.nextLine()).equals("print")) {
            if (input.equals("cancel")) {
                if (printerQueue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
                printerQueue.offer(input);
            }
        }

        while (!printerQueue.isEmpty()) {
            System.out.println(printerQueue.poll());
        }
    }
}
