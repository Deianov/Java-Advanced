//09. Parking System
package B_MultidimensionalArrays.Exercises;

import java.util.Scanner;

class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();

        byte[][] parking = new byte[rows][cols];
        int[] fullRows = new int[rows];
        int carRow;
        int row;
        int col;

        while (true) {

            if (scanner.hasNextInt()) {
                carRow = scanner.nextInt();
                row = scanner.nextInt();
                col = scanner.nextInt();
                scanner.nextLine();
            } else {
                return;
            }

            if (fullRows[row] < cols - 1) {
                fullRows[row]++;
            } else {
                System.out.println(String.format("Row %d full", row));
                continue;
            }

            // place is full
            if (parking[row][col] == 1) {
                col = findClosestPlace(parking[row], col);
            }

            // set place full
            parking[row][col] = 1;

            // distance
            System.out.println(Math.abs(carRow - row) + col + 1);
        }
    }

    private static int findClosestPlace (byte[] parkingRow, int col) {

        int moveLeft;
        int moveRight;
        int length = parkingRow.length;

        for (int i = 1; i < length - 1 ; i++) {

            moveLeft = col - i;
            moveRight = col + i;

            if (moveLeft > 0 && parkingRow[moveLeft] == 0) {
                return moveLeft;
            } else if (moveRight < length && parkingRow[moveRight] == 0) {
                return moveRight;
            }
        }
        return -1;
    }
}