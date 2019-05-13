//01. Parking Lot
package C_SetsAndMaps.Lab;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class L01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Set<String> parking = new HashSet<>();

        while (!"END".equals(input = scanner.nextLine())) {
            String[] data = input.split(", ");
            if ("IN".equals(data[0])) {
                parking.add(data[1]);
            } else if ("OUT".equals(data[0])) {
                parking.remove(data[1]);
            }
        }

        if (parking.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            parking.forEach(System.out::println);
        }
    }
}
