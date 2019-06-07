//07. Equality Logic
package I_IteratorsAndComparators.Exercises.EqualityLogic;

import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> treeSet = new TreeSet<>();
        HashSet<Person> hashSet = new HashSet<>();

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            Person person = new Person(data[0], Integer.parseInt(data[1]));
            treeSet.add(person);
            hashSet.add(person);
        }

        System.out.println(treeSet.size());
        System.out.println(hashSet.size());
    }
}
