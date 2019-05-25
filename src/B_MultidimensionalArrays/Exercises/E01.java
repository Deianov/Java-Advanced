//01. Fill the Matrix
package B_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String type = input[1];

        if (type.equals("A")) printMatrix(matrixTypeA(size));
        if (type.equals("B")) printMatrix(matrixTypeB(size));
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static int[][] matrixTypeA(int size) {

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {

            for (int col = 0; col < size ; col++) {
                matrix[row][col] = row + 1 + (col * size);
            }
        }
        return matrix;
    }

    private static int[][] matrixTypeB(int size) {

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {

            for (int col = 0; col < size; col++) {

                if (col % 2 != 0) {
                    // column is odd
                    matrix[row][col] = (size * (1 + col)) - row ;
                } else {
                    // column is even
                    matrix[row][col] = (size * col) + 1 + row;
                }

            }
        }
        return matrix;
    }
}
