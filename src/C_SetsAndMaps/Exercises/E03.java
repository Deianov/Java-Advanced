//03. Periodic Table
package C_SetsAndMaps.Exercises;

import java.util.Scanner;
import java.util.TreeMap;

class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> elements = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String line = scanner.nextLine();

            for (String element : line.split("\\s+")) {

                if (elements.containsKey(element)) {
                    elements.put(element, elements.get(element) + 1);
                } else {
                    elements.put(element, 1);
                }
            }
        }

        elements.forEach((key, value) -> System.out.print(key + " "));
    }
}
