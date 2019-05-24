//11. The Party Reservation Filter Module
package E_FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class E11 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        List<String> guests = Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
        List<String> filters = new ArrayList<>();

        while (!"Print".equals(line = reader.readLine())) {

            if (line.startsWith("Add filter;")) {
                filters.add(line);
            } else if (line.startsWith("Remove filter;")) {

                filters.remove("Add filter;" + line.substring(14));
            }
        }

        for (String filter : filters) {

            String[] commandTokens = filter.split(";");

            guests.removeIf(getPredicate(commandTokens[1], commandTokens[2]));
        }
        System.out.println(String.join(" ", guests));
    }

    private static Predicate<String> getPredicate (String type, String parameter) {
        switch (type) {
            case "Starts with" :
                return text -> text.startsWith(parameter);
            case "Ends with" :
                return text -> text.endsWith(parameter);
            case "Contains" :
                return text -> text.contains(parameter);
            case "Length" :
                return text -> text.length() == Integer.parseInt(parameter);
        }
        return text -> false;
    }
}
