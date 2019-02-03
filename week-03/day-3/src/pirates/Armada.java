package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Armada {
    String name;
    Ship flagShip;
    List<Ship> armada = new ArrayList<>();

    public Armada(String name) {
        this.name = name;
    }

    public void fillArmada(String nameOfFlagShip) {
        flagShip = new Ship(nameOfFlagShip);
        int randomNumber = new Random().nextInt(50) + 1;
        for (int i = 0; i < randomNumber; i++) {
            armada.add(new Ship("randomShip"));
        }

        for (int i = 0; i < armada.size(); i++) {
            armada.get(i).fillShip("randomCaptain");
        }
    }

    public boolean war(Armada anotherArmada) {
        int indexOfThisArmada = 0;
        int indexOfAnotherArmada = 0;
            while (indexOfThisArmada < this.armada.size() && indexOfAnotherArmada < anotherArmada.armada.size()) {
                if (this.armada.get(indexOfThisArmada).battle(anotherArmada.armada.get(indexOfAnotherArmada))) {
                    indexOfAnotherArmada++;
                } else {
                    indexOfThisArmada++;
                }

            }

        if (indexOfThisArmada == this.armada.size()) {
            return false;
        } else {
            return true;
        }


    }
}
