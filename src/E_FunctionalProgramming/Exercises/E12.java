//12. Inferno III
package E_FunctionalProgramming.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class E12 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        List<Integer> numbers = Arrays.stream(line.split("\\s+")).map(Integer::valueOf).collect(Collectors.toList());
        List<Integer> excludeIndexes = new ArrayList<>();
        HashMap<String, List<Integer>> filters = new HashMap<>();

        while (!"Forge".equals(line = reader.readLine())) {

            String[] commandTokens = line.split(";");
            String command = commandTokens[0];
            String type = commandTokens[1];
            int parameter = Integer.parseInt(commandTokens[2]);

            if(command.equals("Exclude")) {
                filters.putIfAbsent(type, new ArrayList<>());
                filters.get(type).add(parameter);

            } else if (command.equals("Reverse")) {

                if (filters.containsKey(type)) {
                    filters.get(type).removeIf(n -> Objects.equals(n, parameter));
                }
            }
        }

        int size = numbers.size();

        for (Map.Entry<String, List<Integer>> entry : filters.entrySet()) {

            String type = entry.getKey();

            List<Integer> parameters = entry.getValue();
            // delete duplicates
            Collections.sort(parameters);
            parameters = parameters.stream().distinct().collect(Collectors.toList());

            for (int parameter : parameters) {

                for (int i = 0; i < size ; i++) {

                    int element = numbers.get(i);
                    int leftElement = i > 0 ? numbers.get(i - 1) : 0;
                    int rightElement = i < size - 1 ? numbers.get(i + 1) : 0;

                    if (getPredicate(type, element, leftElement, rightElement).test(parameter)) {
                        if (!excludeIndexes.contains(i)) {
                            excludeIndexes.add(i);
                        }
                    }
                }
            }
        }

        IntStream.range(0, size)
                .filter(i -> !excludeIndexes.contains(i))
                .map(numbers::get)
                .forEach(e -> System.out.print(e + " "));
    }

    private static Predicate<Integer> getPredicate(String type, int element, int leftElement, int rightElement) {
        switch (type) {
            case "Sum Left":
                return sum -> sum == element + leftElement;
            case "Sum Right":
                return sum -> sum == element + rightElement;
            case "Sum Left Right":
                return sum -> sum == element + leftElement + rightElement;
            default:
                return sum -> false;
        }
    }
}
