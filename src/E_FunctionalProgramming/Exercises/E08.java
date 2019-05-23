//08. Custom Comparator
package E_FunctionalProgramming.Exercises;

import java.util.*;

class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Comparator<Integer> comparatorEvanOdd = (x, y) -> {
            if ((x * x) % 2 == 0 && (y * y) % 2 != 0) {
                return -1;
            } else if ((x * x) % 2 != 0 && (y * y) % 2 == 0) {
                return 1;
            } else {
                return Integer.compare(x, y);
            }
        };

        Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .map(Integer::valueOf)
                .sorted(comparatorEvanOdd)
                .forEach(e -> System.out.print(e + " "));
    }
}
