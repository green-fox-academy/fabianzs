package farm;

import java.util.ArrayList;
import java.util.List;

public class Farm {
    List<Animal> animals;
    int slot;

    public Farm() {
        this.animals = new ArrayList<>();
    }

    public void breed() {
        if (slot > 0) {
            animals.add(new Animal());
            slot--;
        }
    }

    public void slaughter() {
        //List<Animal> temp = new ArrayList<>();

        int leastHungry = animals.get(0).hunger;
        int indexToRemove = animals.size();
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).hunger < leastHungry) {
                leastHungry = animals.get(i).hunger;
                indexToRemove = i;
            }
        }

        animals.remove(indexToRemove);

        slot++;

    }
}
