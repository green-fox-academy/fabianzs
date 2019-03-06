package fabian.zsofia.basicwebshop.controllers;

import fabian.zsofia.basicwebshop.model.ShopItemsList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebshopController {
    ShopItemsList shopItemsList;

    public WebshopController() {
        this.shopItemsList = new ShopItemsList();
    }

    @RequestMapping("/webshop")
    public String initialize(Model model) {
        model.addAttribute("items", shopItemsList.getShopItems());
        return "webshop";
    }

    @RequestMapping("/webshop/only-available")
    public String getAvailable(Model model) {
        model.addAttribute("items", shopItemsList.getAvailable());
        return "webshop";
    }

    @RequestMapping("/webshop/cheapest-first")
    public String getCheapest(Model model) {
        model.addAttribute("items", shopItemsList.getCheapestFirst());
        return "webshop";
    }

    @RequestMapping("/webshop/contains-nike")
    public String containsNike(Model model) {
        model.addAttribute("items", shopItemsList.getContainsNike());
        return "webshop";
    }

    @RequestMapping("/webshop/search")
    public String search(Model model, @RequestParam String search) {
        model.addAttribute("items", shopItemsList.getSearcedItems(search));
        return "webshop";
    }

    @RequestMapping("/webshop/average-stock")
    public String averageStock(Model model) {
        model.addAttribute("stat", "Average stock: " + shopItemsList.getAverageStock());
        return "webshop-stat";
    }

    @RequestMapping("/webshop/most-expensive")
    public String mostExpensive(Model model) {
        model.addAttribute("stat", "Most expensive: " + shopItemsList.getMostExpensive());
        return "webshop-stat";
    }
}
