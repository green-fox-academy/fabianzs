import java.util.Scanner;

public class DrawDiamond {
    public static void main(String[] args) {

        // Write a program that reads a number from the standard input, then draws a
        // diamond like this:
        //
        //
        //    *
        //   ***
        //  *****
        // *******
        //  *****
        //   ***
        //    *
        //
        // The diamond should have as many lines as the number was

        Scanner scanner = new Scanner(System.in);
        int numberOfRows;
        System.out.println("Please enter an odd number: ");

        do {
            numberOfRows = scanner.nextInt();
            System.out.println("You have entered an even number. Please enter an odd number: ");

        } while ( numberOfRows % 2 == 0);


        int halfOfRows = (numberOfRows + 1) / 2;


        System.out.println();

        for (int i = 0; i < halfOfRows; i++) {
            for (int j = 0; j < halfOfRows - 1 - i; j++ ) {
                System.out.print(" ");
            }
            for (int k = 0; k <= (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = halfOfRows - 1; i > 0; i--) {

            for (int j = halfOfRows; j > i; j-- ) {
                System.out.print(" ");
            }

            for (int k = 0; k < (i * 2) -1; k++) {
                System.out.print("*");
            }

            System.out.println();
        }


    }

}
