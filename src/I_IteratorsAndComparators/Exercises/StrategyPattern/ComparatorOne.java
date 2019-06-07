package I_IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

public class ComparatorOne implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {

        int comparePerson;

        // case-insensitive compare based on the first letter of their name
        if (o1.getName().length() == o2.getName().length()) {
            String charOne = "" + o1.getName().toUpperCase().charAt(0);
            String charTwo = "" + o2.getName().toUpperCase().charAt(0);

            comparePerson = charOne.compareTo(charTwo);
        }
        // based on the length of their name
        else {
            comparePerson = Integer.compare(o1.getName().length(), o2.getName().length());
        }

        return comparePerson;
    }
}
