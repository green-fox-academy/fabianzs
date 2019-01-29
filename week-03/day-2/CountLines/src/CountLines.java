import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
        // Write a function that takes a filename as string,
        // then returns the number of lines the file contains.
        // It should return zero if it can't open the file, and
        // should not raise any error.

        String fileName = "count_lines_text.txt";
        System.out.println(countLines(fileName));
    }


    public static int countLines (String fileName) {
        Path fileToRead = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(fileToRead);
            int numberOfLines = lines.size();
            return numberOfLines;

        } catch (IOException ex) {
            return 0;
        }

    }
}
