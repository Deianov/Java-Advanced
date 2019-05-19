//02. Sum Bytes
package D_StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class E02 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\input.txt";

        try (BufferedReader input = new BufferedReader(new FileReader(path)))
        {
            String line;
            long sum = 0;
            while ((line = input.readLine()) != null) {

                sum += line.chars().sum();
            }
            System.out.println(sum);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
