//01.Car Info
package F_DefiningClasses.Lab.A_Car;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int linesCount = Integer.parseInt(scanner.nextLine());

        IntStream
                .rangeClosed(1, linesCount)
                .boxed() // IntStream -> Stream
                .map(n -> scanner.nextLine().split(" "))
                .map(data -> {
                    Car car = new Car();
                    car.setMake(data[0]);
                    car.setModel(data[1]);
                    car.setHorsePower(Integer.parseInt(data[2]));
                    return car;
                })
                .forEach(car -> System.out.println(car.getInfo()));
    }
}

class Car {
    private String make;
    private String model;
    private int horsePower;

    void setMake(String make) { this.make = make; }
    void setModel(String model) { this.model = model; }
    void setHorsePower(int horsePower) { this.horsePower = horsePower; }

    String getInfo() {
        return
                String.format(
                        "The car is: %s %s - %d HP.",
                        this.make, this.model, this.horsePower
                );
    }
}
