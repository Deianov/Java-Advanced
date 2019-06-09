//06. Strategy Pattern
package I_IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> treeSetOne = new TreeSet<>(new ComparatorOne());
        TreeSet<Person> treeSetTwo = new TreeSet<>(new ComparatorTwo());

        int lines = Integer.parseInt(scanner.nextLine());
        while (lines-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            Person person = new Person(data[0], Integer.parseInt(data[1]));
            treeSetOne.add(person);
            treeSetTwo.add(person);
        }

        treeSetOne.forEach(Person::print);
        treeSetTwo.forEach(Person::print);
    }
}
