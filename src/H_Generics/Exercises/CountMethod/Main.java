//05. Generic Count Method String
package H_Generics.Exercises.CountMethod;

import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        IntStream
                .range(0, Integer.parseInt(scanner.nextLine()))
                .forEach(e -> box.add(scanner.nextLine()));

        System.out.println(box.countGreater(scanner.nextLine()));
    }
}
