package fabian.zsofia.todolist;

import fabian.zsofia.todolist.models.Todo;
import fabian.zsofia.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication implements CommandLineRunner {

    @Autowired
    private TodoRepository todoRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        todoRepository.save(new Todo("Start the day"));
        todoRepository.save(new Todo("Finish H2 workshop1"));
        todoRepository.save(new Todo("Don't fuck up"));
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    }
}
