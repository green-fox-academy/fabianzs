// Loads the scanner to the file
import java.util.Scanner;

public class HelloUser {
    public static void main(String[] args) {
        // Creates a scanner
        Scanner scanner = new Scanner(System.in);

        //The program asks for the User's name
        System.out.println("Please enter your name: ");

        // The program stops and waits for user input and to press enter
        String username = scanner.nextLine();

        // Modify this program to greet user instead of the World!
        // The program should ask for the name of the user
        System.out.println("Hello, " + username + "!");









    }
}
