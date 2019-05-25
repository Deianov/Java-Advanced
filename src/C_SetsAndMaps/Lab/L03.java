//03. "Voina" - Number game
package C_SetsAndMaps.Lab;

import java.util.*;
import java.util.stream.Collectors;

class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));
        Set<Integer> secondPlayer = new LinkedHashSet<>(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList()));

        for (int i = 0; i < 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) break;

            int firstNumber = firstPlayer.iterator().next();
            firstPlayer.remove(firstNumber);
            int secondNumber = secondPlayer.iterator().next();
            secondPlayer.remove(secondNumber);

            if (firstNumber > secondNumber) {
                firstPlayer.add(firstNumber);
                firstPlayer.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                secondPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            } else {
                firstPlayer.add(firstNumber);
                secondPlayer.add(secondNumber);
            }
        }
        System.out.println(firstPlayer.size() > secondPlayer.size() ?
                "First player win!" : secondPlayer.size() > firstPlayer.size() ?
                "Second player win!" : "Draw!");
    }
}
