import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedLines {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-lines.txt

        reverseAllLines("reversed-lines.txt", "non-reversed-lines.txt");
        System.out.println(reverseAllLines("reversed-lines.txt", "non-reversed-lines.txt"));


    }

    public static boolean reverseAllLines(String nameOfFileToDecrypt, String nameOfFileToWrite) {
        Path pathToDecrypt = Paths.get(nameOfFileToDecrypt);
        Path pathToWrite = Paths.get(nameOfFileToWrite);

        List<String> allOriginalString = new ArrayList<>();

        try {
            Files.readAllLines(pathToDecrypt);
            for (String line : Files.readAllLines(pathToDecrypt)) {
                allOriginalString.add(line);
            }

            List<String> allReversedString = new ArrayList<>();
            for (String line : allOriginalString) {
                String reversedString ="";
                for (int i = 0; i < line.length(); i++) {
                        reversedString += line.charAt(line.length() - 1 - i);
                }
                allReversedString.add(reversedString);
            }

            Files.write(pathToWrite, allReversedString);

            return true;

        } catch (IOException ex) {
            System.out.println("Unable to read file.");
            return false;

        }
    }
}