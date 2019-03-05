package fabian.zsofa.bankofsimba.models;

public class BankAccount {
    private String name;
    private int balance;
    private String animalType;
    private boolean isKing;
    private boolean isGood;

    public BankAccount(String name, int balance, String animalType, boolean isKing, boolean isGood) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        this.isKing = isKing;
        this.isGood = isGood;
    }

    public BankAccount() {

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

    public boolean isGood() {
        return isGood;
    }

    public void raiseBalance() {
        if (isKing) {
            this.balance += 100;
        } else {
            this.balance += 10;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public void setKing(boolean king) {
        isKing = king;
    }

    public void setGood(boolean good) {
        isGood = good;
    }
}
