//04. Count Real Numbers
package C_SetsAndMaps.Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> valuesWithOccurrences = new LinkedHashMap<>();

        for (double num : numbers) {
            valuesWithOccurrences.putIfAbsent(num, 0);
            valuesWithOccurrences.put(num, valuesWithOccurrences.get(num) + 1);
        }

        valuesWithOccurrences.forEach((key, val) -> System.out.printf("%.1f -> %d%n", key, val));
    }
}
