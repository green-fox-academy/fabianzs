package aircraftcarrier;

import java.util.ArrayList;
import java.util.List;

public class Carrier {
    List<Aircraft> aircrafts;
    int ammo;
    int healthPoints;

    public Carrier(List<Aircraft> aircrafts, int ammo, int healthPoints) {
        this.aircrafts = aircrafts;
        this.ammo = ammo;
        this.healthPoints = healthPoints;
    }

    public Carrier(int ammo, int healthPoints) {
        this.aircrafts = new ArrayList<>();
        this.ammo = ammo;
        this.healthPoints = healthPoints;
    }

    public void add(Aircraft aircraft) {
        this.aircrafts.add(aircraft);
    }

    public void fill() {
        if (this.ammo < 0) {
            throw new IllegalArgumentException("The aircraft has no ammo.");
        }
        for (Aircraft aircraft : this.aircrafts) {
            if (aircraft.isPriority()) {
                this.ammo = aircraft.refill(this.ammo);
            }
        }
        for (Aircraft aircraft : this.aircrafts) {
            if (!aircraft.isPriority()) {
                this.ammo = aircraft.refill(this.ammo);
            }
        }
    }

    public void fight(Carrier anotherCarrier) {
        for (Aircraft aircraft : this.aircrafts) {
            anotherCarrier.healthPoints -= aircraft.fight();
        }
        if (anotherCarrier.healthPoints < 0) {
            anotherCarrier.healthPoints = 0;
        }
    }

    public String getStatus() {
        if (this.healthPoints == 0) {
            return "It's dead Jim :(";
        }
        String status = "HP: " + this.healthPoints + ", Aircraft count: " + this.aircrafts.size() + ", Ammo Storage: " + this.ammo + ", Total damage: " + this.calculateTotalDamage() + System.lineSeparator() + "Aircrafts: " + System.lineSeparator();
        for (Aircraft aircraft : this.aircrafts) {
            status += aircraft.getStatus() + System.lineSeparator();
        }
        return status;
    }

    public int calculateTotalDamage() {
        int damage = 0;
        for (Aircraft aircraft : this.aircrafts) {
            damage += aircraft.baseDamage * aircraft.ammo;
        }
        return damage;
    }


}
