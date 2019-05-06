//05. Matrix shuffling
package B_MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        Matrix matrix = new Matrix(rows, cols);
        matrix.read(scanner);

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] command = line.split("\\s+");
            if (command.length == 5 && command[0].equals("swap")) {
                int fromRow = Integer.parseInt(command[1]);
                int fromCol = Integer.parseInt(command[2]);
                int toRow = Integer.parseInt(command[3]);
                int toCol = Integer.parseInt(command[4]);

                if (matrix.swap(fromRow, fromCol, toRow, toCol)) {
                    matrix.printMatrix();
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}

class Matrix {
    private String[][] matrix;
    private int rows;
    private int cols;

    Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new String[rows][cols];
    }

    void read(Scanner scanner) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                this.matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

    boolean swap(int fromRow, int fromCol, int toRow, int toCol) {
        if (fromRow > -1 && fromCol > -1 && toRow > -1 && toCol > -1) {
            if (fromRow < this.rows && fromCol < this.cols && toRow < this.rows && toCol < this.cols) {
                String temp = this.matrix[fromRow][fromCol];
                this.matrix[fromRow][fromCol] = this.matrix[toRow][toCol];
                this.matrix[toRow][toCol] = temp;
                return true;
            }
        }
        return false;
    }

    void printMatrix() {
        for (int row = 0; row < this.rows; row++) {
            System.out.println(Arrays.toString(this.matrix[row]).replaceAll("[\\[\\],]", ""));

        }
    }
}
