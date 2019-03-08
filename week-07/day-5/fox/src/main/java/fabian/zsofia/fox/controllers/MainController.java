package fabian.zsofia.fox.controllers;

import fabian.zsofia.fox.models.Fox;
import fabian.zsofia.fox.models.Foxlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    Foxlist foxlist;

    @Autowired
    public MainController() {
        foxlist = new Foxlist();
    }

    @GetMapping("/")
    public String getIndexPage(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name);
        model.addAttribute("fox", foxlist.findFox(name));
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLoginData(String name) {
        if (name.equals(null)) {
            return "redirect:/login";
        } else if (!foxlist.existFox(name)) {
            return "redirect:/login";
        } else {
            return "redirect:/?name=" + name;
        }
    }

    @RequestMapping(value = "/nutritionStore", method = RequestMethod.GET)
    public String showNutrition(@RequestParam(required = false) String name) {
        return "nutrition";
    }
}
