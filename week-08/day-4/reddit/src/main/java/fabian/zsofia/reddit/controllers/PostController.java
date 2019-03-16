package fabian.zsofia.reddit.controllers;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.services.PostService;
import fabian.zsofia.reddit.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/reddit/{username}/post")
public class PostController {

    PostService postService;
    UserService userService;

    @Autowired
    public PostController(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @RequestMapping("/full")
    public String listPosts(Model model, @PathVariable String username) {
        model.addAttribute("username", username);
        model.addAttribute("posts", postService.getAllPosts());
        return "post_fullist";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String redirect(@PathVariable String username) {
        return "redirect:/reddit/" + username + "/post/1";
    }

    @RequestMapping(path = "/{page}", method = RequestMethod.GET)
    public String listLimitedPosts(Model model, @PathVariable String username, @PathVariable long page) {
        model.addAttribute("username", username);
        model.addAttribute("page", page);
        model.addAttribute("posts", postService.getBest10Posts(page));
        model.addAttribute("total", postService.getNumberOfPosts());
        return "post_limitedlist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getAddPostForm(Model model, @PathVariable String username) {
        model.addAttribute("username", username);
        model.addAttribute("new_post", new Post());
        return "post_addform";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(Post new_post, @PathVariable String username, HttpServletRequest request) {
        new_post.setUser(userService.getUserByUsername(username));
        postService.addPost(new_post);
        return "redirect:/reddit/" + username + "/post/";
    }

    @RequestMapping(path = "/{id}/voteup", method = RequestMethod.GET)
    public String voteUp(@PathVariable long id, HttpServletRequest request) {
        postService.voteUp(id);
        return "redirect:" + request.getHeader("Referer");
    }

    @RequestMapping(path = "/{id}/votedown", method = RequestMethod.GET)
    public String voteDown(@PathVariable long id, HttpServletRequest request) {
        postService.voteDown(id);
        return "redirect:" + request.getHeader("Referer");
    }
}
