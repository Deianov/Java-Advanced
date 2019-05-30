package F_DefiningClasses.Exercises.E05;

import java.util.ArrayList;
import java.util.List;

class Car extends Default {
    static List<Car> cars = new ArrayList<>();

    private String model;
    private Engine engine;
    private Integer weight = null;
    private String color = null;

    Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;

        Car.cars.add(this);
    }

    Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;
    }

    Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    Car(String model, Engine engine, Integer weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    void print() {
        System.out.print(String.format("%s:%n", this.model));
        System.out.print(this.engine.toString());
        System.out.print(String.format("Weight: %s%nColor: %s%n",
                this.weight == null ? UNDEFINED_VALUE : this.weight + "",
                this.color == null ? UNDEFINED_VALUE : this.color)
        );
    }
}
