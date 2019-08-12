//02. Space Station Establishment
package K_Exams.Exam23June2019;

import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    private static char[][] matrix;
    private static int playerRow = -1;
    private static int playerCol = -1;
    private static int starPower = 0;
    private static int blackHoleRow1 = -1;
    private static int blackHoleRow2 = -1;
    private static int blackHoleCol1 = -1;
    private static int blackHoleCol2 = -1;
    private static char blackHoleLetter = 'O';
    private static char playerLetter = 'S';
    private static char emptyLetter = '-';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());

        matrix = new char[rows][rows];

        for (int r = 0; r < rows; r++) {
            String input = scanner.nextLine().trim();
            matrix[r] = input.toCharArray();

            for (int c = 0; c < matrix[r].length; c++) {
                char letter = matrix[r][c];

                if (letter == blackHoleLetter){
                    if (isValid(blackHoleRow1, blackHoleCol1)){
                        blackHoleRow2 = r;
                        blackHoleCol2 = c;
                    } else {
                        blackHoleRow1 = r;
                        blackHoleCol1 = c;
                    }
                } else if (letter == playerLetter){
                    playerRow = r;
                    playerCol = c;
                }
            }
        }

        while (starPower < 50){
            if (!movePlayer(scanner.nextLine())){
                matrix[playerRow][playerCol] = emptyLetter;
                break;
            }
        }

        if (starPower >= 50){
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        } else {
            System.out.println("Bad news, the spaceship went to the void.");
        }
        System.out.println(String.format("Star power collected: %d", starPower));
        printMatrix();
    }

    private static boolean movePlayer(String direction){
        int row = playerRow;
        int col = playerCol;

        switch (direction.trim()){
            case "up" : row--; break;
            case "down" : row++; break;
            case "left" : col--; break;
            case "right" : col++; break;
            default: row = -1;
        }

        if (isValid(row, col)){
            char letter = matrix[row][col];
            matrix[playerRow][playerCol] = emptyLetter;

            if (letter == blackHoleLetter){
                matrix[row][col] = emptyLetter;

                if (blackHoleRow1 == row && blackHoleCol1 == col){
                    row = blackHoleRow2;
                    col = blackHoleCol2;
                }
                else if (blackHoleRow2 == row && blackHoleCol2 == col) {
                    row = blackHoleRow1;
                    col = blackHoleCol1;
                }

            } else if (letter != emptyLetter){
                starPower += Character.getNumericValue(letter);
            }
            playerRow = row;
            playerCol = col;
            matrix[playerRow][playerCol] = playerLetter;
            return true;
        }
        return false;
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
