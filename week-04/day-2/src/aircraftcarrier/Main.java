package aircraftcarrier;

public class Main {
    public static void main(String[] args) {
        Carrier carrier = new Carrier(2000, 10);
        for (int i = 0; i < 10; i++) {
            carrier.add(new F35());
        }
        for (int i = 0; i < 15; i++) {
            carrier.add(new F16());
        }
        System.out.println(carrier.getStatus());
        carrier.fill();
        printLine();
        System.out.println(carrier.getStatus());
        printLine();

        Carrier carrier2 = new Carrier(1000, 8000);
        for (int i = 0; i < 5; i++) {
            carrier2.add(new F35());
        }
        for (int i = 0; i < 5; i++) {
            carrier2.add(new F16());
        }
        System.out.println(carrier2.getStatus());
        printLine();

        carrier.fight(carrier2);
        System.out.println(carrier.getStatus());
        printLine();
        System.out.println(carrier2.getStatus());




    }

    public static void printLine() {
        System.out.println();
        for (int i = 0; i < 40; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }
}
