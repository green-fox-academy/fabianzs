import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReversedOrder {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-lines.txt

        reverseOrderOfLines("reversed-order.txt", "non-reversed-order.txt");
        System.out.println(reverseOrderOfLines("reversed-order.txt", "non-reversed-order.txt"));


    }

    public static boolean reverseOrderOfLines(String nameOfFileToDecrypt, String nameOfFileToWrite) {
        Path pathToDecrypt = Paths.get(nameOfFileToDecrypt);
        Path pathToWrite = Paths.get(nameOfFileToWrite);

        List<String> allOriginalString = new ArrayList<>();

        try {
            Files.readAllLines(pathToDecrypt);
            for (String line : Files.readAllLines(pathToDecrypt)) {
                allOriginalString.add(line);
            }

            List<String> reversedOrderOfStrings = new ArrayList<>();

            for (int i = 0; i < allOriginalString.size() ; i++) {
                reversedOrderOfStrings.add(allOriginalString.get(allOriginalString.size() - 1 - i));
            }

            Files.write(pathToWrite, reversedOrderOfStrings);

            return true;

        } catch (IOException ex) {
            System.out.println("Unable to read file.");
            return false;

        }
    }
}