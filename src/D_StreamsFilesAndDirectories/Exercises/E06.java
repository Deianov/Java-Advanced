//06. Word Count
package D_StreamsFilesAndDirectories.Exercises;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

class E06 {
    public static void main(String[] args) {

        String pathIn = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\words.txt";
        String pathCheck = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\text.txt";
        String pathOut = "D:\\Users\\Google Drive\\development\\_modules\\03_Advanced\\04_Exercises\\output.txt";

        HashMap<String, Word> words = new HashMap<>();

        try (Scanner scanner = new Scanner(new File(pathIn));
             Scanner checker = new Scanner(new File(pathCheck));
             PrintWriter writer = new PrintWriter(new FileOutputStream(pathOut)))
        {
            while (scanner.hasNext()) {
                String text = scanner.next();
                words.putIfAbsent(text, new Word(text));
            }

            while (checker.hasNext()) {
                String text = checker.next();
                if (words.containsKey(text)) {
                    words.get(text).plus();
                }
            }

            words.values()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getCount(), a.getCount()))
                    .forEach(e -> writer.printf("%s - %d%n", e.getText(), e.getCount()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Word {
    private String text;
    private int count;

    Word(String text) {
        this.text = text;
        this.count = 0;
    }

    String getText() { return text; }
    public int getCount() { return count; }

    void plus() {
        this.count++;
    }
}
