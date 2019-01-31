package bunny1;

public class Bunny1 {
    public static void main(String[] args) {
        // We have a number of bunnies and each bunny has two big floppy ears.
        // We want to compute the total number of ears across all the bunnies recursively (without loops or multiplication).

        System.out.println(countEars(8));


    }

    public static int countEars(int numberOfBunnies) {
        if (numberOfBunnies > 0) {
            return countEars(numberOfBunnies - 1) + 2;
        }
        return numberOfBunnies;
    }
}
