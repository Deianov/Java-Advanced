//11. Threeuple
package H_Generics.Exercises.Threeuple;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] data;

        data = scanner.nextLine().split(" ");
        new Threeuple<>(data[0] + " " + data[1], data[2], data[3]).print();

        data = scanner.nextLine().split(" ");
        new Threeuple<>(data[0], Integer.parseInt(data[1]), data[2].equals("drunk")).print();

        data = scanner.nextLine().split(" ");
        new Threeuple<>(data[0], Double.parseDouble(data[1]), data[2]).print();
    }
}
