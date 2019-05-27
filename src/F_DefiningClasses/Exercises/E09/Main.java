package F_DefiningClasses.Exercises.E09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        HashMap<String, Cat> cats = new HashMap<>();

        while (!"End".equals(line = reader.readLine())) {

            String[] data = line.split("\\s+");
            String breed = data[0];
            String name = data[1];
            double characteristic = Double.parseDouble(data[2]);

            switch (breed) {
                case StreetExtraordinaire.BREED:
                    cats.put(name, new StreetExtraordinaire(name, characteristic))
                    ;break;
                case Cymric.BREED:
                    cats.put(name, new Cymric(name, characteristic))
                    ;break;
                case Siamese.BREED:
                    cats.put(name, new Siamese(name, characteristic))
                    ;break;
            }
        }

        Cat cat = cats.get(reader.readLine());
        if (cat != null) {
            System.out.println(cat.toString());
        }
    }
}

abstract class Cat {
    private String name;

    Cat(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

class Siamese extends Cat {
    static final String BREED = "Siamese";
    private double earSize;

    Siamese(String name, double earSize) {
        super(name);
        this.earSize = earSize;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", Siamese.BREED, super.getName(), this.earSize);
    }
}

class Cymric extends Cat {
    static final String BREED = "Cymric";
    private double furLength;

    Cymric(String name, double furLength) {
        super(name);
        this.furLength = furLength;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", Cymric.BREED, super.getName(), this.furLength);
    }
}

class StreetExtraordinaire extends Cat {
    static final String BREED = "StreetExtraordinaire";
    private double decibelsOfMeows;

    StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", this.getClass().getSimpleName(), super.getName(), this.decibelsOfMeows);
    }
}