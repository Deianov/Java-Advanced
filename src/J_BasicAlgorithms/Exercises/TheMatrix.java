//04. The Matrix
package J_BasicAlgorithms.Exercises;

import java.util.Arrays;
import java.util.Scanner;

class TheMatrix {

    private static char[][] matrix;
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();

        matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s", "").toCharArray();
        }

        char charTo = scanner.nextLine().charAt(0);

        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();

        char charFrom = matrix[startRow][startCol];

        replaceChars(startRow, startCol, charFrom, charTo);
        printMatrix(matrix);
    }

    private static void replaceChars(int row, int col, char from, char to) {

        if (!isValid(row, col))
            return;

        if (matrix[row][col] != from)
            return;

        matrix[row][col] = to;

        replaceChars(row + 1, col, from, to);
        replaceChars(row - 1, col, from, to);
        replaceChars(row, col + 1, from, to);
        replaceChars(row, col - 1, from, to);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\], ]", ""));
        }
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && col >= 0 && row < rows && col < cols;
    }
}
