//08. Family Tree
package F_DefiningClasses.Exercises.E08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        String tempPerson = reader.readLine();

        Deque<String> relations = new ArrayDeque<>();

        while (!"End".equals(line = reader.readLine())) {

            String[] tokens = line.split("\\s-\\s");

            if (tokens.length == 2) {

                // Save relations in deque
                relations.offer(tokens[0]);
                relations.offer(tokens[1]);

            } else if (tokens.length == 1) {

                // Create person
                tokens = tokens[0].split("\\s+");
                String name = String.format("%s %s", tokens[0], tokens[1]);
                String birthday = tokens[2];

                new Person(name, birthday);
            }
        }
        // add relations
        while (!relations.isEmpty()) {
            Person parent = Person.getByNameOrBirthday(relations.poll());
            Person child = Person.getByNameOrBirthday(relations.poll());

            if (parent != null && child != null) {
                parent.addChild(child);
                child.addParent(parent);
            }
        }
        Person.printFamily(tempPerson);
    }
}

class Person {
    private static List<Person> persons = new ArrayList<>();

    private String personName;
    private String birthday;
    private List<Person> parents;
    private List<Person> children;

    Person(String name, String birthday) {
        this.personName = name;
        this.birthday = birthday;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();

        Person.persons.add(this);
    }

    void addParent (Person person) {
        if (!this.parents.contains(person)) {
            this.parents.add(person);
        }
    }

    void addChild (Person person) {
        if (!this.children.contains(person)) {
            this.children.add(person);
        }
    }

    static Person getByNameOrBirthday(String value) {
        if (value == null) {
            return null;
        }
        Stream<Person> stream = Person.persons.stream();

        if (Person.isPersonName(value)) {
            return stream.filter(p -> p.personName.equals(value)).findFirst().orElse(null);
        }
        if (Person.isDate(value)) {
            return stream.filter(p -> p.birthday.equals(value)).findFirst().orElse(null);
        }
        return null;
    }

    private static boolean isPersonName(String value) {
        return value.matches("[A-Z0-9][a-z0-9]+\\s[A-Z0-9][a-z0-9]+");
    }

    private static boolean isDate (String value) {
        return value.matches("[0-9]{1,2}/[0-9]{1,2}/[0-9]{2,4}");
    }

    private void printPerson() {
        System.out.println(String.format("%s %s", this.personName, this.birthday));
    }

    static void printFamily(String value){
        Person person = Person.getByNameOrBirthday(value);
        if (person != null) {
            person.printPerson();
            System.out.println("Parents:");
            person.parents.forEach(Person::printPerson);
            System.out.println("Children:");
            person.children.forEach(Person::printPerson);
        }
    }
}
