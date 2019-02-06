package gardenapp;

public class Tree extends Plant {

    public Tree(String color) {
        super(color);
        this.type = "Tree";
        this.waterAbsorbtion = 0.4;
        this.whenToWater = 10;
    }

    public Tree(String color, int waterAmount) {
        super(color, waterAmount);
        this.type = "Tree";
        this.waterAbsorbtion = 0.4;
        this.whenToWater = 10;
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
