package gardenapp;

public class Plant {
    String color;
    String type;
    int waterAmount;
    protected double waterAbsorbtion;
    int whenToWater;
    boolean needsWater;

    public Plant(String color) {
        this.color = color;
        this.type = "Plant";
        this.waterAmount = 0;
        this.waterAbsorbtion = 1;
        this.needsWater = true;
    }

    public Plant(String color, int waterAmount) {
        this.color = color;
        this.type = "Plant";
        this.waterAmount = waterAmount;
        this.waterAbsorbtion = 1;
        if (this.waterAmount < this.whenToWater) {
            this.needsWater = true;
        } else {
            this.needsWater = false;
        }
    }

    public void setNeedsWater() {
        if (this.waterAmount < this.whenToWater) {
            this.needsWater = true;
        } else {
            this.needsWater = false;
        }
    }

    public void water(int amountOfWater) {
        this.waterAmount += amountOfWater * this.waterAbsorbtion;
        this.setNeedsWater();
    }

    public void getState() {
        if (needsWater) {
            System.out.println("The " + this.color + " " + this.type + " needs water");
        } else {
            System.out.println("The " + this.color + " " + this.type + " doesn't need water");
        }
    }
}
