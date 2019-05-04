//05. Maximum Sum of 2x2 Submatrix
package B_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class L05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(line[0]);
        int cols = Integer.parseInt(line[1]);

        int[][] matrix = new int[rows][cols];
        int[] subMatrixMaxSum = new int[4];
        int maxSum = Integer.MIN_VALUE;

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        if (rows < 2 || cols < 2) return;

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {

                int a = matrix[row][col];
                int b = matrix[row][col+1];
                int c = matrix[row+1][col];
                int d = matrix[row+1][col+1];

                if (a + b + c + d > maxSum) {
                    subMatrixMaxSum[0] = a;
                    subMatrixMaxSum[1] = b;
                    subMatrixMaxSum[2] = c;
                    subMatrixMaxSum[3] = d;
                    maxSum = a + b + c + d;
                }
            }
        }

        if (maxSum > Integer.MIN_VALUE) {
            System.out.printf("%d %d%n%d %d%n%d",
                    subMatrixMaxSum[0],
                    subMatrixMaxSum[1],
                    subMatrixMaxSum[2],
                    subMatrixMaxSum[3],
                    Arrays.stream(subMatrixMaxSum).sum());
        }
    }
}
