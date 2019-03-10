package fabian.zsofia.fox.controllers;

import fabian.zsofia.fox.models.FoxList;
import fabian.zsofia.fox.models.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class FoxController {

    FoxList foxList;
    FoxService foxService;

    @Autowired
    public FoxController(FoxList foxList, FoxService foxService) {
        this.foxList = foxList;
        this.foxService = foxService;
    }

    @RequestMapping(value = "/information", method = RequestMethod.GET)
    public String showInformation(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        model.addAttribute("fox", foxList.findFox(name));
        return "information";
    }

    @RequestMapping(value = "/nutritionStore", method = RequestMethod.GET)
    public String showNutrition(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        model.addAttribute("foodlist", foxService.getFoodList());
        model.addAttribute("drinklist", foxService.getDrinkList());
        model.addAttribute("fox", foxList.findFox(name));
        return "nutrition";
    }

    @RequestMapping(value = "/nutritionStore", method = RequestMethod.POST)
    public String setNutrition(@RequestParam String name, String food, String drink) {
        if (!foxList.findFox(name).getFood().equals(food)) {
            foxList.findFox(name).addAction(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd.  hh:mm:ss")) + " : Food has been changed from: " + foxList.findFox(name).getFood() + " to: " + food);
        }
        foxList.findFox(name).setFood(food);
        if (!foxList.findFox(name).getDrink().equals(drink)) {
            foxList.findFox(name).addAction(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd.  hh:mm:ss")) + " : Food has been changed from: " + foxList.findFox(name).getDrink() + " to: " + drink);
        }
        foxList.findFox(name).setDrink(drink);
        return "redirect:/information?name=" + name;
    }

    @RequestMapping(value = "/trickCenter", method = RequestMethod.GET)
    public String showTricks(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        model.addAttribute("tricklist", foxList.findFox(name).findUnkonwTricks(foxService.getTrickList()));
        return "tricks";
    }

    @RequestMapping(value = "/trickCenter", method = RequestMethod.POST)
    public String addTrick(@RequestParam String name, String trick) {
        foxList.findFox(name).addAction(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd.  hh:mm:ss")) + " : Learned to: " + trick);
        foxList.findFox(name).addTrick(trick);
        return "redirect:/trickCenter?name=" + name;
    }

    @RequestMapping(value = "/actionHistory", method = RequestMethod.GET)
    public String showActionHistory(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        model.addAttribute("actionlist", foxList.findFox(name).getListOfActions());
        model.addAttribute("fox", foxList.findFox(name));
        return "actions";
    }
}
