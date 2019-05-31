//07. Google
package F_DefiningClasses.Exercises.E07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Person person;

        while (!"End".equals(line = reader.readLine())) {

            String[] data = line.split("\\s+");
            String personName = data[0];
            String objectName = data[1];

            person = Person.persons.get(personName);

            if (person == null) {
                person = new Person(personName);
            }

            switch (objectName) {
                case "company":
                    person.setCompany(new Company(data[2], data[3], Double.parseDouble(data[4])));
                    break;
                case "pokemon":
                    person.addPokemon(data[2], data[3]);
                    break;
                case "parents":
                    person.addParent(data[2], data[3]);
                    break;
                case "children":
                    person.addChild(data[2], data[3]);
                    break;
                case "car":
                    person.setCar(new Car(data[2], Integer.parseInt(data[3])));
                    break;
            }
        }

        Person.persons.get(reader.readLine()).printInfo();
    }
}

class Person {
    static HashMap<String, Person> persons = new HashMap<>();

    private String personName;
    private Company company = null;
    private Car car = null;
    private List<Parent> parents;
    private List<Child> children;
    private List<Pokemon> pokemons;

    Person(String personName) {
        this.personName = personName;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();

        Person.persons.put(personName, this);
    }

    void setCompany(Company company) { this.company = company; }
    void setCar(Car car) { this.car = car; }

    void addParent(String name, String birthday) {
        this.parents.add(new Parent(name, birthday));
    }
    void addChild (String name, String birthday) {
        this.children.add(new Child(name, birthday));
    }
    void addPokemon (String name, String type) {
        this.pokemons.add(new Pokemon(name, type));
    }

    void printInfo() {
        System.out.print(String.format("%s%nCompany:%n", this.personName));
        System.out.print(this.company == null ? "" : this.company.toString());
        System.out.print("Car:\n");
        System.out.print(this.car == null ? "" : this.car.toString());
        System.out.print("Pokemon:\n");
        this.pokemons.forEach(e -> System.out.print(e.toString()));
        System.out.print("Parents:\n");
        this.parents.forEach(e -> System.out.print(e.toString()));
        System.out.print("Children:\n");
        this.children.forEach(e -> System.out.print(e.toString()));
    }
}

class Company {
    private String name;
    private String department;
    private double salary;

    Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format("%s %s %.2f%n", this.name, this.department, this.salary);
    }
}

class Pokemon {
    private String name;
    private String type;

    Pokemon(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString (){
        return String.format("%s %s%n", this.name, this.type);
    }
}

class Parent {
    private String name;
    private String birthday;

    Parent(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString (){
        return String.format("%s %s%n", this.name, this.birthday);
    }
}

class Child {
    private String name;
    private String birthday;

    Child(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString (){
        return String.format("%s %s%n", this.name, this.birthday);
    }
}

class Car {
    private String model;
    private int speed;

    Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString (){
        return String.format("%s %d%n", this.model, this.speed);
    }
}


