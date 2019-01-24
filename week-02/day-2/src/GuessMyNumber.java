import java.util.Scanner;

public class GuessMyNumber {
    /* Exercise
   Write a program where the program chooses a number between 1 and 100. The player is then asked to enter a guess. If the player guesses wrong, then the program gives feedback and ask to enter an other guess until the guess is correct.

   Make the range customizable (ask for it before starting the guessing).
   You can add lives. (optional)
   Example
   I've the number between 1-100. You have 5 lives.

           20

   Too high. You have 4 lives left.

           10

   Too low. You have 3 lives left.

           15

   Congratulations. You won!*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberToGuess = (int) ((Math.random() * 100 + 1));

        System.out.println("I've the number between 1-100. You have 5 lives.");

        int guessedNumber;
        int lives = 5;




        do {
            guessedNumber = scanner.nextInt();

            if (guessedNumber == numberToGuess) {
                System.out.println("Congratulations. You won!");
            } else if (guessedNumber > numberToGuess) {
                lives = lives - 1;
                System.out.println("Too high. You have " + lives + " lives left.");
            } else {
                lives = lives - 1;
                System.out.println("Too low. You have " + lives + " lives left.");
            }
        }
        while (lives != 0);

        System.out.println("\nYou have lost the game. The number I had was " + numberToGuess + ".");



    }



}
