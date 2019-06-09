//03. Sum of Coins
package J_BasicAlgorithms.Lab;

import java.util.*;
import java.util.stream.Collectors;

class SumOfCoins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Integer> coins = Arrays.stream(scanner.nextLine()
                .split("[,\\s]+"))
                .skip(1)
                .map(Integer::parseInt)
                .sorted((a, b) -> Integer.compare(b, a))
                .distinct()
                .collect(Collectors.toCollection(ArrayList::new));

        int finalSum = Integer.parseInt(scanner.nextLine().split("\\s+")[1]);
        int currentSum = 0;

        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int coin : coins) {
            if (currentSum + coin > finalSum) {
                continue;
            }

            while (currentSum + coin <= finalSum) {
                currentSum += coin;
                result.offer(coin);
            }

            if (currentSum == finalSum) break;
        }

        if (currentSum == finalSum) {
            System.out.println(String.format("Number of coins to take: %d", result.size()));

            int count = 0;
            int value = result.isEmpty() ? 0 : result.peek();

            while (!result.isEmpty()) {
                int next = result.poll();

                if (value == next) {
                    count++;
                } else {
                    System.out.println(String.format("%d coin(s) with value %d", count, value));
                    count = 1;
                    value = next;
                }
            }
            System.out.println(String.format("%d coin(s) with value %d", count, value));
        } else {
            System.out.println("Error");
        }
    }
}
