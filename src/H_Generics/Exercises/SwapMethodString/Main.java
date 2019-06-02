// 03. Generic Swap Method String
package H_Generics.Exercises.SwapMethodString;

import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        IntStream
                .range(0, Integer.parseInt(scanner.nextLine()))
                .forEach(e -> box.add(scanner.nextLine()));

        int indexA = scanner.nextInt();
        int indexB = scanner.nextInt();
        box.swap(indexA, indexB);

        System.out.println(box.toString());
    }
}
