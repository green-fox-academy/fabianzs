package fabian.zsofia.reddit.controllers;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/reddit")
public class PostController {

    @Autowired
    PostService postService;


    @RequestMapping("/full")
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "reddit_fullist";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String redirect() {
        return "redirect:/reddit/1";
    }

    @RequestMapping(path = "/{page}", method = RequestMethod.GET)
    public String listLimitedPosts(Model model, @PathVariable long page) {
        model.addAttribute("page", page);
        model.addAttribute("posts", postService.getBest10Posts(page));
        return "reddit_limitedlist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getAddPostForm(Model model) {
        model.addAttribute("new_post", new Post());
        return "reddit_addform";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(Post new_post, HttpServletRequest request) {
        postService.addPost(new_post);
        return "redirect:" + request.getHeader("Referer");
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
