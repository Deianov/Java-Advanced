//06. Print Diagonals of Square Matrix
package B_MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        for (int row = 0; row < size; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }

        int col = 0;
        for (int row = 0; row < size; row++) {
            System.out.print(matrix[row][col++] + " ");
        }
        System.out.print(System.lineSeparator());

        col = 0;
        for (int row = size - 1; row >= 0 ; row--) {
            System.out.print(matrix[row][col++] + " ");
        }
    }
}
