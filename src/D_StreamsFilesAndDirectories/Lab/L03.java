//03. Copy Bytes
package D_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class L03 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\";
        String inputFile = "input.txt";
        String outputFile = "output2.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path+inputFile);
             FileOutputStream fileOutputStream = new FileOutputStream(path+outputFile))
        {
            int oneByte;
            while ((oneByte = fileInputStream.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    fileOutputStream.write(oneByte);
                } else {

                    String digits = String.valueOf(oneByte);

                    for (int i = 0; i < digits.length(); i++) {
                        fileOutputStream.write(digits.charAt(i));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
