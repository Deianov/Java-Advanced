//06. Product Shop
package C_SetsAndMaps.Lab;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!"Revision".equals(input = scanner.nextLine())) {

            String[] data = input.split(", ");
            String shopName = data[0];
            String productName = data[1];
            double productPrice = Double.parseDouble(data[2]);

            shops.putIfAbsent(shopName, new LinkedHashMap<>());
            shops.get(shopName).put(productName, productPrice);
        }

        shops.forEach((key, value) -> {
            System.out.printf("%s->%n", key);
            value.entrySet().forEach(e -> System.out.printf("Product: %s, Price: %.1f%n", e.getKey(), e.getValue()));
        });

    }
}
