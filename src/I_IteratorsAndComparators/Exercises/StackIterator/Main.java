package I_IteratorsAndComparators.Exercises.StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        Stack<Integer> stack = new Stack<>();

        while (!"END".equals(line = reader.readLine())) {

            if (line.startsWith("Push ")) {
                Arrays.stream(line.split("[\\s,]+"))
                        .skip(1)
                        .mapToInt(Integer::parseInt)
                        .forEach(stack::push);
            }
            else if (line.equals("Pop")) {
                try {
                    stack.pop();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        for (int i = 0; i < 2 ; i++) {
            for (int element : stack) {
                System.out.println(element);
            }
        }
    }
}
