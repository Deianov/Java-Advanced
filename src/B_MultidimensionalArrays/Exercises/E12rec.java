// 12. The Matrix - recursion
package B_MultidimensionalArrays.Exercises;

import java.util.*;

public class E12rec {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr = scanner.nextLine().trim().replaceAll("[^a-z0-9]", "").toCharArray();

            for (int col = 0; col < cols ; col++) {
                matrix[row][col] = arr[col];
            }
        }

        char fillChar = scanner.nextLine().replaceAll("[^a-z0-9]", "").charAt(0);
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        char oldChar = matrix[startRow][startCol];

        fillCell(startRow, startCol, oldChar, fillChar, matrix);

        printMatrix(matrix);
    }

    private static void fillCell(int row, int col, char oldChar, char fillChar, char[][] matrix) {

        if (row < 0 || col < 0 || row == matrix.length || col == matrix[row].length || matrix[row][col] != oldChar) {
            return;
        }
        matrix[row][col] = fillChar;
        // up
        fillCell(row - 1, col, oldChar, fillChar, matrix);
        // down
        fillCell(row + 1, col, oldChar, fillChar, matrix);
        // left
        fillCell(row, col - 1, oldChar, fillChar, matrix);
        // right
        fillCell(row, col + 1, oldChar, fillChar, matrix);
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .forEach(e -> {
                    System.out.println(Arrays.toString(e).replaceAll("[\\[\\], ]", ""));
                });
    }
}