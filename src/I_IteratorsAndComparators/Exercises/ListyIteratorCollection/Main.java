//02. Collection
package I_IteratorsAndComparators.Exercises.ListyIteratorCollection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        List<String> data = Arrays.stream(reader.readLine().split("\\s+")).skip(1).collect(Collectors.toCollection(ArrayList::new));

        ListyIterator listyIterator = new ListyIterator(data);

        while (!"END".equals(line = reader.readLine())) {

            switch (line) {
                case "Move":
                    System.out.println(listyIterator.Move());
                    break;
                case "Print":
                    listyIterator.Print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    for (String item : listyIterator) {
                        System.out.print(item + " ");
                    }
                    System.out.println();
            }
        }
    }
}
