//11. Reverse Matrix Diagonals
package B_MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        for (int row = rows - 1; row > rows - 2; row--) {

            for (int col = cols - 1; col >= 0 ; col--) {

                List<Integer> diagonal = new ArrayList<>();

                for (int i = 0; i < rows ; i++) {

                    int currentRow = row - i;
                    int currentCol = col + i;

                    if (isValid(currentRow, currentCol, matrix)) {
                        diagonal.add(matrix[currentRow][currentCol]);
                    }
                }
                print(diagonal);
            }
        }

        for (int row = rows - 2; row >= 0 ; row--) {

            List<Integer> diagonal = new ArrayList<>();
            int col = 0;

            for (int i = 0; i < cols; i++) {

                int currentRow = row - i;
                int currentCol = col + i;

                if (isValid(currentRow, currentCol, matrix)) {
                    diagonal.add(matrix[currentRow][currentCol]);
                }
            }
            print(diagonal);
        }
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        return  row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void print(List<Integer> diagonal) {
        System.out.println(diagonal.toString().replaceAll("[\\[\\],]", ""));
    }
}
