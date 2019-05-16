//05. Phonebook
package C_SetsAndMaps.Exercises;

import java.util.HashMap;
import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        HashMap<String, String> phonebook = new HashMap<>();

        while (!"search".equals(input = scanner.nextLine())) {
            String[] data = input.split("-");

            String name = data[0];
            String phone = data.length > 1 ? data[1] : null;

            phonebook.put(name, phone == null ? "" : phone);
        }

        while (!"stop".equals(input = scanner.nextLine())) {

            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
