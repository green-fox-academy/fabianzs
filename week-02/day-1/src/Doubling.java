public class Doubling {
    public static void main(String[] args) {
        // - Create an integer variable named `baseNum` and assign the value `123` to it
        // - Create a function called `doubling` that doubles it's input parameter and returns with an integer
        // - Print the result of `doubling(baseNum)`

        int baseNum = 123;

        System.out.println("The double of " + baseNum + " is " + doubling(baseNum));
    }

    public static int doubling (int number) {
        int doubleNum = 2 * number;
        return doubleNum;
    }
}
