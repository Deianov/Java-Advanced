//01. Unique Usernames
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> names = new LinkedHashSet<>();

        while (n-- > 0) {
            names.add(scanner.nextLine());
        }

        names.forEach(System.out::println);
    }
}
