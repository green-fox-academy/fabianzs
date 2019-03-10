package fabian.zsofia.hundredacrewood.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InhabitantList {

    List<Inhabitant> inhabitants;

    public InhabitantList() {
        this.inhabitants = new ArrayList<>();
        initializeList();
    }

    public void initializeList() {
        inhabitants.add(new Inhabitant("Micimackó", 4, Gender.MALE));
        inhabitants.add(new Inhabitant("Kanga", 7, Gender.FEMALE));
        inhabitants.add(new Inhabitant("Malacka", 3, Gender.MALE));
        inhabitants.add(new Inhabitant("Tigris", 2, Gender.MALE));
        inhabitants.add(new Inhabitant("Nyuszi", 5, Gender.FEMALE));
        inhabitants.add(new Inhabitant("Bagoly", 4, Gender.MALE));
    }

    public List<Inhabitant> getInhabitants() {
        return inhabitants;
    }

    public Inhabitant getInhabitantById(int id) {
      /*  for (Inhabitant inhabitant : inhabitants) {
            if (inhabitant.getId() == id) {
                return inhabitant;
            }
        }

        return null;*/

        return inhabitants.stream()
                .filter(i -> i.getId() == id)
                .findAny()
                .orElse(null);
    }

    public void addInhabitant(Inhabitant inhabitant) {
        inhabitants.add(inhabitant);
    }
}
