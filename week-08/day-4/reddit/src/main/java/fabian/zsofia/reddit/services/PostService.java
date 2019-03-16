package fabian.zsofia.reddit.services;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll()
                .forEach(posts::add);
        return posts.stream()
                .sorted(Comparator.comparing(Post::getScore).reversed())
                .collect(Collectors.toList());
    }

    public Post getPost(long id) {
        return postRepository.findById(id).get();
    }

    public void addPost(Post post) {
        postRepository.save(post);
    }

    public void voteUp(long id) {
            long score = getPost(id).getScore();
            Post post = getPost(id);
            post.setScore(++score);
            postRepository.save(post);
    }

    public void voteDown(long id) {
        long score = getPost(id).getScore();
        Post post = getPost(id);
        post.setScore(--score);
        postRepository.save(post);
    }

    public List<Post> getBest10Posts(long start) {
        return postRepository.getBest10Posts((start - 1) * 10);
    }

    public int getNumberOfPosts() {
        return postRepository.getNumberOfPosts();
    }
}
