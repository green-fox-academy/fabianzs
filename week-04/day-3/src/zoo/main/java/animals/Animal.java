package zoo.main.java.animals;

public abstract class Animal {
    protected String name;
    protected int age;
    protected String gender;
    protected String color;
    protected int numberOfLegs;
    protected String bodyCoverage;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String breed();

    public abstract String move();
}
