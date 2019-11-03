import java.io.*;

public class Application {

    public static void main(String[] args) throws IOException {
        DuplicateRemove duplicateRemover = new DuplicateRemove();
        File infile = new File("problem1.txt");
        File outfile = new File("unique_words.txt");

        duplicateRemover.remove(infile);
        duplicateRemover.write(outfile);
    }
}
