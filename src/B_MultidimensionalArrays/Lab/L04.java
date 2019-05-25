//04. Sum Matrix Elements
package B_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        for (int row = 0; row < rows; row++) {
            sum += Arrays.stream(matrix[row]).sum();
        }

        System.out.printf("%d%n%d%n%d",rows, cols, sum);
    }
}
