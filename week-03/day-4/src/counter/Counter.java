package counter;

public class Counter {
    public static void main(String[] args) {
        // Write a recursive function that takes one parameter: n and counts down from n.

        countDown(10);

    }

    public static void countDown(int n) {
        System.out.println(n);
        if (n > 0) {
            countDown(n - 1);
        }
    }
}
