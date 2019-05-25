//01.Car Info
package F_DefiningClasses.Lab.A_Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int linesCount = Integer.parseInt(reader.readLine());

        while (linesCount-- > 0) {
            String[] data = reader.readLine().split("\\s+");

            Car car = new Car();

            car.setMake(data[0]);
            car.setModel(data[1]);
            car.setHorsePower(Integer.parseInt(data[2]));

            System.out.println(car.getInfo());
        }
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
