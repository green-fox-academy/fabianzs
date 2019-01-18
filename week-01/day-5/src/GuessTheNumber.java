import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {

        int numberToGuess = 46;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");

        // Write a program that stores a number, and the user has to figure it out.
        // The user can input guesses, after each guess the program would tell one
        // of the following:
        //
        // The stored number is higher
        // The stried number is lower
        // You found the number: 8

        int guessedNumber;

        do {
            guessedNumber = scanner.nextInt();

            if (guessedNumber < numberToGuess) {
                System.out.println("The stored number is higher");
            } else if (guessedNumber > numberToGuess) {
                System.out.println("The stored number is lower");
            } else {

            }
        } while (guessedNumber != numberToGuess);

        System.out.println("You found the number: " + numberToGuess);
    }
}
