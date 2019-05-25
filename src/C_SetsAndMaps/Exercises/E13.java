//13. Сръбско Unleashed
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class E13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Pattern pattern = Pattern.compile("^(?<singer>[^\\s]+\\s?[^\\s]*\\s?[^\\s]*)\\s+@(?<venue>[^\\s]+\\s?[^\\s]*\\s?[^\\s]*)\\s+(?<price>\\d+)\\s+(?<tickets>\\d+)$");

        LinkedHashMap<String, LinkedHashMap<String, Integer>> venues = new LinkedHashMap<>();

        while (!"End".equals(input = scanner.nextLine())) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int money = Integer.parseInt(matcher.group("price")) * Integer.parseInt(matcher.group("tickets"));

                venues.putIfAbsent(venue, new LinkedHashMap<>());
                venues.get(venue).putIfAbsent(singer, 0);

                venues.get(venue).put(singer, venues.get(venue).get(singer) + money);
            }
        }

        venues.forEach((key, value) -> {
            System.out.printf("%s%n", key);
            value.entrySet()
                    .stream()
                    .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                    .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(), e.getValue()));
        });
    }
}
