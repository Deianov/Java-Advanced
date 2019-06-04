//10. Tuple
package H_Generics.Exercises.Tuple;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");
        Tuple<String, String> tuple1 = new Tuple<String, String>(data[0] + " " + data[1], data[2]);
        System.out.println(tuple1.toString());

        data = scanner.nextLine().split("\\s+");
        Tuple<String, Integer> tuple2 = new Tuple<String, Integer>(data[0], Integer.parseInt(data[1]));
        System.out.println(tuple2.toString());

        data = scanner.nextLine().split("\\s+");
        Tuple<Integer, Double> tuple3 = new Tuple<Integer, Double>(Integer.parseInt(data[0]), Double.parseDouble(data[1]));
        System.out.println(tuple3.toString());
    }
}
