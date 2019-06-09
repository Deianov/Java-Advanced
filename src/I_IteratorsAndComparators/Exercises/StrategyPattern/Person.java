package I_IteratorsAndComparators.Exercises.StrategyPattern;

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    void print() {
        System.out.println(String.format("%s %d", this.name, this.age));
    }
}
