package fabian.zsofia.reddit;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.models.User;
import fabian.zsofia.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class RedditProjectApplication implements CommandLineRunner {

    @Autowired
    private PostRepository postRepository;

    public static void main(String[] args) {
        SpringApplication.run(RedditProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*postRepository.save(new Post("You have to fight an exact copy of yourself to the death, how do you outsmart yourself?", "https://www.google.hu/", new User("fzse", "Fábián Zsófia", "fabian.zsofia.eszter@gmail.com", 26, "password")))*/;
    }
}
