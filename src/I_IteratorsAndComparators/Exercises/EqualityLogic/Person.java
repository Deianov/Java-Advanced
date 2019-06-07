package I_IteratorsAndComparators.Exercises.EqualityLogic;

public class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void print() {
        System.out.println(String.format("%s %d", this.name, this.age));
    }

    @Override
    public boolean equals(Object other) {
        if(other == null || !other.getClass().getName().endsWith("Person")) {
            return false;
        }
        return this.getName().equals(((Person)other).getName()) && this.age == ((Person)other).getAge();
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age.hashCode();
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.getName());

        if (result == 0) {
            result = Integer.compare(this.getAge(), o.getAge());
        }
        return result;
    }
}
