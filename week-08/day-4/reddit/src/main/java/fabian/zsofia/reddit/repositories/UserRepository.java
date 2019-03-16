package fabian.zsofia.reddit.repositories;

import fabian.zsofia.reddit.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value="SELECT * FROM reddit_user WHERE reddit_user.username LIKE :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);

    @Query(value="SELECT * FROM reddit_user WHERE reddit_user.username LIKE :username AND reddit_user.password LIKE :password", nativeQuery = true)
    User validateUser(@Param("username") String username, @Param("password") String password);
}
