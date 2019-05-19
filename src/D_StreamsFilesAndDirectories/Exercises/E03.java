//03. ALL CAPITALS!
package D_StreamsFilesAndDirectories.Exercises;

import java.io.*;

class E03 {
    public static void main(String[] args) {

        String pathIn = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\input.txt";
        String pathOut = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\output.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathIn));
             PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut)))
        {
            String line;
            while ((line = reader.readLine()) != null) {

                writer.println(line.toUpperCase());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
