//06. Sort Lines
package D_StreamsFilesAndDirectories.Lab;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

class L06a {
    public static void main(String[] args) {

        String inputPath = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\input-sort.txt";
        String outputPath = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\output.txt";

        File file = new File(inputPath);

        Path pathIn = file.toPath();
        Path pathOut = Paths.get(outputPath);

        try
        {
            List<String> lines = Files.readAllLines(pathIn);
            Collections.sort(lines);

            Files.write(pathOut, lines);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
