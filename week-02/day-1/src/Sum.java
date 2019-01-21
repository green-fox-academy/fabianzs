public class Sum {
    public static void main(String[] args) {
        //  Create the usual class wrapper
        //  and main method on your own.

        // - Write a function called `sum` that sum all the numbers
        //   until the given parameter and returns with an integer

        int finalNumber = 8;

        sum(finalNumber);
        System.out.println(sum(finalNumber));
    }

    public static int sum (int numberToSum) {
        int summed = 0;
        for (int i = 1; i < numberToSum + 1 ; i++) {
            summed = summed + i;

            }
        return summed;

        }

}
