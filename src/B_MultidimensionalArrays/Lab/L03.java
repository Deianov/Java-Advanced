//03. Intersection of Two Matrices
package B_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class L03 {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrixChar(rows, cols);
        char[][] secondMatrix = readMatrixChar(rows, cols);

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]) {
                    System.out.print(firstMatrix[row][col] + " ");
                } else {
                    System.out.print("* ");
                }
            }

            System.out.print(System.lineSeparator());
        }
    }

    private static char[][] readMatrixChar(int rows, int cols) {

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s");

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = line[col].charAt(0);
            }
        }

        return matrix;
    }
}
