import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileBasics {
    public static void main(String[] args) {
        Path fightClub = Paths.get("quotes.txt");
        Path test = Paths.get("testtext.txt");
        Files.isReadable(fightClub);
        Files.isWritable(fightClub);
        Files.isDirectory(fightClub);
        try {
            List<String> quotes = Files.readAllLines(fightClub);
            for (String everyLine : Files.readAllLines(fightClub)) {
                System.out.println(everyLine);
            }

            Files.lines(Paths.get("testtext.txt"));
                // .map(line -> line.toUpperCase());
                // .filter(line -> line.startsWith(" ")
                // .forEach(line -> System.out.println(line);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
