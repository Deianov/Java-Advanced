package K_Exams.RetakeExam13August2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split("\\s+");
        String[] secondLine = scanner.nextLine().split("\\s+");

        // naturalOrder (1 2 3 -> 1 2 3)
        Deque<Integer> ingredients = Arrays.stream(firstLine)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // reverseOrder (3 2 1 -> 1 2 3)
        Deque<Integer> freshness = new ArrayDeque<>();
        Arrays.stream(secondLine)
                .map(Integer::parseInt)
                .forEach(freshness::push);

        String[] cocktailNames = {"Daiquiri", "Mimosa", "Mojito", "Sunshine"};
        int[] cocktailLevels = {250, 150, 400, 300};
        int[] cocktails = {0, 0, 0, 0};

        while (!ingredients.isEmpty() && !freshness.isEmpty() ) {

            while (!ingredients.isEmpty() && ingredients.peek() == 0){
                ingredients.pop();
            }

            if (ingredients.isEmpty()){
                break;
            }

            int ingredient = ingredients.pop();
            int freshnessValue = freshness.pop();

            int mix = ingredient * freshnessValue;

            boolean makeCocktail = false;

            for (int i = 0; i < cocktailLevels.length; i++) {
                if (mix == cocktailLevels[i]) {
                    cocktails[i]++;
                    makeCocktail = true;
                    break;
                }
            }

            if (!makeCocktail) {
                ingredient += 5;
                ingredients.offer(ingredient);
            }
        }

        boolean partyTime = Arrays.stream(cocktails)
                .map(v -> v == 0 ? 0 : 1)
                .sum() == cocktails.length;

        if (partyTime) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int ingredientsSum = ingredients.stream().mapToInt(i -> i).sum();
            System.out.println(String.format("Ingredients left: %d", ingredientsSum));
        }

        for (int i = 0; i < cocktails.length; i++) {

            if (cocktails[i] > 0) {
                System.out.println(String.format(" # %s --> %d",
                        cocktailNames[i],
                        cocktails[i])
                );
            }
        }
    }
}
