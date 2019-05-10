//07. Crossfire
package B_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];
        int count = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = count++;
            }
        }

        while (!"Nuke it from orbit".equals(input = scanner.nextLine())) {

            // bomb
            int[] bomb = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int row = bomb[0];
            int col = bomb[1];
            int radius = bomb[2];

            // mark values for detonation in column
            for (int i = row - radius; i <= row + radius ; i++) {
                if(isInsideTheMatrix(i, col, matrix)) {
                    matrix[i][col] = 0;
                }
            }

            // mark values for detonation in row
            for (int i = col - radius; i <= col + radius ; i++) {
                if(isInsideTheMatrix(row, i, matrix)) {
                    matrix[row][i] = 0;
                }
            }

            boolean foundEmptyRows = false;

            // update columns
            for (int r = 0; r < matrix.length; r++) {

                if (IntStream.of(matrix[r]).anyMatch(e -> e == 0)) {

                    matrix[r] = Arrays.stream(matrix[r]).filter(value -> value > 0).toArray();
                    if(matrix[r].length == 0) foundEmptyRows = true;
                }
            }

            // delete empty rows
            if (foundEmptyRows) {
                matrix = Arrays.stream(matrix).filter(e -> e.length > 0).toArray(int[][]::new);
            }
        }

        printMatrix(matrix);
    }

    private static boolean isInsideTheMatrix(int row, int col, int[][] matrix) {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }

    private static void printMatrix(int[][] matrix) {
        Arrays.stream(matrix)
                .filter(e -> e.length > 0)
                .forEach(e -> {
                    System.out.println(Arrays.toString(e).replaceAll("[\\[\\],]", ""));
                });
    }
}
