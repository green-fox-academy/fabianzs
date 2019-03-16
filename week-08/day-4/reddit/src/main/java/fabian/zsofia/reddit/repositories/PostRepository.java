package fabian.zsofia.reddit.repositories;

import fabian.zsofia.reddit.models.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Query(value = "SELECT * FROM reddit_post ORDER BY reddit_post.score DESC Limit :start, 10", nativeQuery = true)
    List<Post> getBest10Posts(@Param("start") long start);

    @Query(value = "SELECT COUNT(reddit_post.id) FROM reddit_post", nativeQuery = true)
    int getNumberOfPosts();
}
