import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {
        // Write a program that asks for two integers
        // The first represents the number of chickens the farmer has
        // The second represents the number of pigs owned by the farmer
        // It should print how many legs all the animals have

        Scanner scanner = new Scanner(System.in);

        System.out.println("A farmer owns chickens and pigs.");

        System.out.println("Please enter the number of chickens: ");
        int chickens = scanner.nextInt();

        System.out.println("Please enter the number of pigs: ");
        int pigs = scanner.nextInt();

        int legs = chickens *2 + pigs * 4;

        System.out.println("The animals have " + legs + " legs in total.");


    }
}
