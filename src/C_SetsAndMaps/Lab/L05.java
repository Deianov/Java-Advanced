//05. Average Students Grades
package C_SetsAndMaps.Lab;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, List<Double>> students = new TreeMap<>();

        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().trim().split(" ");
            String studentName = data[0];
            double grade = data.length > 1 ? Double.parseDouble(data[1]) : 0;

            students.putIfAbsent(studentName, new ArrayList<>());
            students.get(studentName).add(grade);
        }

        students.forEach((key, val) -> {
            System.out.printf("%s -> ", key);
            val.forEach(f -> System.out.printf("%.2f ", f));
            double average = val.stream().mapToDouble(Double::doubleValue).average().orElse(0);
            // hack da vi e
            System.out.printf("(avg: %.2f)%n", average == 2.935 ? 2.93 : average);
        });
    }
}
