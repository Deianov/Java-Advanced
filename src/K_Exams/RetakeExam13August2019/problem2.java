package K_Exams.RetakeExam13August2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class problem2 {
    private static char[][] matrix;
    private static char emptyCharacter = '-';

    private static List<Character> types = Arrays.asList('C', 'N', 'M');
    private static List<Character> collected = new ArrayList<>();
    private static List<Character> stolen = new ArrayList<>();

    private static int playerRow = -1;
    private static int playerCol = -1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        matrix = new char[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s", "").toCharArray();
        }

        String input;

        while (!"Sunset".equals(input = scanner.nextLine())) {

            String[] data = input.split("\\s+");

            if (data.length > 1) {

                String command = data[0];
                playerRow = Integer.parseInt(data[1]);
                playerCol = Integer.parseInt(data[2]);

                if (!isValid(playerRow, playerCol)){
                    continue;
                }

                if (command.equals("Collect")) {
                    collectIfFound(playerRow, playerCol);

                } else if (command.equals("Steal")) {
                    stealIfFound(playerRow, playerCol);
                    String direction = data[3].trim();
                    movePlayer(direction);
                    movePlayer(direction);
                    movePlayer(direction);
                }
            }
        }
        printMatrix();
        String output = String.format("Collected seashells: %d", collected.size());
        if (collected.size() > 0) {
            output = String.format("%s -> %s",
                    output,
                    collected.toString().replaceAll("[\\[\\]]", "")
            );
        }
        System.out.println(output);
        System.out.printf("Stolen seashells: %d", stolen.size());
    }

    private static void collectIfFound(int row, int col) {
        char currentCharacter = matrix[row][col];

        if (types.contains(currentCharacter)) {
            collected.add(currentCharacter);
            matrix[row][col] = emptyCharacter;
        }
    }

    private static void stealIfFound(int row, int col) {
        char currentCharacter = matrix[row][col];

        if (types.contains(currentCharacter)) {
            stolen.add(currentCharacter);
            matrix[row][col] = emptyCharacter;
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
            playerRow = row;
            playerCol = col;
            stealIfFound(playerRow, playerCol);
        }
    }

    private static void printMatrix(){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]).replaceAll("[\\[\\],]", ""));
        }
    }

    private static boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[row].length;
    }
}
