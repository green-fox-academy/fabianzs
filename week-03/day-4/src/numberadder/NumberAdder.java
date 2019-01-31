package numberadder;

public class NumberAdder {
    public static void main(String[] args) {
        // Write a recursive function that takes one parameter: n and adds numbers from 1 to n.

        System.out.println(addNumber(3));

    }

    public static int addNumber(int n) {
        if (n > 0) {
            n = addNumber(n - 1) + n;
        }
        return n;
    }

}
