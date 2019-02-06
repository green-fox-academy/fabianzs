package gardenapp;

public class Main {
    public static void main(String[] args) {

        Garden garden = new Garden();
        garden.addPlant(new Flower("yellow"));
        garden.addPlant(new Flower("blue"));
        garden.addPlant(new Tree("purple"));
        garden.addPlant(new Tree("orange"));

        garden.getState();
        printLine();
        garden.water(40);
        printLine();
        garden.water(70);

    }

    public static void printLine() {
        System.out.println();
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }
}
