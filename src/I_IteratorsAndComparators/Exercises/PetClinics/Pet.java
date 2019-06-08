package I_IteratorsAndComparators.Exercises.PetClinics;

import java.util.HashMap;
import java.util.Map;

public class Pet {
    public static Map<String, Pet> collection = new HashMap<>();

    private String name;
    private int age;
    private String kind;

    public Pet(String name, int age, String kind) {
        this.name = name;
        this.age = age;
        this.kind = kind;

        Pet.collection.put(name, this);
    }

    @Override
    public String toString() {
        return String.format("%s %d %s", this.name, this.age, this.kind);
    }
}
