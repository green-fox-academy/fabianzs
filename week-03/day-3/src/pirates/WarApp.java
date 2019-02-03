package pirates;

public class WarApp {
    public static void main(String[] args) {
        Armada pirates = new Armada("Pirates");
        Armada eastIndiaCompany = new Armada("East India Company");

        pirates.fillArmada("Pirate Flagship");
        eastIndiaCompany.fillArmada("East India Company Flagship");
        System.out.println(pirates.armada.size());
        System.out.println(eastIndiaCompany.armada.size());

        pirates.war(eastIndiaCompany);
        if (pirates.war(eastIndiaCompany)) {
            System.out.println("Pirates won");
        } else {
            System.out.println("East India Company won");
        }
    }
}
