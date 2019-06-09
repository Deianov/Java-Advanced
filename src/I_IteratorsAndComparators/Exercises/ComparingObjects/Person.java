package I_IteratorsAndComparators.Exercises.ComparingObjects;

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    String getName() { return name; }
    private int getAge() { return age; }
    private String getTown() { return town; }

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
