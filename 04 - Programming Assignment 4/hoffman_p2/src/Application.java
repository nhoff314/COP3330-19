import java.io.*;

public class Application {
    public static void main(String[] args) throws IOException{
        DuplicateCounter duplicateCounter = new DuplicateCounter();
        File infile = new File("problem2.txt");
        File outfile = new File("unique_word_counts.txt");

        duplicateCounter.count(infile);
        duplicateCounter.write(outfile);
    }
}
