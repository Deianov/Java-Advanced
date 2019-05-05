//02. Matrix of Palindromes
package B_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        String[][] matrix = new String[rows][cols];

        StringBuilder stringBuilder = new StringBuilder("abc");

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                stringBuilder.setCharAt(0,(char)(97 + row));
                stringBuilder.setCharAt(1,(char)(97 + row + col));
                stringBuilder.setCharAt(2,(char)(97 + row));

                matrix[row][col] = stringBuilder.toString();
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\],]", ""));
        }
    }
}
