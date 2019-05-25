//08. Wrong Measurements
package B_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

class L08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows ; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        // values should be replaced with the sum of the nearest elements in the four directions up, down, left and right
        int wrongValue = matrix[scanner.nextInt()][scanner.nextInt()];

        int cols = matrix[0].length;
        int[][] output = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                int value = matrix[row][col];

                // replace with sum of the nearest elements
                if (value == wrongValue) {
                    value = 0;
                    // up
                    if (row - 1 >= 0 && matrix[row-1][col] != wrongValue) {
                        value += matrix[row-1][col];
                    }
                    // down
                    if (row + 1 < rows && matrix[row+1][col] != wrongValue) {
                        value += matrix[row+1][col];
                    }
                    // left
                    if (col - 1 >= 0 && matrix[row][col-1] != wrongValue) {
                        value += matrix[row][col-1];
                    }
                    // right
                    if (col + 1 < cols && matrix[row][col+1] != wrongValue) {
                        value += matrix[row][col+1];
                    }
                }

                output[row][col] = value;
            }
        }

        for (int row = 0; row < rows; row++) {
            System.out.println(Arrays.toString(output[row]).replaceAll("[\\[\\],]", ""));
        }
    }
}
