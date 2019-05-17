//14. Dragon Army
package C_SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class E14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, Dragon>> dragons = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");

            Dragon dragon = new Dragon(data[1], data[0], tryParse(data[2]), tryParse(data[3]), tryParse(data[4]));
            String name = dragon.getName();
            String type = dragon.getType();

            dragons.putIfAbsent(type, new TreeMap<>());

            if (dragons.get(type).containsKey(name)) {
                // update
                dragons.get(type).get(name).update(dragon);
            } else {
                dragons.get(type).put(name, dragon);
            }
        }

        dragons.forEach((key, value) -> {
            double avDamage = value.values().stream().mapToDouble(Dragon::getDamage).average().orElse(0.0);
            double avHealth = value.values().stream().mapToDouble(Dragon::getHealth).average().orElse(0.0);
            double avArmor = value.values().stream().mapToDouble(Dragon::getArmor).average().orElse(0.0);
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", key, avDamage, avHealth, avArmor);
            value.values().forEach(Dragon::print);
        });
    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}

class Dragon {
    private String name;
    private String type;
    private int damage;
    private int health;
    private int armor;

    Dragon(String name, String type, Integer damage, Integer health, Integer armor) {
        this.name = name.substring(0, 1).toUpperCase() + name.substring(1);
        this.type = type.substring(0, 1).toUpperCase() + type.substring(1);
        this.damage = damage == null ? 45 : damage;
        this.health = health == null ? 250 : health;
        this.armor = armor == null ? 10 : armor;
    }

    String getName() { return name; }
    int getDamage() { return damage; }
    int getHealth() { return health; }
    int getArmor() { return armor; }
    String getType() { return type; }

    void update (Dragon dragon) {
        this.damage = dragon.getDamage();
        this.health = dragon.getHealth();
        this.armor = dragon.getArmor();
    }

    void print() {
        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", this.name, this.damage, this.health, this.armor);
    }
}