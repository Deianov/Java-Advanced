package I_IteratorsAndComparators.Exercises.StrategyPattern;

public class Person {
    private String name;
    private int age;

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
}
