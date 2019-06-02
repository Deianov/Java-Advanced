// 01. Generic Box & 02. Generic Box of Integer
package H_Generics.Exercises.GenericBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        while (lines-- > 0) {

            String line = reader.readLine();

            try {
                // 02. Generic Box of Integer
                int value = Integer.parseInt(line);
                System.out.println(new Box<>(value).toString());
            } catch (NumberFormatException e) {
                // 01. Generic Box
                System.out.println(new Box<>(line).toString());
            }
        }
    }
}
