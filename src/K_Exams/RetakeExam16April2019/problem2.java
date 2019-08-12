//02. Helen's Abduction
package K_Exams.RetakeExam16April2019;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    private static char playerCharacter = 'P';
    private static char enemyCharacter = 'S';
    private static char helenCharacter = 'H';
    private static char emptyCharacter = '-';
    private static char[][] matrix;
    private static int energy;
    private static int helens = 0;
    private static int playerRow = -1;
    private static int playerCol = -1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        energy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][rows];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().trim().toCharArray();

            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == helenCharacter) {
                    helens++;
                } else if (matrix[row][col] == playerCharacter){
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

    }

    private static void playerMove(String direction){
        int row = playerRow;
        int col = playerCol;

        switch (direction){
            case "up" : row--; break;
            case "down" : row++; break;
            case "left" : col--; break;
            case "right" : col++; break;
            default: row = -1;
        }

        if (isValid(row, col)){

        }
    }



    private static void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\],\\s]", ""));
        }
    }

    private static boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }
}
