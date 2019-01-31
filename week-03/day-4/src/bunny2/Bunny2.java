package bunny2;

public class Bunny2 {
    public static void main(String[] args) {
        // We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
        // (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
        // have 3 ears, because they each have a raised foot. Recursively return the
        // number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).

        System.out.println(countOddEvenEars(5));
    }

    public static int countOddEvenEars(int numberOfBunnies) {
        if (numberOfBunnies > 0) {
            if (numberOfBunnies % 2 == 1) {
                return countOddEvenEars(numberOfBunnies - 1) + 2;
            } else {
                return countOddEvenEars(numberOfBunnies - 1) + 3;
            }
        }
        return numberOfBunnies;
    }
}
