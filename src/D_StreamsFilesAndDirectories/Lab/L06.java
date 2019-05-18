//06. Sort Lines
package D_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

class L06 {
    public static void main(String[] args) {

        String inputPath = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\input-sort.txt";
        String outputPath = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\output.txt";

        File file = new File(inputPath);
        Path path = file.toPath();

        try (PrintWriter output = new PrintWriter(new FileOutputStream(outputPath)))
        {
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);

            for (String line: lines) {
                output.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
