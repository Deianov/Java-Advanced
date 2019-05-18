//05. Write Every Third Line
package D_StreamsFilesAndDirectories.Lab;

import java.io.*;

class L05 {
    public static void main(String[] args) {

        String inputPath = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\input.txt";
        String outputPath = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(inputPath));
             PrintWriter out = new PrintWriter(new FileWriter(outputPath)))
        {
            String line;
            int counter = 1;

            while ((line = in.readLine()) != null) {
                if (counter++ % 3 == 0) {
                    out.println(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
