// 04. Generic Swap Method Integer
package H_Generics.Exercises.SwapMethodInteger;

import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<Integer> box = new Box<>();

        IntStream
                .range(0, Integer.parseInt(scanner.nextLine()))
                .forEach(e -> box.add(Integer.parseInt(scanner.nextLine())));

        int indexA = scanner.nextInt();
        int indexB = scanner.nextInt();
        box.swap(indexA, indexB);

        System.out.println(box.toString());
    }
}
