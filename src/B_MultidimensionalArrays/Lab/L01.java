//01. Compare Matrices
package B_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L01 {
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        int[][] firstMatrix = readMatrixInt();
        int[][] secondMatrix = readMatrixInt();

        System.out.println(compareMatricesInt(firstMatrix, secondMatrix) ? "equal" : "not equal");
    }

    // 2 3      (rows cols)
    // 1 2 3
    // 2 1 3
    private static int[][] readMatrixInt() {
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows ; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        return matrix;
    }

    private static boolean compareMatricesInt(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length){
            return false;
        }

        for (int row = 0; row < firstMatrix.length ; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length){
                return false;
            }

            for (int col = 0; col < firstMatrix[row].length ; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
