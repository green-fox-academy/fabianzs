package zoo.main.java.animals;

public class Bird extends Animal {
    boolean ableToFly;
    boolean isMigratory;

    public Bird(String name) {
        super(name);
    }

    public void buildNest() {

    }

    public void hatchEgg() {

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
