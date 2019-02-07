package flyable;

import zoo.main.java.animals.Animal;

public class Bird extends Animal implements Flyable {
    public Bird(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return null;
    }

    @Override
    public String move() {
        return null;
    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void takeOff() {

    }
}
