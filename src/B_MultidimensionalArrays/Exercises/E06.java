//06. String Matrix Rotation
package B_MultidimensionalArrays.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // rotation in degree
        int rotation = getRotation(scanner.nextLine());

        // matrix data
        List<String> words = new ArrayList<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            words.add(input);
        }

        int rows = words.size();
        int cols = words.stream().mapToInt(String::length).max().getAsInt();

        char[][] matrix = new char[rows][cols];

        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < rows; row++) {

            stringBuilder.setLength(0);
            stringBuilder.append(words.get(row));
            // append ' '
            toLength(stringBuilder, cols);

            matrix[row] = stringBuilder.toString().toCharArray();
        }

        switch (rotation) {
            case 0 :
                for (int row = 0; row < rows; row++) {
                    stringBuilder.setLength(0);
                    stringBuilder.append(matrix[row]);
                    System.out.println(stringBuilder.toString());
                }
                break;
            case 90 :
                for (int col = 0; col < cols; col++) {
                    stringBuilder.setLength(0);
                    for (int row = rows - 1; row >= 0 ; row--) {
                        stringBuilder.append(matrix[row][col]);
                    }
                    System.out.println(stringBuilder.toString());
                }
                break;
            case 180 :
                for (int row = rows - 1; row >= 0 ; row--) {
                    stringBuilder.setLength(0);
                    stringBuilder.append(matrix[row]);
                    System.out.println(stringBuilder.reverse().toString());
                }
                break;
            case 270 :
                for (int col = cols - 1; col >= 0 ; col--) {
                    stringBuilder.setLength(0);
                    for (int row = 0; row < rows ; row++) {
                        stringBuilder.append(matrix[row][col]);
                    }
                    System.out.println(stringBuilder.toString());
                }
        }
    }

    private static void toLength (StringBuilder stringBuilder, int toLen) {
        if (stringBuilder.length() < toLen) {
            toLength(stringBuilder.append(' '), toLen);
        }
    }

    private static int getRotation (String input) {
        // Rotate(810)
        String regex = "(Rotate\\((?<degree>[-+]?[0-9]+)\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        int degrees = Integer.parseInt(matcher.group("degree"));

        degrees = degrees % 360;
        while (degrees < 0) {degrees += 360;}

        return degrees;
    }
}