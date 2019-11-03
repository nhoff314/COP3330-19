import java.util.*;
import java.io.*;



public class DuplicateRemove {

    private static String uniqueWords;

    public static void remove(File dataFile) throws IOException {
        Scanner readFile = new Scanner(dataFile);
        Set<String> wordSet = new HashSet<>();

        System.out.println("Opening file...");
        FileInputStream openFile = new FileInputStream(dataFile);
        readFile = new Scanner(openFile);

        System.out.println("Copying unique words...");
        while (readFile.hasNext())
            wordSet.add(readFile.next());

        uniqueWords = String.join(" ", wordSet);
    }

    public static void write(File outputFile) throws IOException {
        System.out.println("Opening output file...");
        FileOutputStream openFile = new FileOutputStream(outputFile);
        PrintWriter writeFile = new PrintWriter(openFile);

        System.out.println("Pasting Data...");
        writeFile.print(uniqueWords);
        writeFile.flush();

        System.out.println("Closing file...");
        openFile.close();
        System.out.println("Duplicate removal complete...");
    }
}
