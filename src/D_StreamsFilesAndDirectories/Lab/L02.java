//02. Write to File
package D_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class L02 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\";
        String inputFile = "input.txt";
        String outputFile = "output.txt";

        List<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '.', ',', '!', '?');

        try (FileInputStream fileInputStream = new FileInputStream(path+inputFile);
             OutputStream outputStream = new FileOutputStream(path+outputFile))
        {
            int oneByte;
            while ((oneByte = fileInputStream.read()) >= 0) {
                if (!symbols.contains((char)oneByte)) {
                    outputStream.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
