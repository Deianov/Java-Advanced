//03. Connected Areas in Matrix
package J_BasicAlgorithms.Exercises;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;


class ConnectedAreasInMatrix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String line = scanner.nextLine();

            for (int col = 0; col < cols; col++) {
                matrix[row][col] = (line.charAt(col) == '-') ? 0 : -1;
            }
        }

        List<Area> areaList = new ArrayList<>();
        int areaCount = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (matrix[row][col] == 0) {

                    Area area = new Area(matrix, areaCount++, row, col);
                    areaList.add(area);
                    area.fill(row, col);
                }
            }
        }

        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(1);

        System.out.println(String.format("Total areas found: %d", areaList.size()));
        areaList.stream()
                .sorted((a, b) -> {
                  int result = Integer.compare(b.getSize(), a.getSize());
                  if (result == 0) {
                      result = Integer.compare(a.getId(), b.getId());
                  }
                  return result;
                })
                .forEach(area -> {
                    System.out.println(String.format("Area #%d%s", atomicInteger.getAndIncrement(), area.toString()));
                });
    }
}

class Area{
    private int id;
    private int startRow;
    private int startCol;
    private int size;
    private int[][] matrix;

    Area(int[][] matrix, int id, int row, int col) {
        this.startRow = row;
        this.startCol = col;
        this.id = id;
        this.size = 0;
        this.matrix = matrix;
    }

    int getId() { return id; }
    int getRow() { return startRow; }
    int getCol() { return startCol; }
    int getSize() { return size; }

    void fill(int row, int col) {

        if (!isValid(row, col))
            return;

        if (this.matrix[row][col] != 0)
            return;

        this.matrix[row][col] = this.id;
        this.size++;

        this.fill(row + 1, col);
        this.fill(row - 1, col);
        this.fill(row, col + 1);
        this.fill(row, col - 1);
    }

    private boolean isValid(int row, int col){
        return row >= 0 && col >= 0 && row < this.matrix.length && col < this.matrix[row].length;
    }

    @Override
    public String toString() {
        return String.format(" at (%d, %d), size: %d", startRow, startCol, size);
    }
}
