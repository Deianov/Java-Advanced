//04. Count Symbols
package C_SetsAndMaps.Exercises;

import java.util.Scanner;
import java.util.TreeMap;

class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<Character, Integer> symbols = new TreeMap<>();

        for (char ch: scanner.nextLine().toCharArray()) {

            if (symbols.containsKey(ch)) {
                symbols.put(ch, symbols.get(ch) + 1);
            } else {
                symbols.put(ch, 1);
            }
        }

        symbols.forEach((key, value) -> {
            System.out.printf("%c: %d time/s%n", key, value);
        });
    }
}
