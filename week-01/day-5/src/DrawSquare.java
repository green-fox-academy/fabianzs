import java.util.Scanner;

public class DrawSquare {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%%
        // %    %
        // %    %
        // %    %
        // %    %
        // %%%%%%
        //
        // The square should have as many lines as the number was

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int numberOfRows = scanner.nextInt();

        System.out.println();


        for (int j = 0; j < numberOfRows; j++) {
            if (j == 0) {
                for (int i = 0; i < numberOfRows; i++) {
                    System.out.print("%");
                }
            } else if (j == numberOfRows -1) {
                for (int i = 0; i < numberOfRows; i++) {
                    System.out.print("%");
                }
                System.out.println();
            } else {
                for (int k = 0; k < numberOfRows; k++) {
                    if (k == 0) {
                        System.out.print("%");
                    } else if (k == numberOfRows - 1) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }

    }
}
