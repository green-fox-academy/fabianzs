package sharpie;

public class Write {
    public static void main(String[] args) {
        Sharpie greenOne = new Sharpie("green", 0.45);

        greenOne.use(3);
        System.out.println(greenOne.inkAmount);
    }
}
