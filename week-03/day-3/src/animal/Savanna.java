package animal;

public class Savanna {
    public static void main(String[] args) {
        Animal tiger = new Animal();

        tiger.play();
        System.out.println("Thirst: " + tiger.thirst + "  Hunger: " +tiger.hunger);
        tiger.drink();
        System.out.println("Thirst: " + tiger.thirst + "  Hunger: " +tiger.hunger);
    }
}
