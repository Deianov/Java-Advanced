//03. Speed Racing
package F_DefiningClasses.Exercises.E03;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        Parking.init();

        while (lines-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            Parking.addCar( new Car(data[0], Double.parseDouble(data[1]), Double.parseDouble(data[2])));
        }

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] data = line.split("\\s+");

            if (data[0].equals("Drive")) {
                Parking.getCar(data[1]).drive(Integer.parseInt(data[2]));
            }
        }
        Parking.print();
    }
}
