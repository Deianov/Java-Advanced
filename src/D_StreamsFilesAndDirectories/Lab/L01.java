//01.Read File
package D_StreamsFilesAndDirectories.Lab;

import java.io.FileInputStream;
import java.io.IOException;

class L01 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\";
        String file = "input.txt";

        try (FileInputStream fileInputStream = new FileInputStream(path + file)) {
            int oneByte;
            while ((oneByte = fileInputStream.read()) >= 0) {

                System.out.printf("%s ", Integer.toBinaryString(oneByte));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
