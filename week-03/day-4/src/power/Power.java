package power;

public class Power {
    public static void main(String[] args) {
        // Given base and n that are both 1 or more, compute recursively (no loops)
        // the value of base to the n power, so powerN(3, 2) is 9 (3 squared).

        System.out.println(raiseToPower(2,4));
    }

    public static int raiseToPower (int base, int power) {
        if (base > 1 && power > 1) {
            base = raiseToPower(base, power - 1) * base;
        }
        return base;
    }
}
