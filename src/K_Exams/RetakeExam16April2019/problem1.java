//01. Trojan Invasion
package K_Exams.RetakeExam16April2019;

import java.util.*;
import java.util.stream.Collectors;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wavesCount = Integer.parseInt(scanner.nextLine());

        // Queue
        Deque<Integer> plates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        // Stack
        Deque<Integer> wave = new ArrayDeque<>();

        int count = 0;
        while (wavesCount-- > 0){

            // Add warriors ot stack
            Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayDeque::new))
                    .descendingIterator()
                    .forEachRemaining(wave::offer);

            // Add plates to queue
            if (++count % 3 == 0){
                Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .forEach(plates::offer);
            }

            // next wave
            while (!wave.isEmpty() && !plates.isEmpty()){
                int warrior = wave.pop();
                int plate = plates.pop();

                if(plate > warrior){
                    plates.push(plate - warrior);
                }
                else if(warrior > plate){
                    wave.push(warrior - plate);
                }
            }

            if(plates.isEmpty()){
                break;
            }
        }

        // Output
        if(plates.isEmpty()){
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
        }else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
        }

        if(!plates.isEmpty()){
            System.out.println(String.format("Plates left: %s", dequeToString(plates)));
        }

        if(!wave.isEmpty()){
            System.out.println(String.format("Warriors left: %s", dequeToString(wave)));
        }
    }

    private static String dequeToString(Deque<Integer> deque){
        if (deque == null){
            return null;
        }
        return Arrays.toString(deque.toArray()).replaceAll("[\\[\\]]", "");
    }
}
