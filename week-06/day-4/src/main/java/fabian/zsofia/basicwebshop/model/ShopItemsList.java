package fabian.zsofia.basicwebshop.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShopItemsList {
    List<ShopItems> shopItems;

    public ShopItemsList() {
        this.shopItems = new ArrayList<>();
        this.shopItems.add(new ShopItems("Running shoes", "Nike running shoes for every day sport", 1000, 5));
        this.shopItems.add(new ShopItems("Printer", "Some HP printer that will print pages", 3000, 2));
        this.shopItems.add(new ShopItems("Coca cola", "0.5l standard coke", 25, 0));
        this.shopItems.add(new ShopItems("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100));
        this.shopItems.add(new ShopItems("T-shirt", "Blue with a corgi on a bike", 300, 1));
    }

    public List<ShopItems> getShopItems() {
        return shopItems;
    }

    public List<ShopItems> getAvailable() {
        return shopItems.stream()
                .filter(i -> i.getQuantity() != 0)
                .collect(Collectors.toList());
    }

    public List<ShopItems> getCheapestFirst() {
        return shopItems.stream()
                //.sorted((i1, i2) -> (i1.getQuantity() >= i2.getQuantity()) ? 1 : -1)
                //.sorted((i1, i2) -> Integer.compare(i1.getQuantity(), i2.getQuantity()))
                .sorted(Comparator.comparing(ShopItems::getQuantity))
                .collect(Collectors.toList());
    }

    public List<ShopItems> getContainsNike() {
        return shopItems.stream()
                .filter(i -> i.getName().toLowerCase().contains("nike") || i.getDescription().toLowerCase().contains("nike"))
                .collect(Collectors.toList());
    }

    public List<ShopItems> getSearcedItems(String search) {
        return shopItems.stream()
                .filter(i -> i.getName().toLowerCase().contains(search.toLowerCase()) || i.getDescription().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Double getAverageStock() {
        return shopItems.stream()
                .mapToInt(i -> i.getQuantity())
                .average()
                .getAsDouble();
    }

    public String getMostExpensive() {
        return shopItems.stream()
                .max(Comparator.comparing(ShopItems::getPrice))
                .map(i -> i.getName())
                .get();
    }
}
