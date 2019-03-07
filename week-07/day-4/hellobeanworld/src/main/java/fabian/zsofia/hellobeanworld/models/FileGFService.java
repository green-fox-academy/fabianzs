package fabian.zsofia.hellobeanworld.models;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Qualifier("file")
public class FileGFService implements GFService {
    Path filePath;

    public FileGFService() {
        this.filePath = Paths.get("src\\main\\resources\\static\\names.txt");
    }

    @Override
    public List<String> findAll() {
        try {
            List<String> names = Files.readAllLines(this.filePath);
            return names;
        } catch (IOException ex) {
            return null;
        }
    }

    @Override
    public void save(String student) {
        List<String> names = new ArrayList<>();
        try {
            names = Files.readAllLines(this.filePath);
        } catch (IOException ex) {
        }
        names.add(student);
        try {
            Files.write(this.filePath, names);
        } catch (IOException ex) {
        }
    }

    @Override
    public int count() {
        try {
            List<String> names = Files.readAllLines(this.filePath);
            return names.size();
        } catch (IOException ex) {
            return 0;
        }
    }
}
