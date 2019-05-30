//05. Car Salesman
package F_DefiningClasses.Exercises.E05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {

            String[] engineData = reader.readLine().split("\\s+");
            String model = engineData[0];
            int power = Integer.parseInt(engineData[1]);

            switch (engineData.length) {
                case 2: new Engine(model, power);break;
                case 3:
                    try {
                        new Engine(model, power, Integer.parseInt(engineData[2]));
                    } catch (NumberFormatException e) {
                        new Engine(model, power, engineData[2]);
                    }
                    break;
                case 4: new Engine(model, power, Integer.parseInt(engineData[2]), engineData[3]);break;
            }
        }

        lines = Integer.parseInt(reader.readLine());
        while (lines-- > 0) {

            String[] carData = reader.readLine().split("\\s+");
            String model = carData[0];
            Engine engine = Engine.engines.get(carData[1]);

            if (engine != null) {

                switch (carData.length) {
                    case 2: new Car(model, engine); break;
                    case 3:
                        try {
                            new Car(model, engine, Integer.parseInt(carData[2]));
                        } catch (NumberFormatException e){
                            new Car(model, engine, carData[2]);
                        }
                        break;
                    case 4: new Car(model, engine, Integer.parseInt(carData[2]), carData[3]); break;
                }
            }
        }

        Car.cars.forEach(Car::print);
    }
}