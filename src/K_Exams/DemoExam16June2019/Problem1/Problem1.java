// (Demo) Java Advanced Exam - 16 June 2019
// Problem 1 - 01. The Garden
package K_Exams.DemoExam16June2019.Problem1;

import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        scanner.nextLine();

        char[][] garden = new char[rows][];

        for (int row = 0; row < rows; row++) {
            String vegetables = scanner.nextLine().toUpperCase().trim().replaceAll("[^CPL]", "");
            garden[row] = vegetables.toCharArray();
        }

        String line;
        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmed = 0;

        while (!"End of Harvest".equals(line = scanner.nextLine())) {

            String[] commandTokens = line.split("\\s+");

            String command = commandTokens[0];
            int row = commandTokens.length > 1 ? Integer.parseInt(commandTokens[1]) : -1;
            int col = commandTokens.length > 2 ? Integer.parseInt(commandTokens[2]) : -1;

            switch (command) {
                case "Harvest":
                    if (isValid(garden, row, col)) {
                        switch (garden[row][col]) {
                            case 'C':
                                carrots++;
                                garden[row][col] = ' ';
                                break;
                            case 'P':
                                potatoes++;
                                garden[row][col] = ' ';
                                break;
                            case 'L':
                                lettuce++;
                                garden[row][col] = ' ';
                                break;
                        }
                    }
                    break;
                case "Mole":
                    if (isValid(garden, row, col)) {
                        harmed += mole(garden, row, col, commandTokens[3]);
                    }
                    break;
            }
        }
        printMatrix(garden);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmed);
    }

    private static int mole(char[][] garden, int row, int col, String direction) {

        int harmed = 0;

        switch (direction.toLowerCase()) {
            case "up":
                for (int r = row; r >= 0; r -= 2) {
                    if (garden[r][col] != ' ') {
                        harmed++;
                        garden[r][col] = ' ';
                    }
                }
                break;
            case "down":
                for (int r = row; r < garden.length; r += 2) {
                    if (garden[r][col] != ' ') {
                        harmed++;
                        garden[r][col] = ' ';
                    }
                }
                break;
            case "left":
                for (int c = col; c >= 0; c -= 2) {
                    if (garden[row][c] != ' ') {
                        harmed++;
                        garden[row][c] = ' ';
                    }
                }
                break;
            case "right":
                for (int c = col; c < garden[row].length; c += 2) {
                    if (garden[row][c] != ' ') {
                        harmed++;
                        garden[row][c] = ' ';
                    }
                }
                break;
        }
        return harmed;
    }

    private static boolean isValid(char[][] garden, int row, int col) {
        return row >= 0 && col >= 0 && row < garden.length && col < garden[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            System.out.println(Arrays.toString(matrix[row]).replaceAll("[\\[\\],]", ""));
        }
    }
}