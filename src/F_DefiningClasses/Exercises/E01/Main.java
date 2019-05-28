//01. Opinion Poll
package F_DefiningClasses.Exercises.E01;

import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        IntStream
                .rangeClosed(1, Integer.parseInt(scanner.nextLine()))
                .boxed()
                .map(line -> scanner.nextLine().split("\\s+"))
                .map(data -> new Person(data[0], Integer.parseInt(data[1])))
                .filter(e -> e.getAge() > 30)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(Person::print);
    }
}

class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() { return age; }
    String getName() { return name; }

    void print() {
        System.out.println(String.format("%s - %d", this.name, this.age));
    }
}
