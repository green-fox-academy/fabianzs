package fabian.zsofia.fox.models;

public class Fox {
    private String name;
    private String food;
    private String drink;
    private int listOfTricks;

    public Fox(String name, String food, String drink, int listOfTricks) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.listOfTricks = listOfTricks;
    }

    public String getName() {
        return name;
    }

    public String getFood() {
        return food;
    }

    public String getDrink() {
        return drink;
    }

    public int getListOfTricks() {
        return listOfTricks;
    }
}
