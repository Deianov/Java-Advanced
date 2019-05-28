package F_DefiningClasses.Exercises.E03;

import java.util.LinkedHashMap;

class Parking {
    private static LinkedHashMap<String, Car> cars = new LinkedHashMap<>();

    static void init() {
        Parking.cars = new LinkedHashMap<>();
    }

    static void addCar(Car car) {
        Parking.cars.put(car.getModel(), car);
    }

    static Car getCar(String model) {
        return cars.get(model);
    }

    static void print() {
        Parking.cars.values().forEach(Car::print);
    }
}
