package fabian.zsofa.bankofsimba.models;

public class BankAccount {
    private String name;
    private int balance;
    private String animalType;
    private boolean isKing;
    private String goodness;

    public BankAccount(String name, int balance, String animalType, boolean isKing, String goodness) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.isKing = isKing;
        this.goodness = goodness;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public boolean isKing() {
        return isKing;
    }

    public String getGoodness() {
        return goodness;
    }

    public void raiseBalance() {
        if (isKing) {
            this.balance += 100;
        } else {
            this.balance += 10;
        }
    }
}
