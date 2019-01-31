package pirates;

public class Test {
    public static void main(String[] args) {
        Pirate blackBeard = new Pirate("Black Beard");

        Parrot pippin = blackBeard.addParrot("Pippin", "Hyacinth Macaw", "purple");

        System.out.println(blackBeard.hasAParrot);
        System.out.println(pippin.name);

        blackBeard.drinkSomeRum();
        blackBeard.drinkSomeRum();
        blackBeard.drinkSomeRum();
        blackBeard.howsItGoingMate();
        blackBeard.drinkSomeRum();
        blackBeard.drinkSomeRum();
        System.out.println(blackBeard.levelOfIntoxication);
        blackBeard.howsItGoingMate();

        System.out.println(blackBeard.levelOfIntoxication);

        lineBreak();
        Ship ship1 = new Ship("Black Pearl");
        ship1.fillShip("Jack Sparrow");
        for (int i = 0; i < 5; i++) {
            ship1.captain.drinkSomeRum();
        }
        ship1.introduceYourCaptainAndCrew();
        lineBreak();
        ship1.captain.howsItGoingMate();
        lineBreak();
        ship1.introduceYourCaptainAndCrew();
        lineBreak();
        ship1.captain.wakeUp();
        ship1.introduceYourCaptainAndCrew();
        lineBreak();

        Ship ship2 = new Ship("Flying Dutchman");
        ship2.fillShip("Davy Jones");
        ship2.introduceYourCaptainAndCrew();
        lineBreak();
        ship2.crew.get(0).die();
        ship2.crew.get(3).die();
        ship2.crew.get(4).die();
        ship2.introduceYourCaptainAndCrew();
        lineBreak();

        ship1.battle(ship2);
        ship1.introduceYourCaptainAndCrew();
        lineBreak();
        ship2.introduceYourCaptainAndCrew();
        lineBreak();




        lineBreak();


    }

    public static void lineBreak() {
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}

