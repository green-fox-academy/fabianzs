import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {
        // Write a program that asks for a number.
        // It would ask this many times to enter an integer,
        // if all the integers are entered, it should print the sum and average of these
        // integers like:
        //
        // Sum: 22, Average: 4.4

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a number: ");

        int number = scanner.nextInt();
        int sum = 0;

        System.out.println("Please enter " + number + " integers: ");


        for (int i=0; i < number; i++) {
            int integer = scanner.nextInt();
            sum = sum + integer;
        }

        /*int sum = 0;
        int i = 0;

        System.out.println("Please enter " + number + " integers: ");

        do {
            int integer = scanner.nextInt();
            sum = sum + integer;

            i++;

        } while (i < number);
*/
        double average = (double)sum / (double)number;

        System.out.println("Sum: " + sum + ", Average: " + average);

    }
}
