//07. Find The Real Queen
package B_MultidimensionalArrays.Lab;

import java.util.Scanner;

public class L07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // array of chars
        int size = 8;
        char[][] matrix = new char[size][size];
        // array of queens (row, col)
        int[][] queens = new int[size * size][2];
        int queenIndex = 0;

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {

                char token = line[col].charAt(0);

                matrix[row][col] = token;

                if (token == 'q') {
                    queens[queenIndex][0] = row;
                    queens[queenIndex][1] = col;
                    queenIndex++;
                }
            }
        }

        for (int i = 0; i < queenIndex ; i++) {
            int rowQueen = queens[i][0];
            int colQueen = queens[i][1];

            boolean isValid = true;

            for (int j = 0; j < queenIndex; j++) {
                if (j != i && hasChess(queens[j][0], queens[j][1], rowQueen, colQueen)) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                System.out.println(rowQueen + " " + colQueen);
            }
        }
    }

    private static boolean hasChess (int row, int col, int rowQueen, int colQueen) {
        // row || col || diagonal
        return (row == rowQueen || col == colQueen || Math.abs(row - rowQueen) == Math.abs(col - colQueen));
    }
}
