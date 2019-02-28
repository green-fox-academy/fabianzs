package fabian.zsofia.basicwebshop.controllers;

import fabian.zsofia.basicwebshop.model.ShopItems;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class WebshopController {
    List<ShopItems> shopItemsList;

    public WebshopController() {
        this.shopItemsList = new ArrayList<>();
        this.shopItemsList.add(new ShopItems("Running shoes", "Nike running shoes for every day sport", 1000, 5));
        this.shopItemsList.add(new ShopItems("Printer", "Some HP printer that will print pages", 3000, 2));
        this.shopItemsList.add(new ShopItems("Coca cola", "0.5l standard coke", 25, 0));
        this.shopItemsList.add(new ShopItems("Wokin", "Chicken with fried rice and WOKIN sauce", 119, 100));
        this.shopItemsList.add(new ShopItems("T-shirt", "Blue with a corgi on a bike", 300, 1));
    }

    @RequestMapping("/webshop")
    public String initialize(Model model) {
        model.addAttribute("items", shopItemsList);
        return "webshop";
    }

    @RequestMapping("/only-available")
    public String getAvailable(Model model) {
        List<ShopItems> availableItems = shopItemsList.stream()
                .filter(i -> i.getQuantity() != 0)
                .collect(Collectors.toList());
        model.addAttribute("items", availableItems);
        return "webshop";
    }

    @RequestMapping("/cheapest-first")
    public String getCheapest(Model model) {
        List<ShopItems> cheapItems = shopItemsList.stream()
                //.sorted((i1, i2) -> (i1.getQuantity() >= i2.getQuantity()) ? 1 : -1)
                //.sorted((i1, i2) -> Integer.compare(i1.getQuantity(), i2.getQuantity()))
                .sorted(Comparator.comparing(ShopItems::getQuantity))
                .collect(Collectors.toList());
        model.addAttribute("items", cheapItems);
        return "webshop";
    }

    @RequestMapping("/contains-nike")
    public String containsNike(Model model) {
        List<ShopItems> nikeItems = shopItemsList.stream()
                .filter(i -> i.getName().toLowerCase().contains("nike") || i.getDescription().toLowerCase().contains("nike"))
                .collect(Collectors.toList());
        model.addAttribute("items", nikeItems);
        return "webshop";
    }

    @RequestMapping("/search")
    public String search(Model model, @RequestParam String search) {
        List<ShopItems> matchingItems = shopItemsList.stream()
                .filter(i -> i.getName().toLowerCase().contains(search.toLowerCase()) || i.getDescription().toLowerCase().contains(search.toLowerCase()))
                .collect(Collectors.toList());
        model.addAttribute("items", matchingItems);
        return "webshop";
    }

    @RequestMapping("/average-stock")
    public String averageStock(Model model) {
        Double average = shopItemsList.stream()
                .mapToInt(i -> i.getQuantity())
                .average()
                .getAsDouble();
        model.addAttribute("stat", "Average stock: " + average);
        return "webshop-stat";
    }

    @RequestMapping("/most-expensive")
    public String mostExpensive(Model model) {
        String mostExpensive = shopItemsList.stream()
                .max(Comparator.comparing(ShopItems::getPrice))
                .map(i -> i.getName())
                .get();
        model.addAttribute("stat", "Most expensive: " + mostExpensive);
        return "webshop-stat";
    }
}
