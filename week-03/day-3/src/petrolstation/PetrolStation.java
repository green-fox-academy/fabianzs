package petrolstation;

public class PetrolStation {
    public static void main(String[] args) {
        Car car01 = new Car();
        Station station01 = new Station();

        System.out.println(car01.gasAmount);

        station01.gasAmount = 1000;
        System.out.println(station01.gasAmount);

        station01.refill(car01);

        System.out.println(car01.gasAmount);
        System.out.println(station01.gasAmount);


    }
}
