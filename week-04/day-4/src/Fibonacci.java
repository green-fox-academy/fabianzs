public class Fibonacci {

    public static int calculateFibonacci (int n) {
        if (n < 0) {
            throw new IndexOutOfBoundsException("The index of an element cannot be negative.");
        }
        if (n > 1) {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
        return n;
    }
}
