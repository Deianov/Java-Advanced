package I_IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

class ComparatorTwo implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
