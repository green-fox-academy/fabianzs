package charsequence;

public class Main {
    public static void main(String[] args) {


        Gnirts g = new Gnirts("example");
        System.out.println(g.charAt(6));
        System.out.println(g.subSequence(0,3));

        Shifter s = new Shifter("example", 2);
        System.out.println(s.charAt(2));
        System.out.println(s.subSequence(0,7));
    }
}
