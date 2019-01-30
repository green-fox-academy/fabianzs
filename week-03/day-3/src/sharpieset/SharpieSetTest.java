package sharpieset;

public class SharpieSetTest {
    public static void main(String[] args) {
        Sharpie sharpie1 = new Sharpie("green", 1);
        Sharpie sharpie2 = new Sharpie("red", 2);
        Sharpie sharpie3 = new Sharpie("yellow", 0.8);
        Sharpie sharpie4 = new Sharpie("blue", 1);
        Sharpie sharpie5 = new Sharpie("orange", 0.8);

        sharpie2.inkAmount = 0;
        sharpie4.inkAmount = 0;

        SharpieSet sharpieSet1 = new SharpieSet();

        sharpieSet1.sharpies.add(sharpie1);
        sharpieSet1.sharpies.add(sharpie2);
        sharpieSet1.sharpies.add(sharpie3);
        sharpieSet1.sharpies.add(sharpie4);
        sharpieSet1.sharpies.add(sharpie5);

        sharpieSet1.countUsable();
        System.out.println(sharpieSet1.countUsable());
        sharpieSet1.removeTrash();
        for (Sharpie sharpie : sharpieSet1.sharpies) {
            System.out.println(sharpie.color);
        }
        System.out.println();




    }

}
