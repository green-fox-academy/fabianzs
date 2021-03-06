package fabian.zsofia.reddit.services;

import fabian.zsofia.reddit.models.Post;
import fabian.zsofia.reddit.models.User;
import fabian.zsofia.reddit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll()
                .forEach(users::add);
        return users.stream()
                .sorted(Comparator.comparing(User::getId))
                .collect(Collectors.toList());
    }

    public User getUserById(long id) {
        return userRepository.findById(id).get();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public long validateUser(String username, String password) {
        if (userRepository.findByUsername(username) == null) {
            return -1;
        } else if (userRepository.findByUsername(username) != null && userRepository.validateUser(username, password) == null) {
            return 0;
        } else {
            return userRepository.validateUser(username, password).getId();
        }
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
