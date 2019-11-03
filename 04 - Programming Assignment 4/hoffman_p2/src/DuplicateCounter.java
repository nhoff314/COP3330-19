import java.util.*;
import java.io.*;

public class DuplicateCounter {

    private static Map<String, Integer> wordCounter = new HashMap<>();

    public static void count(File dataFile) throws IOException{
        Scanner readFile = new Scanner(dataFile);
        int cnt;
        String word;

        System.out.println("Opening file...");
        FileInputStream openFile = new FileInputStream(dataFile);
        readFile = new Scanner(openFile);

        System.out.println("Counting unique words...");
        wordCounter.put(readFile.next(), 1);
        while (readFile.hasNext()) {
            word = readFile.next();
            if (wordCounter.containsKey(word)) {
                cnt = wordCounter.get(word);
                wordCounter.put(word, ++cnt);
            }
            else {
                wordCounter.put(word, 1);
            }
        }
        System.out.println(wordCounter);

    }

    public static void write(File outputFile) throws IOException{
        System.out.println("Opening output file...");
        FileOutputStream openFile = new FileOutputStream(outputFile);
        PrintWriter writeFile = new PrintWriter(openFile);

        System.out.println("Pasting Data...");
        writeFile.print(wordCounter);
        writeFile.flush();

        System.out.println("Closing file...");
        openFile.close();
        System.out.println("Counting complete...");
    }
}
