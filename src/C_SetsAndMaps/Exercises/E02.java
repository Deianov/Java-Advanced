//02. Sets of Elements
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        LinkedHashSet<Integer> firstNumbers = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondNumbers = new LinkedHashSet<>();

        while (n-- > 0) {
            firstNumbers.add(scanner.nextInt());
            scanner.nextLine();
        }

        while (m-- > 0) {
            secondNumbers.add(scanner.nextInt());
            scanner.nextLine();
        }

        firstNumbers.retainAll(secondNumbers);
        firstNumbers.forEach(e -> System.out.print(e + " "));
    }
}
