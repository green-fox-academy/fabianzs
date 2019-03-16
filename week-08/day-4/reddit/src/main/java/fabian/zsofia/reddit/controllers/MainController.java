package fabian.zsofia.reddit.controllers;

import fabian.zsofia.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reddit")
public class MainController {

    UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = {"/login", "/"}, method = RequestMethod.GET)
    public String getLoginPage(Model model, @RequestParam(name = "username", required = false) String username, @RequestParam(name = "password", required = false) String password) {
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        long id = userService.validateUser(username, password);
        if (id == -1) {
            return "redirect:/reddit/login?username=invalid";
        } else if (id == 0) {
            return "redirect:/reddit/login?password=invalid";
        } else {
            return "redirect:/reddit/" + username + "/post/";
        }
    }
}
