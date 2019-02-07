public class Sharpie {
    String color;
    double width;
    double inkAmount;

    public Sharpie(String color, double width ) {
        this.color = color;
        this.width = width;
        this.inkAmount = 100;
    }

    public void use(int useThisManyTimes) {
        if (useThisManyTimes < 0) {
            throw new IllegalArgumentException("You cannot use the sharpie negative times.");
        }
        if (this.inkAmount == 0) {
            throw new IllegalArgumentException("The sharpie is empty.");
        }
        this.inkAmount -= 2.5 * this.width * useThisManyTimes;
        if (this.inkAmount < 0) {
            throw new IllegalArgumentException("The sharpie cannot be used this many times. Try a smaller number.");
        }
    }

    public void setInkAmount(double inkAmount) {
        this.inkAmount = inkAmount;
    }
}
