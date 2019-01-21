public class Factorio {
    public static void main(String[] args) {
        //  Create the usual class wrapper
        //  and main method on your own.

        // - Create a function called `factorio`
        //   that returns it's input's factorial

        int number = 6;

        factorio(number);
        System.out.println(factorio(number));

    }

    public static int factorio (int numbeToFactorio) {

        int factorial = 1;

        for (int i = numbeToFactorio; i > 0 ; i--) {
            factorial = factorial * i;

        }

        return factorial;
    }

}
