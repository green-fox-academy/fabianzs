import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {

        // Write a program that reads a number from the standard input, then draws a
        // pyramid like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //
        // The pyramid should have as many lines as the number was

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number: ");

        int numberOfRows = scanner.nextInt();

        System.out.println();

        int numberOfStars = 2 * numberOfRows - 1;

        //Sorok rajzolása
        for (int i = 0; i < numberOfStars; i += 2) {

            //Szóközök rajzolása
            for (int j = numberOfStars - 1 ; j > i; j -= 2 ) {
                System.out.print(" ");
            }

            //Csillagok rajzolása
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
               }
            System.out.println();
        }

    }
}
