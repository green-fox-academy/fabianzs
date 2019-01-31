package refactorio;

public class Refactorio {
    public static void main(String[] args) {
        // Create a recursive function called `refactorio`
        // that returns it's input's factorial

        System.out.println(refactorio(6));
    }

    public static int refactorio(int n) {
        if (n > 1) {
            return n * refactorio(n - 1);
        }
        return n;
    }

}
