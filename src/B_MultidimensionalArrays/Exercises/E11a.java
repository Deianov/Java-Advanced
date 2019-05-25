////11. Reverse Matrix Diagonals
package B_MultidimensionalArrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class E11a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        for (int col = cols - 1; col >= 0 ; col--) {
            print(getDiagonal(rows - 1, col, matrix));
        }

        for (int row = rows - 2; row >= 0 ; row--) {
            print(getDiagonal(row, 0, matrix));
        }
    }

    private static List<Integer> getDiagonal(int row, int col, int[][] matrix) {
        List<Integer> result = new ArrayList<>(matrix.length);

        while (isValid(row, col, matrix)) result.add(matrix[row--][col++]);

        return result;
    }

    private static boolean isValid(int row, int col, int[][] matrix) {
        return  row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void print(List<Integer> diagonal) {
        System.out.println(diagonal.toString().replaceAll("[\\[\\],]", ""));
    }
}