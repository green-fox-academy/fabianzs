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
    }

    public void war(Armada anotherArmada) {

    }
}
