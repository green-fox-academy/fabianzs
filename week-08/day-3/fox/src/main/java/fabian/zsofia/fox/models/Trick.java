package fabian.zsofia.fox.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trick {

    @Id
    private String trick;

    public Trick() {
    }

    public Trick(String trick) {
        this.trick = trick;
    }

    public String getTrick() {
        return trick;
    }
}
