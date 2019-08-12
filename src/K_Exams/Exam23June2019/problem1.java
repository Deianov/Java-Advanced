//01. Spaceship Crafting
package K_Exams.Exam23June2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class problem1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> chemicalLiquids = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        Deque<Integer> physicalItems = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(physicalItems::push);

        String[] materialNames = {"Aluminium", "Carbon fiber", "Glass", "Lithium"};
        int[] materialValues = {50, 100, 25, 75};
        int[] materials = {0, 0, 0, 0};

        while (true){
            if (chemicalLiquids.isEmpty() || physicalItems.isEmpty()){
                break;
            }

            Integer chemical = chemicalLiquids.pop();
            Integer physical = physicalItems.poll();
            physical = physical == null ? 0 : physical;

            boolean make = false;
            for (int i = 0; i < 4; i++) {

                if (chemical + physical == materialValues[i]){
                    materials[i]++;
                    make = true;
                    break;
                }
            }
            if (!make){
                physical+= 3;
                physicalItems.push(physical);
            }
        }

        int materialsFound = Arrays.stream(materials).map(m -> m == 0 ? 0 : 1).sum();

        if (materialsFound == 4){
            System.out.println("Wohoo! You succeeded in building the spaceship!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to build the spaceship.");
        }
        String result = "none";
        if(!chemicalLiquids.isEmpty()){
            result = Arrays.toString(chemicalLiquids.toArray()).replaceAll("[\\[\\]]", "");
        }
        System.out.println(String.format("Liquids left: %s", result));

        result = "none";
        if(!physicalItems.isEmpty()){
            result = Arrays.toString(physicalItems.toArray()).replaceAll("[\\[\\]]", "");
        }
        System.out.println(String.format("Physical items left: %s", result));

        for (int i = 0; i < 4; i++) {
            System.out.println(String.format("%s: %d", materialNames[i], materials[i]));
        }
    }
}


