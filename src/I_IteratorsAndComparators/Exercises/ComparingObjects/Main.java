//05. Comparing Objects
package I_IteratorsAndComparators.Exercises.ComparingObjects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        List<Person> people = new ArrayList<>();

        while (!"END".equals(line = reader.readLine())) {

            String[] data = line.split("\\s+");
            Person person = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            people.add(person);
        }

        Person person = people.get(Integer.parseInt(reader.readLine()) - 1);

        long equals = people.stream().filter(e -> e.compareTo(person) == 0).count();

        if (equals == 1) {
            System.out.println("No matches");
        } else {
            System.out.println(String.format("%d %d %d"
                    , equals
                    , people.size() - equals
                    , people.size()
            ));
        }
    }
}
