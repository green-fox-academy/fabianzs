package fabian.zsofia.fox.models;

import java.util.ArrayList;
import java.util.List;

public class Foxlist {

    List<Fox> foxList;

    public Foxlist() {
        foxList = new ArrayList<>();
        foxList.add(new Fox("Liza", "salmon", "water", 2));
        foxList.add(new Fox("Green", "salad", "blood", 0));
        foxList.add(new Fox("Vuk", "chicken", "milk", 5));
    }

    public List<Fox> returnFoxes() {
        return foxList;
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
}
