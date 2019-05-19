//07. Merge Two Files
package D_StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class E07 {
    public static void main(String[] args) {

        String pathOne = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\inputOne.txt";
        String pathTwo = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\inputTwo.txt";
        String pathOut = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\output.txt";

        Deque<String> lines = new ArrayDeque<>();

        try (BufferedReader readerOne = new BufferedReader(new FileReader(pathOne));
             BufferedReader readerTwo = new BufferedReader(new FileReader(pathTwo)))
        {
            String line;
            while ((line = readerOne.readLine()) != null) {
                lines.offer(line);
            }

            while ((line = readerTwo.readLine()) != null) {
                lines.offer(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut)))
        {
            while (!lines.isEmpty()) {
                writer.println(lines.poll());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
