package fabian.zsofia.todolist;

import fabian.zsofia.todolist.models.Assignee;
import fabian.zsofia.todolist.models.Todo;
import fabian.zsofia.todolist.repositories.AssigneeRepository;
import fabian.zsofia.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication implements CommandLineRunner {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private AssigneeRepository assigneeRepository;

    public static void main(String[] args) {
        SpringApplication.run(TodolistApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
/*        todoRepository.save(new Todo("Start the day"));
        todoRepository.save(new Todo("Finish H2 workshop1"));
        todoRepository.save(new Todo("Don't fuck up", true, false, "2019. február 12.", "2019. május 2."));
        todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
        todoRepository.save(new Todo("Lose your mind", false, true, "2019. február 12.", "2020. április 6."));
        todoRepository.save(new Todo("Watch videos", true, false, "2018. december 9.", "2019. június 10."));

        assigneeRepository.save(new Assignee("Zsófi", "fabian.zsofia.eszter@gmail.com"));
        assigneeRepository.save(new Assignee("Szabi", "osziszab@gmail.com"));
        assigneeRepository.save(new Assignee("Jani", "johnlackland@gmail.com"));*/


    }
}
