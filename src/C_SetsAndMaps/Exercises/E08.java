//08. Hands Of Cards
package C_SetsAndMaps.Exercises;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        LinkedHashMap<String, HashSet<String>> persons = new LinkedHashMap<>();

        while (!"JOKER".equals(input = scanner.nextLine())) {

            String[] data = input.split(": ");
            String personName = data[0];
            String[] currentCards = data[1].toUpperCase().split(", ");

            persons.putIfAbsent(personName, new HashSet<>());
            persons.get(personName).addAll(Arrays.asList(currentCards));
        }

        persons.forEach((key, value) -> {
            int power = value.stream().mapToInt(E08::cardPower).sum();
            System.out.printf("%s: %d%n", key, power);
        });
    }

    private static int cardPower(String card) {
        int result = 0;
        String suffix ;
        String value = null;

        if (card.length() == 2) {
            suffix = card.charAt(1) + "";
            if (Character.isDigit(card.charAt(0))) {
                result += Integer.parseInt(card.substring(0, 1));
            } else {
                value = card.charAt(0) + "";
            }
        } else {
            suffix = card.charAt(2) + "";
            result += 10;
        }

        if (value != null) result += value.equals("A") ? 14 : value.equals("K") ? 13 : value.equals("Q") ? 12 : 11;
        result *= suffix.equals("S") ? 4 : suffix.equals("H") ? 3 : suffix.equals("D") ? 2 : 1;

        return result;
    }
}
