import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {
        // Write a program that reads a number from the standard input, then draws a
        // square like this:
        //
        //
        // %%%%%
        // %%  %
        // % % %
        // %  %%
        // %%%%%
        //
        // The square should have as many lines as the number was

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a number: ");
        int numberOfRows = scanner.nextInt();

        System.out.println();

      /*  //Draws the lines, j specifies in which line we are in
        for (int j = 0; j < numberOfRows; j++) {
            if (j == 0) {
                //If we are in the first line, it should draw as many % symbols as many lines are
                for (int i = 0; i < numberOfRows; i++) {
                    System.out.print("%");
                }
            //If we are in the last line, it should draw as many % symbols as many lines are
            } else if (j == numberOfRows -1) {
                for (int l = 0; l < numberOfRows; l++) {
                    System.out.print("%");
                }
            //If we are in any other line: 0 < j < numberOfRows -1
            } else {
                for (int k = 0; k < numberOfRows; k++) {
                    //First column should be %
                    if (k == 0) {
                        System.out.print("%");
                    //Last column should be %
                    } else if (k == numberOfRows - 1) {
                        System.out.print("%");
                    //If row = column it should print %
                    } else if (k == j) {
                        System.out.print("%");
                    } else {
                        System.out.print(" ");
                    }
                }
            }

            System.out.println();
        }*/

      for (int i = 0; i < numberOfRows; i++) {
          for (int j = 0; j < numberOfRows; j++) {
              if (i == 0 || i == numberOfRows - 1 || j == 0 || j == numberOfRows - 1 || i == j ) {
                  System.out.print("%");
              } else {
                  System.out.print(" ");
              }

          }
          System.out.println();
      }

    }
}
