package zoo.main.java.animals;

public class Mammal extends Animal {
    boolean hasFur;
    String furLength;
    String locomotion;

    public Mammal(String name) {
        super(name);
    }

    public void nurse() {

    }

    public void changeHair() {

    }

    @Override
    public String breed() {
        return "pushing miniature versions out";
    }

    @Override
    public String move() {
        return null;
    }
}
