//05. Line Numbers
package D_StreamsFilesAndDirectories.Exercises;

import java.io.*;

class E05 {
    public static void main(String[] args) {

        String pathIn = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\inputLineNumbers.txt";
        String pathOut = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             FileWriter writer = new FileWriter(pathOut))
        {
            String line;
            int count = 1;
            while ((line = reader.readLine()) != null) {

                writer.write(String.format("%d. %s%n", count++, line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
