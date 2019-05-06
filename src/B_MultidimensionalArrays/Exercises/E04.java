//04. Maximal Sum
package B_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        if (rows < 3 || cols < 3) return;

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int maxSum = Integer.MIN_VALUE;
        int maxSumRow = -1;
        int maxSumCol = -1;

        for (int row = 0; row < rows - 2; row++) {

            for (int col = 0; col < cols - 2; col++) {

                int sum = matrix[row][col] + matrix[row][col+1] + matrix[row][col+2];
                sum += matrix[row+1][col] + matrix[row+1][col+1] + matrix[row+1][col+2];
                sum += matrix[row+2][col] + matrix[row+2][col+1] + matrix[row+2][col+2];

                if (sum > maxSum) {
                    maxSum = sum;
                    maxSumRow = row;
                    maxSumCol = col;
                }
            }
        }

        if (maxSumRow > -1) {
            System.out.println("Sum = " + maxSum);
            for (int i = maxSumRow; i < maxSumRow + 3 ; i++) {
                System.out.println(matrix[i][maxSumCol] + " " + matrix[i][maxSumCol+1] + " " + matrix[i][maxSumCol+2]);
            }
        }
    }
}
