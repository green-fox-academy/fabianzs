package fabian.zsofia.fox.models;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoxService {

    private List<String> foodList;
    private List<String> drinkList;
    private List<String> trickList;

    public FoxService() {
        this.foodList = new ArrayList<>();
        initializeFoodList();
        this.drinkList = new ArrayList<>();
        initializeDrinkList();
        this.trickList = new ArrayList<>();
        initializeTrickList();
    }

    public void initializeFoodList() {
        this.foodList.add("pizza");
        this.foodList.add("hamburger");
        this.foodList.add("salmon");
        this.foodList.add("salad");
        this.foodList.add("cheese");
    }

    public void initializeDrinkList() {
        this.drinkList.add("water");
        this.drinkList.add("blood");
        this.drinkList.add("milk");
        this.drinkList.add("lemonade");
    }

    public List<String> getTrickList() {
        return trickList;
    }

    public void initializeTrickList() {
        this.trickList.add("dance");
        this.trickList.add("sing");
        this.trickList.add("swim");
        this.trickList.add("hunt");
        this.trickList.add("fool around");
        this.trickList.add("fetch");
        this.trickList.add("cuddle");
    }

    public List<String> getFoodList() {
        return foodList;
    }

    public List<String> getDrinkList() {
        return drinkList;
    }
}
