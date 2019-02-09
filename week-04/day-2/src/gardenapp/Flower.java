package gardenapp;

public class Flower extends Plant {

    public Flower(String color) {
        super(color);
        this.waterAbsorbtion = 0.75;
        this.whenToWater = 5;
    }

    public Flower(String color, int waterAmount) {
        super(color, waterAmount);
        this.waterAbsorbtion = 0.75;
        this.whenToWater = 5;
        this.updateNeedsWater();
    }

    @Override
    public void updateNeedsWater() {
        super.updateNeedsWater();
    }

    @Override
    public void water(int amountOfWater) {
        super.water(amountOfWater);
    }

    @Override
    public void getState() {
        super.getState();
    }

}
