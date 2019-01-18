import java.util.Scanner;

public class DrawPyramid2 {
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

        /*for (int a = 0; a <numberOfRows; a++) {

            for (int b = a; b < numberOfRows; b++) {
                System.out.print(" ");
            }

            for (int c = 0; c <= (a * 2) ; c++) {
                System.out.print("*");
            }

            System.out.println();
        }*/

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = numberOfRows; j > i; j--) {
                System.out.print(" ");
            }

            for (int k = 0; k <= (i * 2); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}