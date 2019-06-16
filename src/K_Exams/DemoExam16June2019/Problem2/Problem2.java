//(Demo) Java Advanced Exam - 16 June 2019
// Problem 2 - Make a Salad

package K_Exams.DemoExam16June2019.Problem2;

import java.util.*;

public class Problem2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputVegetables = Arrays.asList(scanner.nextLine().split(" "));
        List<String> inputCalories = Arrays.asList(scanner.nextLine().split(" "));

        HashMap<String, Integer> vegetableCalories = new HashMap<>();
        vegetableCalories.put("tomato", 80);
        vegetableCalories.put("carrot", 136);
        vegetableCalories.put("lettuce", 109);
        vegetableCalories.put("potato", 215);

        ArrayDeque<String> vegetables = new ArrayDeque<>(inputVegetables);

        ArrayDeque<Integer> salads = new ArrayDeque<>();
        for (String c : inputCalories) {
            salads.push(Integer.parseInt(c));
        }

        ArrayDeque<Integer> saladsFinished = new ArrayDeque<>();
        int currentSalad = 0;

        while (!salads.isEmpty()) {

            currentSalad = salads.peek();

            while (!vegetables.isEmpty()) {

                String vegetable = vegetables.pop();
                int calories = 0;

                if (vegetableCalories.containsKey(vegetable)) {
                    calories = vegetableCalories.get(vegetable);
                }

                currentSalad -= calories;

                if (currentSalad <= 0) {
                    saladsFinished.offer(salads.pop());
                    break;
                }
            }

            if (vegetables.isEmpty())
                break;
        }

        if (currentSalad > 0) {
            saladsFinished.offer(salads.pop());
        }

        if (!saladsFinished.isEmpty()) {
            while (!saladsFinished.isEmpty()) {
                System.out.print(saladsFinished.pop() + " ");
            }
            System.out.println();
        }

        if (!salads.isEmpty()) {
            while (!salads.isEmpty()) {
                System.out.print(salads.pop() + " ");
            }
            System.out.println();
        }

        if (!vegetables.isEmpty()) {
            while (!vegetables.isEmpty()) {
                System.out.print(vegetables.poll() + " ");
            }
        }
    }
}
