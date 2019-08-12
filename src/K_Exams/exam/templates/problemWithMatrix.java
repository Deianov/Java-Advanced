package K_Exams.exam.templates;

import java.util.Arrays;
import java.util.Scanner;

public class problemWithMatrix {
    private static char[][] matrix;
    private static char emptyCharacter = '-';

    private static char playerCharacter = '1';
    private static int playerRow = -1;
    private static int playerCol = -1;

    private static char firstCharacter = '1';
    private static int firstRow = -1;
    private static int firstCol = -1;

    private static char secondCharacter = '1';
    private static int secondRow = -1;
    private static int secondCol = -1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = rows;

        matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            matrix[row] = scanner.nextLine().trim().toCharArray();

            for (int col = 0; col < matrix[row].length; col++) {

                char currentCharacter = matrix[row][col];

                if (currentCharacter == firstCharacter) {
                    firstRow = row;
                    firstCol = col;

                } else if (currentCharacter == secondCharacter) {
                    secondRow = row;
                    secondCol = col;
                } else if (currentCharacter == playerCharacter) {
                    playerRow = row;
                    playerCol = col;
                }

            }
        }

    }

    private static void movePlayer(String direction){
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
