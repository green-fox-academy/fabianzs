import com.sun.xml.internal.ws.util.StringUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SwearWords {

    public static void main(String[] args) {
        // There is a not so family friendly text in the `content.txt`
        // Create a function named familyFriendlizer that takes a filename and a list of strings as parameters
        // and remove all the given words from the file and returns the amount of the removed words.

        ArrayList<String> offensiveWords = new ArrayList<>(Arrays.asList("fuck", "bloody", "cock", "shit", "fucker", "fuckstick", "asshole", "dick", "piss"));
        System.out.println(familyFriendlizer("content.txt", offensiveWords)); // should print out 17
    }

    public static int familyFriendlizer(String fileName, ArrayList<String> offensiveWords) {

        List<String> familyFriendlyText = new ArrayList<>();
        int counter = 0;
        List<String> originalLines = readFile(fileName);
        StringLengthComparator stringLengthComparator = new StringLengthComparator();
        Collections.sort(offensiveWords, stringLengthComparator);
        for (String line : originalLines) {
            for (String swearWord : offensiveWords) {
                while (line.contains(swearWord)) {
                    line = line.replaceFirst(swearWord, "");
                    counter++;
                }
                while (line.contains(StringUtils.capitalize(swearWord))) {
                    line = line.replaceFirst(StringUtils.capitalize(swearWord), "");
                    counter++;
                }
            }
            line = line.replaceAll("\\s+", " ").trim();
            line = line.replaceAll("\\s+(?=[(),.!?;])", "");
            familyFriendlyText.add(line);
        }
        writeFile(fileName, familyFriendlyText);
        return counter;
    }

    public static List<String> readFile (String fileName){
        List<String> originalLines = new ArrayList<>();
        try {
            Path filePath = Paths.get(fileName);
            for (String line : Files.readAllLines(filePath)) {
                originalLines.add(line);
            }
        } catch (IOException ex) {
            System.out.println("File is not found.");
        }
        return originalLines;
    }

    public static void writeFile (String fileName, List<String> lines) {
        try {
            Path filePath = Paths.get(fileName);
            Files.write(filePath, lines);
        } catch (IOException ex) {
            System.out.println("File is not found.");
        }
    }
}
