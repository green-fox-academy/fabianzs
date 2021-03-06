package fabian.zsofia.connection;

import fabian.zsofia.connection.models.Todo;
import fabian.zsofia.connection.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConnectionApplication implements CommandLineRunner {

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(ConnectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
 /*       todoRepository.save(new Todo("Start the day"));
        todoRepository.save(new Todo("Finish H2 workshop1"));
        todoRepository.save(new Todo("Don't fuck up", true, false));
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
        todoRepository.save(new Todo("Lose your mind", false, true));
        todoRepository.save(new Todo("Watch videos", true, false));*/
    }
}
