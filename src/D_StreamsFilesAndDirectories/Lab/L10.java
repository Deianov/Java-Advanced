//10. Serialize Object
package D_StreamsFilesAndDirectories.Lab;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class L10 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\save.txt";

        List<String> names = new ArrayList<>();
        Collections.addAll(names, "Mimi", "Gosho");

        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            // Serialization - Save objects to a file
            outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(names);

            // Deserialization - Load objects from a file
            inputStream = new ObjectInputStream(new FileInputStream(path));
            List<String> restore = (List<String>)inputStream.readObject();

            // print result
            System.out.println(restore.toString());

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());

        } finally {
            if (outputStream != null) {
                outputStream.close();
            }

            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}
