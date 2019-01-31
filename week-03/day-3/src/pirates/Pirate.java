package pirates;

import java.util.Random;

public class Pirate {

    String name;
    int levelOfIntoxication;
    boolean isAlive;
    boolean isPassedOut;
    boolean hasAParrot;

    public Pirate() {
        levelOfIntoxication = 0;
        isAlive = true;
        isPassedOut = false;
        hasAParrot = false;
    }

    public Pirate(String name) {
        this.name = name;
        levelOfIntoxication = 0;
        isAlive = true;
        hasAParrot = false;
    }

    public void drinkSomeRum() {
        if (isAlive != true) {
            System.out.println("He's dead.");
        } else {
            levelOfIntoxication++;
        }
    }

    public void howsItGoingMate() {
        if (isAlive != true) {
            System.out.println("He's dead.");
        } else {
            if (levelOfIntoxication < 5) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                isPassedOut = true;
                sleep();
            }
        }
    }

    public void sleep() {
        if (isAlive != true) {
            System.out.println("He's dead.");
        } else {
            levelOfIntoxication = 0;
        }
    }

    public void wakeUp() {
        if(isAlive != true) {
            System.out.println("He's dead.");
        } else {
            isPassedOut = false;
        }
    }

    public void die() {
        isAlive = false;
    }

    public void passOut() {
        if(isAlive != true) {
            System.out.println("He's dead.");
        } else {
            isPassedOut = true;
        }
    }

    public void brawl(Pirate anotherPirate) {
        if(isAlive != true){
            System.out.println("He's dead.");
        } else {
            if (anotherPirate.isAlive = true) {
                int whoWillWin = new Random().nextInt(3);
                switch (whoWillWin) {
                    case 0:
                        die();
                        break;
                    case 1:
                        anotherPirate.die();
                        break;
                    case 2:
                        passOut();
                        anotherPirate.passOut();
                        break;
                }
            }
        }
    }

    public Parrot addParrot(String name, String type, String color) {
        hasAParrot = true;
        return new Parrot(name, type, color);
    }
}
