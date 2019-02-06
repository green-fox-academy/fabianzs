package gardenapp;

public class Plant {
    protected String color;
    protected String type;
    protected int waterAmount;
    protected double waterAbsorbtion;
    protected int whenToWater;
    protected boolean needsWater;

    public Plant(String color) {
        this.color = color;
        this.type = "Plant";
        this.waterAmount = 0;
        this.needsWater = true;
    }

    public Plant(String color, int waterAmount) {
        this.color = color;
        this.type = "Plant";
        this.waterAmount = waterAmount;
        this.updateNeedsWater();
    }

    public void updateNeedsWater() {
        if (this.waterAmount < this.whenToWater) {
            this.needsWater = true;
        } else {
            this.needsWater = false;
        }
    }

    public void water(int amountOfWater) {
        this.waterAmount += amountOfWater * this.waterAbsorbtion;
        this.updateNeedsWater();
    }

    public void getState() {
        if (needsWater) {
            System.out.println("The " + this.color + " " + this.type + " needs water");
        } else {
            System.out.println("The " + this.color + " " + this.type + " doesn't need water");
        }
    }
}
