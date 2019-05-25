//07. Cities by Continent and Country
package C_SetsAndMaps.Lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

class L07a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();

        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            String continentName = data[0];
            String countryName = data[1];
            String cityName = data[2];

            if(!continents.containsKey(continentName)) {
                continents.put(continentName, new LinkedHashMap<>(){{put(countryName, new ArrayList<>(){{add(cityName);}});}});
            } else {
                if (!continents.get(continentName).containsKey(countryName)) {
                    continents.get(continentName).put(countryName, new ArrayList<>(){{add(cityName);}});
                } else {
                    continents.get(continentName).get(countryName).add(cityName);
                }
            }
        }

        continents.forEach((key, value) -> {
            System.out.printf("%s:%n", key);
            value.entrySet().forEach(e -> {
                System.out.printf("\t%s -> %s%n",
                        e.getKey(),
                        e.getValue().toString().replaceAll("[\\[\\]]", ""));
            });
        });
    }
}
