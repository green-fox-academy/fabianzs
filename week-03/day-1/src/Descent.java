import java.util.*;
import java.io.*;
import java.math.*;

/**
 * The while loop represents the game.
 * Each iteration represents a turn of the game
 * where you are given inputs (the heights of the mountains)
 * and where you have to print an output (the index of the mountain to fire on)
 * The inputs you are given are automatically updated according to your last actions.
 **/
class Descent {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int[] mountainHeight = new int[8];
            for (int i = 0; i < 8; i++) {
                int mountainH = in.nextInt(); // represents the height of one mountain.
                mountainHeight[i] = mountainH;
            }

            int maxValue = 0;

            for (int i = 0; i < 8; i++) {
                if (mountainHeight[i] > maxValue) {
                    maxValue = mountainHeight[i];
                }
            }

            int i = 0;
            while (mountainHeight[i] != maxValue) {
                i++;
            }
            System.out.println(i);








            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");

            // The index of the mountain to fire on.
        }
    }
}