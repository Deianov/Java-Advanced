//09. Serialize Custom Object
package D_StreamsFilesAndDirectories.Lab;

import java.io.*;

class L09 {
    public static void main(String[] args) throws IOException {

        String path = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Lab\\save.ser";

        Cube cube = new Cube("green", 15.0, 15.0, 15.0);

        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;

        try {
            // Serialization - Save objects to a file
            outputStream = new ObjectOutputStream(new FileOutputStream(path));
            outputStream.writeObject(cube);

            // Deserialization - Load objects from a file
            inputStream = new ObjectInputStream(new FileInputStream(path));
            Cube restore = (Cube) inputStream.readObject();

            // print result
            restore.print();

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

class Cube implements Serializable {
    private String color;
    private double height;
    private double width;
    private double depth;

    Cube(String color, double height, double width, double depth) {
        this.color = color;
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    void print() {
        System.out.printf("Cube: color=%s, height=%.2f  width=%.2f  depth=%.2f", this.color, this.height, this.width, this.depth);
    }
}
