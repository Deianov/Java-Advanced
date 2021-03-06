//02. Car Info - Constructors
package F_DefiningClasses.Lab.B_Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesCount = Integer.parseInt(reader.readLine());

        while (linesCount-- > 0) {
            String[] data = reader.readLine().split("\\s+");
            Car car = null;

            if (data.length == 1) {
                car = new Car(data[0]);
            }

            if (data.length == 3) {
                car = new Car(data[0], data[1], Integer.parseInt(data[2]));
            }

            System.out.println(car != null ? car.getInfo() : "error");
        }
    }
}

class Car {
    private static final String undefinedValue = "unknown";
    private static final int undefinedValueInteger = -1;

    private String make;
    private String model;
    private int horsePower;

    Car(String make) {
        this.make = make;
        this.model = undefinedValue;
        this.horsePower = undefinedValueInteger;
    }

    Car(String make, String model, int horsePower) {
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    String getInfo() {
        return
        String.format(
                "The car is: %s %s - %d HP.",
                this.make, this.model, this.horsePower
        );
    }
}
