import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 * ---
 * Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.
 **/
class PowerOfThor {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int lightX = in.nextInt(); // the X position of the light of power
        int lightY = in.nextInt(); // the Y position of the light of power
        int initialTX = in.nextInt(); // Thor's starting X position
        int initialTY = in.nextInt(); // Thor's starting Y position

        // game loop
        while (true) {
            int remainingTurns = in.nextInt(); // The remaining amount of turns Thor can move. Do not remove this line.
            if ((initialTX < lightX) && (initialTY < lightY)) {
                System.out.println("SE");
                initialTX++;
                initialTY++;
            }

            if ((initialTX < lightX) && (initialTY == lightY)) {
                System.out.println("E");
                initialTX++;
            }

            if ((initialTX < lightX) && (initialTY > lightY)) {
                System.out.println("NE");
                initialTX++;
                initialTY--;
            }

            if ((initialTX == lightX) && (initialTY > lightY)) {
                System.out.println("N");
                initialTY--;
            }

            if ((initialTX == lightX) && (initialTY < lightY)) {
                System.out.println("S");
                initialTY++;
            }

            if ((initialTX > lightX) && (initialTY < lightY)) {
                System.out.println("SW");
                initialTX--;
                initialTY++;
            }

            if ((initialTX > lightX) && (initialTY == lightY)) {
                System.out.println("W");
                initialTX--;
            }

            if ((initialTX > lightX) && (initialTY > lightY)) {
                System.out.println("NW");
                initialTX--;
                initialTY--;
            }

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // A single line providing the move to be made: N NE E SE S SW W or NW

        }
    }
}