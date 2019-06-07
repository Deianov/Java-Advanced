package I_IteratorsAndComparators.Exercises.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getTown() { return town; }

    @Override
    public int compareTo(Person o) {

        int comparePerson = this.name.compareTo(o.getName());

        if (comparePerson == 0) {
            comparePerson = Integer.compare(this.age, o.getAge());
        }

        if (comparePerson == 0) {
            comparePerson = this.town.compareTo(o.getTown());
        }
        return comparePerson;
    }
}
