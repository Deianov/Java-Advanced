//07. List Files
package D_StreamsFilesAndDirectories.Lab;

import java.io.File;

class L07 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\Files-and-Streams";

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {

                File[] files = file.listFiles();

                for (File f : files) {

                    if (!f.isDirectory()) {
                        System.out.printf("%s: [%s]%n", f.getName(), f.length());
                    }
                }
            }
        }
    }
}
