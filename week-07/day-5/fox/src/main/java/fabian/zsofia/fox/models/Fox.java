package fabian.zsofia.fox.models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Fox {
    private String name;
    private String food;
    private String drink;
    private List<String> listOfTricks;
    private List<String> listOfActions;


    public Fox(String name) {
        this.name = name;
        this.food = "meat";
        this.drink = "water";
        this.listOfTricks = new ArrayList<>();
        this.listOfActions = new ArrayList<>();
    }

    public Fox(String name, String food, String drink, List<String> listOfTricks) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        this.listOfTricks = listOfTricks;
        this.listOfActions = new ArrayList<>();
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

    public List<String> getListOfTricks() {
        return listOfTricks;
    }

    public List<String> getListOfActions() {
        return listOfActions;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public List<String> findUnkonwTricks(List<String> tricksToSearch) {
        return tricksToSearch.stream()
                .filter(t -> !listOfTricks.contains(t))
                .collect(Collectors.toList());
    }

    public void addTrick(String trick) {
        this.listOfTricks.add(trick);
    }

    public void addAction(String action) {
        this.listOfActions.add(action);
    }
}
