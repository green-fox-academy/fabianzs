// Loads the scanner to the file
import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        // Creates a scanner
        Scanner scanner = new Scanner(System.in);

        // Write a program that asks for an integer that is a distance in kilometers,
        // then it converts that value to miles and prints it

        System.out.println("Please enter your distance in kilometers: ");

        // The program stops and waits for user input and to press enter
        int kilometers = scanner.nextInt();

        double miles = kilometers * 0.6214;

        System.out.println("Your distance in miles is: " + miles);
    }
}
