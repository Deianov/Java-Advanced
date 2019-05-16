//10. Population Counter
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        LinkedHashMap<String, LinkedHashMap<String, Long>> countries = new LinkedHashMap<>();

        while (!"report".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\|");
            String city = data[0];
            String country = data[1];
            long population = Integer.parseInt(data[2]);

            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).put(city, population);
        }

        countries.entrySet()
                .stream()
                .sorted((a, b) -> {
                    long populationA = a.getValue().values().stream().mapToLong(Long::longValue).sum();
                    long populationB = b.getValue().values().stream().mapToLong(Long::longValue).sum();
                    return Long.compare(populationB, populationA);
                })
                .forEach(e -> {
                    long population = e.getValue().values().stream().mapToLong(Long::longValue).sum();
                    System.out.printf("%s (total population: %d)%n", e.getKey(), population);

                    e.getValue().entrySet()
                            .stream()
                            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                            .forEach(c -> {
                                System.out.printf("=>%s: %d%n", c.getKey(), c.getValue());
                            });
                });
    }
}
