package gardenapp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Plant flower1 = new Flower("yellow");
        Plant flower2 = new Flower("blue");
        Plant tree1 = new Tree("purple");
        Plant tree2 = new Tree("orange");
        List<Plant> plants = new ArrayList<>();
        plants.add(flower1);
        plants.add(flower2);
        plants.add(tree1);

        Garden garden = new Garden();
        garden.addPlant(flower1);
        garden.addPlant(flower2);
        garden.addPlant(tree1);
        garden.addPlant(tree2);

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
