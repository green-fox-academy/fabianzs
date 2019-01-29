import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {
        // Write a function that copies a file to an other
        // It should take the filenames as parameters
        // It should return a boolean that shows if the copy was successful

        copyFile("fight_club_quotes.txt", "copyof_fight_club_quotes.txt");
        System.out.println(copyFile("fight_club_quotes.txt", "copyof_fight_club_quotes.txt"));


    }

    public static boolean copyFile (String fileToCopy, String fileToWrite) {
        Path pathOfFileToCopy = Paths.get(fileToCopy);
        Path pathOfFileToWrite = Paths.get(fileToWrite);

        try {
            List<String> linesToCopy = new ArrayList<>();
            for (String lines : Files.readAllLines(pathOfFileToCopy)) {
                linesToCopy.add(lines);
            }
            Files.write(pathOfFileToWrite, linesToCopy);
            return true;
        } catch (IOException ex) {
            return false;
        }



    }
}
