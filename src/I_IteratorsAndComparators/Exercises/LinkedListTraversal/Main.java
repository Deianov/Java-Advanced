//09. Linked List Traversal
package I_IteratorsAndComparators.Exercises.LinkedListTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        LinkedList linkedList = new LinkedList();

        while (lines-- > 0) {
            String[] commandTokens = reader.readLine().split("\\s+");

            String command = commandTokens[0];
            int value = Integer.parseInt(commandTokens[1]);

            switch (command){
                case "Add":
                    linkedList.add(value);
                    break;
                case "Remove":
                    linkedList.remove(value);
                    break;
            }
        }

        System.out.println(linkedList.getSize());
        for (int value: linkedList) {
            System.out.print(value + " ");
        }
    }
}
