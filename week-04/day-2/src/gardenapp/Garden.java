package gardenapp;

import java.util.ArrayList;
import java.util.List;

public class Garden {
    List<Plant> plants;
    int numberOfPlants;
    int numberOfPlantsToWater;

    public Garden(List<Plant> plants) {
        this.plants = plants;
        this.numberOfPlants = plants.size();
        this.numberOfPlantsToWater = this.getNumberOfPlantsToWater();
    }

    public Garden() {
        this.plants = new ArrayList<>();
        this.numberOfPlants = 0;
        this.numberOfPlantsToWater = 0;
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
        numberOfPlants++;
        if (plant.needsWater) {
            numberOfPlantsToWater++;
        }
    }

    public void water(int amountOfWater) {
         for (Plant plant : plants) {
            if (plant.needsWater) {
                plant.water(amountOfWater/numberOfPlantsToWater);
            }
         }
        System.out.println("Watering with " + amountOfWater);
         this.getState();
    }

    public int getNumberOfPlantsToWater() {
        int numberOfPlantsToWater = 0;
        for (Plant plant : this.plants) {
            if (plant.needsWater) {
                numberOfPlantsToWater++;
            }
        }
        return numberOfPlantsToWater;
    }

    public void getState() {
        for (Plant plant : plants) {
            plant.getState();
        }
    }
}
