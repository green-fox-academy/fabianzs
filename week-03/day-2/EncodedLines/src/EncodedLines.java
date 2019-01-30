import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EncodedLines {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-lines.txt

        decodeAllLines("encoded-lines.txt", "decoded-lines.txt");
        System.out.println(decodeAllLines("encoded-lines.txt", "decoded-lines.txt"));


    }

    public static boolean decodeAllLines(String nameOfFileToDecrypt, String nameOfFileToWrite) {
        Path pathToDecrypt = Paths.get(nameOfFileToDecrypt);
        Path pathToWrite = Paths.get(nameOfFileToWrite);

        List<String> allOriginalString = new ArrayList<>();

        try {
            Files.readAllLines(pathToDecrypt);
            for (String line : Files.readAllLines(pathToDecrypt)) {
                allOriginalString.add(line);
            }


            List<String> allDecodedString = new ArrayList<>();
            for (String line : allOriginalString) {
                char[] stringToCharArray = new char[line.length()];
                String decodedString ="";
                for (int i = 0; i < line.length(); i++) {
                    stringToCharArray[i] = line.charAt(i);
                    stringToCharArray[i]--;
                    decodedString += stringToCharArray[i];
                }
                allDecodedString.add(decodedString);
            }

            Files.write(pathToWrite, allDecodedString);

            return true;

        } catch (IOException ex) {
            System.out.println("Unable to read file.");
            return false;

        }
    }
}