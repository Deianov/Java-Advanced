//12. Legendary Farming
package C_SetsAndMaps.Exercises;

import java.util.*;

public class E12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> materials = new TreeMap<>(Map.of("shards", 0, "motes", 0,"fragments", 0));
        TreeMap<String, Integer> materialsJunk = new TreeMap<>();
        HashMap<String, String> materialsItems = new HashMap<>(Map.of("shards", "Shadowmourne", "fragments", "Valanyr", "motes", "Dragonwrath"));

        boolean legendaryItem = false;

        while (!legendaryItem) {

            String[] tokens = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < tokens.length - 1 ; i += 2) {

                int quantity = Integer.parseInt(tokens[i]);
                String material = tokens[i + 1];

                // legendary material
                if (materials.containsKey(material)) {

                    quantity += materials.get(material);
                    legendaryItem = quantity >= 250;

                    // legendary item
                    if (legendaryItem) {
                        materials.put(material, quantity - 250);
                        System.out.printf("%s obtained!%n", materialsItems.get(material));
                        break;
                    } else {
                        materials.put(material, quantity);
                    }
                // junk material
                } else {
                    materialsJunk.putIfAbsent(material, 0);
                    materialsJunk.put(material, materialsJunk.get(material) + quantity);
                }
            }
        }

        materials.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> System.out.printf("%s: %d%n", e.getKey(), e.getValue()));

        materialsJunk.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
