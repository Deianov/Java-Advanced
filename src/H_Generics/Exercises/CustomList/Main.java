// 07. Custom List
// 08. Custom List Sorter
// 09. Custom List Iterator
package H_Generics.Exercises.CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        CustomList<String> customList = new CustomList<String>();

        while (!"END".equals(line = scanner.nextLine())) {

            String[] commandTokens = line.split("\\s+");

            switch (commandTokens[0]) {
                case "Add":
                    customList.add(commandTokens[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(commandTokens[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(commandTokens[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(commandTokens[1]), Integer.parseInt(commandTokens[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(commandTokens[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Sort":
                    // 08. Custom List Sorter
                    customList.sort();
                    break;
                case "Print":
                    // 09. Custom List Iterator
                    // Since customList is an instance of Iterable, then we can use it on a foreach loop.
                    for (String item : customList) {
                        System.out.println(item);
                    }
                    break;
            }
        }
    }
}
