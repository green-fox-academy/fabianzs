package fabian.zsofia.reddit.controllers;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/reddit")
public class PostController {

    @Autowired
    PostService postService;


    @RequestMapping("/")
    public String listPosts(Model model) {
        model.addAttribute("posts", postService.getAllPosts());
        return "reddit_list";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String getAddPostForm(Model model) {
        model.addAttribute("new_post", new Post());
        return "reddit_addform";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(Post new_post) {
        postService.addPost(new_post);
        return "redirect:/reddit/";
    }

    @RequestMapping(path = "/{id}/voteup", method = RequestMethod.GET)
    public String voteUp(@PathVariable long id) {
        postService.voteUp(id);
        return "redirect:/reddit/";
    }

    @RequestMapping(path = "/{id}/votedown", method = RequestMethod.GET)
    public String voteDown(@PathVariable long id) {
        postService.voteDown(id);
        return "redirect:/reddit/";
    }
}
