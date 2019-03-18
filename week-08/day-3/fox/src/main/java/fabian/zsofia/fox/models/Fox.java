package fabian.zsofia.fox.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Fox {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    private String name;

    @OneToOne
    private Food food;

    @OneToOne
    private Drink drink;

    @OneToMany
    private List<Trick> listOfTricks;

    @OneToMany
    private List<String> listOfActions;


    public Fox(String name) {
        this.name = name;
        this.food = new Food("meat");
        this.drink = new Drink("water");
        this.listOfTricks = new ArrayList<>();
        this.listOfActions = new ArrayList<>();
    }

    public Fox(String name, String food, String drink, List<Trick> listOfTricks) {
        this.name = name;
        this.food = new Food("meat");
        this.drink = new Drink("water");
        this.listOfTricks = listOfTricks;
        this.listOfActions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Food getFood() {
        return food;
    }

    public Drink getDrink() {
        return drink;
    }

    public List<Trick> getListOfTricks() {
        return listOfTricks;
    }

    public List<String> getListOfActions() {
        return listOfActions;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public List<String> findUnkonwTricks(List<String> tricksToSearch) {
        return tricksToSearch.stream()
                .filter(t -> !listOfTricks.contains(t))
                .collect(Collectors.toList());
    }

    public void addTrick(Trick trick) {
        this.listOfTricks.add(trick);
    }

    public void addAction(String action) {
        this.listOfActions.add(action);
    }
}
