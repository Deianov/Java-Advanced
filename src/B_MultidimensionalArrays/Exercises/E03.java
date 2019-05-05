//03. Diagonal Difference
package B_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {

            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int primarySum = Arrays.stream(matrixPrimaryDiagonal(matrix)).sum();
        int secondarySum = Arrays.stream(matrixSecondaryDiagonal(matrix)).sum();

        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static int[] matrixPrimaryDiagonal(int[][] matrix){
        int[] arr = new int[matrix.length];

        for (int row = 0; row < matrix.length; row++) {
            arr[row] = matrix[row][row];
        }

        return arr;
    }

    private static int[] matrixSecondaryDiagonal(int[][] matrix){
        int rows = matrix.length;
        int[] arr = new int[rows];


        for (int row = 0; row < rows; row++) {
            arr[row] = matrix[row][rows-1-row];
        }

        return arr;
    }
}
