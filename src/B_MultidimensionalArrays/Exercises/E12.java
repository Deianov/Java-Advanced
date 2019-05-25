//12. The Matrix
package B_MultidimensionalArrays.Exercises;

import java.util.*;

class E12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            char[] arr = scanner.nextLine().trim().replaceAll("[^a-z0-9]", "").toCharArray();

            for (int col = 0; col < cols ; col++) {
                matrix[row][col] = arr[col];
            }
        }

        char fillChar = scanner.nextLine().replaceAll("[^a-z0-9]", "").charAt(0);
        int startRow = scanner.nextInt();
        int startCol = scanner.nextInt();
        char oldChar = matrix[startRow][startCol];
        matrix[startRow][startCol] = fillChar;

        Deque<Cell> cells = new ArrayDeque<>();
        cells.offer(new Cell(startRow, startCol));

        while (!cells.isEmpty()) {
            Cell cell = cells.pop();
            List<Cell> newCells = cell.spread(oldChar, fillChar, matrix);

            if (newCells.size() > 0) {
                cells.offer(cell);
                for (Cell newCell : newCells) {
                    cells.offer(newCell);
                }
            }
        }

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .forEach(e -> {
                    System.out.println(Arrays.toString(e).replaceAll("[\\[\\], ]", ""));
                });
    }
}

class Cell {
    private int row;
    private int col;

    Cell(int row, int cow) {
        this.row = row;
        this.col = cow;
    }

    int getRow() { return row; }
    int getCol() { return col; }

    List<Cell> spread (char oldChar, char fillChar, char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Cell> result = new ArrayList<>();

        // up
        int r = this.row - 1;
        int c = this.col;
        if (this.row > 0 && matrix[r][c] == oldChar) {
            result.add(new Cell(r, c));
            matrix[r][c] = fillChar;
        }
        // down
        r = this.row + 1;
        if (this.row < rows - 1 && matrix[r][c] == oldChar) {
            result.add(new Cell(r, c));
            matrix[r][c] = fillChar;
        }
        // left
        r = this.row;
        c = this.col - 1;
        if (this.col > 0 && matrix[r][c] == oldChar) {
            result.add(new Cell(r, c));
            matrix[r][c] = fillChar;
        }
        // right
        c = this.col + 1;
        if (this.col < cols - 1 && matrix[r][c] == oldChar) {
            result.add(new Cell(r, c));
            matrix[r][c] = fillChar;
        }

        return result;
    }
}
