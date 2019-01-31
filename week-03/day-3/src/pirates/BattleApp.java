package pirates;

public class BattleApp {
    public static void main(String[] args) {
        Ship ship1 = new Ship("Black Pearl");
        ship1.fillShip("Jack Sparrow");
        ship1.introduceYourCaptainAndCrew();
        lineBreak();

        Ship ship2 = new Ship("Flying Dutchman");
        ship2.fillShip("Davy Jones");
        ship2.introduceYourCaptainAndCrew();
        lineBreak();

        ship1.battle(ship2);
        ship1.introduceYourCaptainAndCrew();
        lineBreak();
        ship2.introduceYourCaptainAndCrew();
        lineBreak();
    }

    public static void lineBreak() {
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
