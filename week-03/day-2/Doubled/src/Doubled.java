import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Doubled {

    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt

        removeDuplicatedChar("duplicated-chars.txt", "no-duplicated-char.txt");
        System.out.println(removeDuplicatedChar("duplicated-chars.txt", "no-duplicated-char.txt"));


    }

    public static boolean removeDuplicatedChar(String nameOfFileToDecrypt, String nameOfFileToWrite) {
        Path pathToDecrypt = Paths.get(nameOfFileToDecrypt);
        Path pathToWrite = Paths.get(nameOfFileToWrite);

        List<String> allOriginalString = new ArrayList<>();

        try {
            Files.readAllLines(pathToDecrypt);
            for (String line : Files.readAllLines(pathToDecrypt)) {
                allOriginalString.add(line);
            }

            List<String> allSingleCharString = new ArrayList<>();
            for (String line : allOriginalString) {
                String singleChar ="";
                for (int i = 0; i < line.length(); i++) {
                    if (i % 2 == 0) {
                        singleChar += line.charAt(i);
                    }
                }
                allSingleCharString.add(singleChar);
            }

            Files.write(pathToWrite, allSingleCharString);

            return true;


        } catch (IOException ex) {
            System.out.println("Unable to read file.");
            return false;

        }


    }
}