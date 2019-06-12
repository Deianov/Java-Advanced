/*  Fibonacci Search is a comparison-based technique that uses Fibonacci numbers to search an element in a sorted array.
    https://www.geeksforgeeks.org/fibonacci-search/

    Similarities with Binary Search:
        - Works for sorted arrays
        - A Divide and Conquer Algorithm.
        - Has Log n time complexity.

    Differences with Binary Search:
        - Fibonacci Search divides given array in unequal parts
        - Binary Search uses division operator to divide range. Fibonacci Search doesn’t use /, but uses + and -.
            The division operator may be costly on some CPUs.
        - Fibonacci Search examines relatively closer elements in subsequent steps.
            So when input array is big that cannot fit in CPU cache or even in RAM, Fibonacci Search can be useful.
*/

package J_BasicAlgorithms.Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class FibonacciSearch {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] sortedNumbers = Arrays.stream(reader.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(reader.readLine());

        System.out.println(fibonacciSearch(sortedNumbers, key));

    }

    private static int min(int a, int b) {
        return a <= b ? a : b;
    }

    private static int fibonacciSearch(int[] sortedNumbers, int key) {

        // Initialize fibonacci numbers
        int a = 0;
        int b = 1;
        int c = a + b;
        int length = sortedNumbers.length;

        // store the smallest Fibonacci Number greater than or equal to length
        while (c < length) {
            a = b;
            b = c;
            c = a + b;
        }

        int offset = -1;

        while (c > 1) {

            // Check if 'a' is a valid location
            int i = min(offset + a, length - 1);

            // If key is greater than the value at index 'a', cut the subarray array from offset to i
            if (sortedNumbers[i] < key) {
                c = b;
                b = a;
                a = c - b;
                offset = i;
            } else if (sortedNumbers[i] > key) {
                c = a;
                b = b - a;
                a = c - b;
            } else {
                return i;
            }

        }

        // comparing the last element with key
        if (b == 1 && sortedNumbers[offset + 1] == key)
            return offset + 1;

        // element not found
        return -1;
    }
}

class Fibonacci {

    private int fibonacci = 1;
    private int next = 2;
    private int previous = 1;
    private int count = 3;


    Fibonacci next() {
        this.moveNext();
        return this;
    }

    Fibonacci previous() {
        this.movePrevious();
        return this;
    }

    Fibonacci sequenceNumber(int c) {
        while (c != this.count) {
            if (c > this.count) {
                moveNext();
            } else {
                movePrevious();
            }
        }
        return this;
    }

    int getValue(){
        return this.fibonacci;
    }

    int getCount() {
        return this.count;
    }

    private void moveNext() {
        previous = fibonacci;
        fibonacci = next;
        next = previous + fibonacci;
        count++;
    }

    private void movePrevious() {
        fibonacci = previous;
        next = fibonacci;
        previous = next - fibonacci;
        count--;
    }
}
