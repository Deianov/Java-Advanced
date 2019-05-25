//02. SoftUni Party
package C_SetsAndMaps.Lab;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

class L02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String input;

        while (!"PARTY".equals(input = scanner.nextLine())) {
            if (Character.isDigit(input.charAt(0))) {
                vip.add(input);
            } else {
                regular.add(input);
            }
        }

        while (!"END".equals(input = scanner.nextLine())) {

            if (Character.isDigit(input.charAt(0))) vip.remove(input);
            else regular.remove(input);
        }

        System.out.println(vip.size() + regular.size());
        vip.forEach(System.out::println);
        regular.forEach(System.out::println);
    }
}
