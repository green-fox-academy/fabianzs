import java.util.Scanner;


public class PrintBigger {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Write a program that asks for two numbers and prints the bigger one

        System.out.println("Please enter two numbers: ");

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        if (a > b) {
            System.out.println("The bigger number is: " + a);
        } else if (a == b) {
            System.out.println("The numbers are equal: " + a);
        } else {
            System.out.println("The bigger number is: " + b);
        }
    }
}
