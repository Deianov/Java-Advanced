//06. A Miner Task
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        LinkedHashMap<String, Integer> resource = new LinkedHashMap<>();

        String type = null;
        int quantity;
        int count = 1;

        while (!"stop".equals(input = scanner.nextLine())) {

            if (count++ % 2 == 0) {
                if (type != null) {
                    quantity = Integer.parseInt(input);
                    resource.putIfAbsent(type, 0);
                    resource.put(type, resource.get(type) + quantity);
                }
            } else {
                type = input;
            }
        }

        resource.forEach((key, value) -> {
            System.out.printf("%s -> %d%n", key, value);
        });
    }
}
