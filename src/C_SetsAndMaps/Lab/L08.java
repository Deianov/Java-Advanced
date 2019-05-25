//08. Academy Graduation
package C_SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

class L08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeMap<String, List<Double>> students = new TreeMap<>();

        while (n-- > 0) {
            String studentName = scanner.nextLine();
            students.putIfAbsent(studentName, new ArrayList<>());

            List<Double> score = Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).collect(Collectors.toList());
            students.get(studentName).addAll(score);
        }

        students.forEach((key, value) -> {
//            double average = value.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            System.out.printf("%s is graduated with ", key);
            double sum = 0.0;
            for (double d: value) {
                sum += d;
            }
            System.out.print(sum / value.size());
            System.out.print(System.lineSeparator());
        });
    }
}
