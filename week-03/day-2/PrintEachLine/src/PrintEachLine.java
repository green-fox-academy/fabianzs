import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.List;

public class PrintEachLine {
    public static void main(String[] args) {
        // Write a program that opens a file called "my-file.txt", then prints
        // each line from the file.
        // If the program is unable to read the file (for example it does not exist),
        // then it should print the following error message: "Unable to read file: my-file.txt"

        Path myFile = Paths.get("my-file.txt");
        System.out.println(Files.isReadable(myFile));
        try {
            List<String> lines = Files.readAllLines(myFile);
            for (String everyLine : lines) {
                System.out.println(everyLine);
            }

        } catch (IOException ex) {
            System.out.println("Unable to read file: my-file.txt");
        }



    }
}