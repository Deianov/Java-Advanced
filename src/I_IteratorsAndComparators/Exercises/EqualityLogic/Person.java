package I_IteratorsAndComparators.Exercises.EqualityLogic;

class Person implements Comparable<Person> {
    private String name;
    private Integer age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }
    private int getAge() {
        return age;
    }

    void print() {
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
