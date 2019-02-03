package pirates;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ship {
    String name;
    Pirate captain;
    List<Pirate> crew = new ArrayList<>();

    public Ship(String name) {
        this.name = name;
    }

    public void fillShip(String nameOfCaptain) {
        captain = new Pirate(nameOfCaptain);
        int randomNumber = new Random().nextInt(50) + 1;
        for (int i = 0; i < randomNumber; i++) {
            crew.add(new Pirate());
        }
    }

    public void introduceYourCaptainAndCrew() {
        System.out.println("The captain of the " + name + " is currently " + captain.name + ".");
        if (captain.isAlive == false) {
            System.out.println("The captain is dead.");
        } else {
            System.out.println("Our captain " + captain.name + " has drunk " + captain.levelOfIntoxication + " rounds of rum today.");
            if (captain.hasAParrot == true) {
                System.out.println("Captain has a parrot.");
            }
            if (captain.isPassedOut == true) {
                System.out.println("Captain " + captain.name + " has passed out in a brawl / from heavy drinking.");
            } else {
                System.out.println("Captain " + captain.name + " is vital and unharmed.");
            }

        }

        int aliveMembersOfTheCrew = crew.size();
        for (Pirate memberOfTheCrew : crew) {
            if (memberOfTheCrew.isAlive) {
                aliveMembersOfTheCrew++;
            }

        }

        System.out.println("The " + name + " has a fine crew of " + aliveMembersOfTheCrew + " alive pirates.");

    }

    public boolean battle (Ship anotherShip) {
        if (calculateBattleScore(anotherShip)) {
            captain.drinkSomeRum();
            int numberOfRumsForCaptain = new Random().nextInt(10);

            for (int i = 0; i < numberOfRumsForCaptain; i++) {
                captain.drinkSomeRum();
            }

            for (Pirate memberOfTheCrew : crew) {
                int numberOfRumsForCrew = new Random().nextInt(10);
                for (int i = 0; i < numberOfRumsForCrew; i++) {
                    if (memberOfTheCrew.isAlive) {
                        memberOfTheCrew.drinkSomeRum();
                    }
                }
            }

            int numberOfDeaths = new Random().nextInt(anotherShip.crew.size() + 1);
            int indexOfPirate = 0;
            while (numberOfDeaths > 0 && indexOfPirate < anotherShip.crew.size()) {
                if (anotherShip.crew.get(indexOfPirate).isAlive) {
                    anotherShip.crew.get(indexOfPirate).die();
                }
                indexOfPirate++;
                numberOfDeaths--;
            }

            return true;

        } else {
            anotherShip.captain.drinkSomeRum();
            int numberOfRumsForCaptain = new Random().nextInt(10);

            for (int i = 0; i < numberOfRumsForCaptain; i++) {
                anotherShip.captain.drinkSomeRum();
            }

            for (Pirate memberOfTheCrew : anotherShip.crew) {
                int numberOfRumsForCrew = new Random().nextInt(10);
                for (int i = 0; i < numberOfRumsForCrew; i++) {
                    if (memberOfTheCrew.isAlive) {
                        memberOfTheCrew.drinkSomeRum();
                    }
                }
            }

            int numberOfDeaths = new Random().nextInt(crew.size() + 1);
            int indexOfPirate = 0;
            while (numberOfDeaths > 0 && indexOfPirate < crew.size()) {
                if (crew.get(indexOfPirate).isAlive) {
                    crew.get(indexOfPirate).die();
                }
                indexOfPirate++;
                numberOfDeaths--;
            }

            return false;
        }
    }

    public boolean calculateBattleScore(Ship anotherShip) {
        int scoreOfThisShip = 0;
        int scoreOfAnotherShip = 0;

        for (Pirate memberOfTheCrew : crew) {
            if (memberOfTheCrew.isAlive) {
                scoreOfThisShip++;
            }
        }

        scoreOfThisShip -= captain.levelOfIntoxication;
        if (captain.isPassedOut) {
            scoreOfThisShip -= 15;
        }
        if (!captain.isAlive) {
            scoreOfThisShip = 0;
        }


        for (Pirate memberOfTheCrew : anotherShip.crew) {
            if (memberOfTheCrew.isAlive) {
                scoreOfAnotherShip++;
            }
        }

        scoreOfAnotherShip -= anotherShip.captain.levelOfIntoxication;
        if (anotherShip.captain.isPassedOut) {
            scoreOfThisShip -= 15;
        }
        if (!anotherShip.captain.isAlive) {
            scoreOfThisShip = 0;
        }


        if (scoreOfThisShip >= scoreOfAnotherShip) {
            return true;
        } else {
            return false;
        }
    }


}
