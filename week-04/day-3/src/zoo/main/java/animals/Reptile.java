package zoo.main.java.animals;

public class Reptile extends Animal {
    boolean isHibernated;
    boolean isPoisonous;

    public Reptile(String name) {
        super(name);
    }

    public void throwSkin() {

    }

    public void hibernate() {
        this.isHibernated = true;
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public String move() {
        return null;
    }

}
