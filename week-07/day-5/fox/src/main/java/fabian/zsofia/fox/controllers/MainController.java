package fabian.zsofia.fox.controllers;

import fabian.zsofia.fox.models.Fox;
import fabian.zsofia.fox.models.FoxList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    FoxList foxList;

    @Autowired
    public MainController(FoxList foxList) {
        this.foxList = foxList;
    }

    @GetMapping("/")
    public String getIndexPage(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name);
        model.addAttribute("fox", foxList.findFox(name));
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginPage(Model model, @RequestParam(name = "name", required = false) String name, @RequestParam(name = "fox", required = false) String fox) {
        model.addAttribute("foxlist", foxList);
        model.addAttribute("name", name);
        model.addAttribute("fox", fox);
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLoginData(String name) {
        if (name.equals("")) {
            return "redirect:/login";
        } else if (!foxList.existFox(name)) {
            return "redirect:/login/?name=" + name;
        } else {
            return "redirect:/?name=" + name;
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerFox(String fox) {
        if (fox.equals("")) {
            return "redirect:/login";
        } else if (foxList.existFox(fox)) {
            return "redirect:/login/?fox=" + fox;
        } else {
            foxList.addFox(new Fox(fox));
            return "redirect:/?name=" + fox;
        }
    }
}
