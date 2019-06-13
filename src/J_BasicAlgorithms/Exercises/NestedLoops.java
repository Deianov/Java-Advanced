//02. Nested Loops
package J_BasicAlgorithms.Exercises;

import java.util.Scanner;

class NestedLoops {

    private static int[] arr;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        arr = new int[n];

        printNestedLoops(n, 0);
    }

    private static void printNestedLoops(int n, int begin) {
        if(begin >= n) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n ; i++) {
            arr[begin] = i;
            printNestedLoops(n, begin + 1);
        }
    }
}
