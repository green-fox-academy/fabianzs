package fabian.zsofia.fox.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoxList {

    public List<Fox> foxList;

    public FoxList() {
        this.foxList = new ArrayList<>();
        initializeFoxList();
    }

    public void initializeFoxList() {
        List<String> tricks1 = new ArrayList<>(Arrays.asList("fetch", "dance"));
        List<String> tricks2 = new ArrayList<>(Arrays.asList("dance", "swim", "hunt", "fool around", "cuddle"));
        this.foxList.add(new Fox("Liza", "salmon", "water", tricks1));
        this.foxList.add(new Fox("Green", "salad", "blood", new ArrayList<>()));
        this.foxList.add(new Fox("Vuk", "chicken", "milk", tricks2));
    }

    public void addFox(Fox fox) {
        foxList.add(fox);
    }

    public boolean existFox(String name) {
        if (findFox(name) == null) {
            return false;
        } else {
            return true;
        }
    }

    public Fox findFox(String name) {
        Fox fox = foxList.stream()
                .filter(f -> f.getName().equals(name))
                .findFirst()
                .orElse(null);
        return fox;
    }

    public List<Fox> getFoxList() {
        return foxList;
    }

}
