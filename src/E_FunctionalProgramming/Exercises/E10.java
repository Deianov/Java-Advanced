//10. Predicate Party! ??? 80%
package E_FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

class E10 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        if (line.isEmpty()) {
            System.out.println("Nobody is going to the party!");
            return;
        }

        String[] arr = line.split("\\s+");
        List<String> guests = new ArrayList<>();
        Collections.addAll(guests, arr);

        while (!"Party!".equalsIgnoreCase(line = reader.readLine())) {

            String[] commandTokens = line.split("\\s+");

            String command = commandTokens[0];
            String predicateType = commandTokens[1];
            String predicateArgument = commandTokens[2];

            if (command.equalsIgnoreCase("Remove")) {

                guests.removeIf(getPredicate(predicateType, predicateArgument));

            } else if (command.equalsIgnoreCase("Double")) {

                List<String> additionalGuests = new ArrayList<>();

                for (String guest : guests) {
                    if (getPredicate(predicateType, predicateArgument).test(guest)) {
                        additionalGuests.add(guest);
                    }
                    additionalGuests.add(guest);
                }
                guests = additionalGuests;
            }
        }

        if (guests.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(String.format("%s are going to the party!", String.join(", ", guests)));
        }
    }

    private static Predicate<String> getPredicate(String type, String parameter) {
        switch (type) {
            case "StartsWith":
                return quest -> quest.startsWith(parameter);
            case "EndsWith":
                return quest -> quest.endsWith(parameter);
            default:
                return quest -> quest.length() == Integer.parseInt(parameter);
        }
    }
}
