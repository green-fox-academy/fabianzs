package fabian.zsofia.fox.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Drink {

    @Id
    private String drink;

    public Drink() {
    }

    public Drink(String drink) {
        this.drink = drink;
    }

    public String getDrink() {
        return drink;
    }
}
