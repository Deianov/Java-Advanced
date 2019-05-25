//07. Fix Emails
package C_SetsAndMaps.Exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedHashMap;
import java.util.Scanner;

class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        LinkedHashMap<String, String> contacts = new LinkedHashMap<>();
        Deque<String> stack = new ArrayDeque<>();
        int count = 1;

        while (!"stop".equals(input = scanner.nextLine())) {

            if (count++ % 2 == 0) {

                String name = stack.pop();
                String test = input.toLowerCase();

                if (name != null && !test.endsWith(".us") && !test.endsWith(".uk") && !test.endsWith(".com")) {
                    contacts.put(name, input);
                }
            } else {
                stack.push(input);
            }
        }

        contacts.forEach((key, value) -> {
            System.out.printf("%s -> %s%n", key, value);
        });

    }
}
