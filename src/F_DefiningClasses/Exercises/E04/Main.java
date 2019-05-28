//04. Raw Data
package F_DefiningClasses.Exercises.E04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0){
            String[] data = reader.readLine().split("\\s+");

            new Car(data[0],
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    data[4],
                    Double.parseDouble(data[5]),
                    Integer.parseInt(data[6]),
                    Double.parseDouble(data[7]),
                    Integer.parseInt(data[8]),
                    Double.parseDouble(data[9]),
                    Integer.parseInt(data[10]),
                    Double.parseDouble(data[11]),
                    Integer.parseInt(data[12])
            );
        }

        if (reader.readLine().equals("fragile")) {
            Car.cars.stream()
                    .filter(c -> c.getCargo().getCargoType().equals("fragile"))
                    .filter(v -> v.getTire().minPressure() < 1)
                    .forEach(Car::printModel);
        } else {
            Car.cars.stream()
                    .filter(c -> c.getCargo().getCargoType().equals("flamable"))
                    .filter(v -> v.getEngine().getEnginePower() > 250)
                    .forEach(Car::printModel);
        }
    }
}
