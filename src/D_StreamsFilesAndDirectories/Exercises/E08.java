//08. Get Folder Size
package D_StreamsFilesAndDirectories.Exercises;

import java.io.File;

class E08 {
    public static void main(String[] args) {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\Exercises Resources";

        System.out.printf("Folder size: %d", getFolderSize(new File(path)));
    }

    private static long getFolderSize (File file) {

        long length = 0L;

        if (file != null && file.exists()) {

            if (file.isDirectory()) {

                File[] files = file.listFiles();

                if (files != null) {

                    for (File f : files) {
                        length += f.isDirectory() ? getFolderSize(f) : f.length();
                    }
                }
            }
        }
        return length;
    }
}
