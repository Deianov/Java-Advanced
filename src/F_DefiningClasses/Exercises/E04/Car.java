package F_DefiningClasses.Exercises.E04;

import java.util.ArrayList;
import java.util.List;

class Car {
    static List<Car> cars = new ArrayList<>();

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    Car(String model,
               int engineSpeed,
               int enginePower,
               int cargoWeight,
               String cargoType,
               double tire1Pressure,
               int tire1Age,
               double tire2Pressure,
               int tire2Age,
               double tire3Pressure,
               int tire3Age,
               double tire4Pressure,
               int tire4Age
    ) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoWeight, cargoType);
        this.tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);

        cars.add(this);
    }

    Engine getEngine() { return engine; }
    Cargo getCargo() { return cargo; }
    Tire getTire() { return tire; }

    void printModel() { System.out.println(this.model); }
}
