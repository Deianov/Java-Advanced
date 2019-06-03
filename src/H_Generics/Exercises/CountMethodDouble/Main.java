//06. Generic Count Method Double
package H_Generics.Exercises.CountMethodDouble;

import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();

        IntStream
                .range(0, Integer.parseInt(scanner.nextLine()))
                .forEach(e -> box.add(Double.parseDouble(scanner.nextLine())));

        System.out.println(box.countGreater(Double.parseDouble(scanner.nextLine())));
    }
}
