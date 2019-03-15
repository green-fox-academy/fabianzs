package fabian.zsofia.reddit.controllers;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.models.User;
import fabian.zsofia.reddit.repositories.UserRepository;
import fabian.zsofia.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/reddit/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user_fullist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getUserPostForm(Model model) {
        model.addAttribute("new_user", new User());
        return "user_addform";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(User new_user, HttpServletRequest request) {
        userService.addUser(new_user);
        return "redirect:/reddit/user/";
    }

}
