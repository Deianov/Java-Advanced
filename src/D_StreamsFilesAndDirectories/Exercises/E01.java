//01. Sum Lines
package D_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class E01 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path)))
        {
            String line;

            while ((line = reader.readLine()) != null) {
                long sum = 0;

                for (char c : line.toCharArray()) {
                    sum += c;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
