//05. Filter by Age
package E_FunctionalProgramming.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

class L05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] data = scanner.nextLine().split(", ");
            people.put(data[0], Integer.parseInt(data[1]));
        }

        boolean condition = scanner.nextLine().equals("older");
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> filterByAge = limit -> condition == limit >= age;

        Consumer<Map.Entry<String, Integer>> printer = p -> {
          switch (format) {
              case "name" : System.out.printf("%s%n", p.getKey()); break;
              case "age" : System.out.printf("%d%n", p.getValue()); break;
              case "name age" : System.out.printf("%s - %d%n", p.getKey(), p.getValue()); break;
          }
        };

        printFilteredStudent(people, filterByAge, printer);
    }

    private static void printFilteredStudent(
            LinkedHashMap<String, Integer> people,
            Predicate<Integer> limitAge,
            Consumer<Map.Entry<String, Integer>> printer) {

        for (Map.Entry<String, Integer> person : people.entrySet()) {
            if (limitAge.test(person.getValue())) {
                printer.accept(person);
            }
        }
    }
}
