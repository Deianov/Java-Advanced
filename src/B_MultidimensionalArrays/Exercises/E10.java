//10. Radioactive Mutant Vampire Bunnies
package B_MultidimensionalArrays.Exercises;

import java.util.*;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        char[][] matrix = new char[rows][cols];

        Deque<Bunnie> bunnies = new ArrayDeque<>();
        int playerRow = -1;
        int playerCol = -1;

        for (byte r = 0; r < rows ; r++) {

            char[] row = scanner.nextLine().toCharArray();

            for (byte c = 0; c < cols ; c++) {
                char value = row[c];
                matrix[r][c] = value;
                if (value == 'P') {
                    playerRow = r;
                    playerCol = c;
                    matrix[r][c] = '.';
                } else if (value == 'B') {
                    bunnies.offer(new Bunnie(r, c));
                }
            }
        }

        boolean isWin = false;

        for (char move : scanner.nextLine().toCharArray()) {

            // move player
            switch (move) {
                case 'U' :
                    if (playerRow > 0) playerRow--;
                    else isWin = true;
                    break;
                case 'D' :
                    if (playerRow < rows - 1) playerRow++;
                    else isWin = true;
                    break;
                case 'R' :
                    if (playerCol < cols - 1) playerCol++;
                    else isWin = true;
                    break;
                case 'L' :
                    if (playerCol > 0) playerCol--;
                    else isWin = true;
                    break;
            }

            // bunnies spread
            int count = bunnies.size();
            for (int i = 0; i < count  ; i++) {
                Bunnie bunnie = bunnies.pop();
                List<Bunnie> newBunnies = bunnie.spread(matrix);

                if (newBunnies.size() > 0) {
                    bunnies.offer(bunnie);
                    for (Bunnie newBunni : newBunnies) {
                        bunnies.offer(newBunni);
                    }
                }
            }

            if (matrix[playerRow][playerCol] == 'B' || isWin) {
                break;
            }
        }

        printMatrix(matrix);
        System.out.println(String.format("%s: %d %d", isWin ? "won" : "dead", playerRow, playerCol));
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix)
                .forEach(e -> {
                    System.out.println(Arrays.toString(e).replaceAll("[\\[\\], ]", ""));
                });
    }
}

class Bunnie {
    private int row;
    private int col;

    Bunnie(int row, int cow) {
        this.row = row;
        this.col = cow;
    }

    int getRow() { return row; }
    int getCol() { return col; }

    List<Bunnie> spread (char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<Bunnie> result = new ArrayList<>(4);

        // up
        int r = this.row - 1;
        int c = this.col;
        if (this.row > 0 && matrix[r][c] != 'B') {
            result.add(new Bunnie(r, c));
            matrix[r][c] = 'B';
        }
        // down
        r = this.row + 1;
        if (this.row < rows - 1 && matrix[r][c] != 'B') {
            result.add(new Bunnie(r, c));
            matrix[r][c] = 'B';
        }
        // left
        r = this.row;
        c = this.col -1;
        if (this.col > 0 && matrix[r][c] != 'B') {
            result.add(new Bunnie(r, c));
            matrix[r][c] = 'B';
        }
        // right
        c = this.col + 1;
        if (this.col < cols -1 && matrix[r][c] != 'B') {
            result.add(new Bunnie(r, c));
            matrix[r][c] = 'B';
        }

        return result;
    }
}
