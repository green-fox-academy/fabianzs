package fabian.zsofia.fox.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Food {

    @Id
    private String food;

    public Food() {
    }

    public Food(String food) {
        this.food = food;
    }

    public String getFood() {
        return food;
    }
}
