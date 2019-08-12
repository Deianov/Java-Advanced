package K_Exams.exam.templates;

import java.util.*;
import java.util.stream.Collectors;

public class problemWithDeque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstTokens = scanner.nextLine().split("\\s+");
        String[] secondTokens = scanner.nextLine().split("\\s+");
        String[] appendTokens = scanner.nextLine().split("\\s+");

        // stack (push, pop)   - last in first out  <-->
        // queue (offer, poll) - last in last out   <-<-

        // naturalOrder (1 2 3 -> 1 2 3)
        Deque<Integer> naturalOrder = Arrays.stream(firstTokens)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // reverseOrder (3 2 1 -> 1 2 3)
        Deque<Integer> reverseOrder = new ArrayDeque<>();
        Arrays.stream(secondTokens)
                .map(Integer::parseInt)
                .forEach(reverseOrder::push);

        // add to reverseOrder (6 5 4 -> 1 2 3 4 5 6)
        Arrays.stream(appendTokens)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new))
                .descendingIterator()
                .forEachRemaining(reverseOrder::offer);

    }

    private static String dequeToString(Deque<Integer> deque){
        if (deque == null){
            return null;
        }
        return Arrays.toString(deque.toArray()).replaceAll("[\\[\\]]", "");
    }
}
