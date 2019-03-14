package fabian.zsofia.todolist.services;

import fabian.zsofia.todolist.models.Todo;
import fabian.zsofia.todolist.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class    TodoService {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        return todos.stream()
                .sorted(Comparator.comparing(Todo::getId))
                .collect(Collectors.toList());
    }

    public List<Todo> getActiveTodos() {
            List<Todo> todos = new ArrayList<>();
            todoRepository.findAll()
                    .forEach(todos::add);
        return todos.stream()
                .filter(todo -> !todo.isDone())
                .sorted(Comparator.comparing(Todo::getId))
                .collect(Collectors.toList());
    }

    public List<Todo> getSearchedTodos(String search) {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll()
                .forEach(todos::add);
        return todos.stream()
                .filter(todo -> todo.getTitle().toLowerCase().contains(search.toLowerCase()))
                .sorted(Comparator.comparing(Todo::getId))
                .collect(Collectors.toList());
    }

    /*@Query(value="SELECT todo FROM TODO todo WHERE LOWER(todo.title) LIKE ('*' + :search + '*')")
    public List<Todo> getSearchedTodosByQuery(@Param("search") String searh);*/

    public Todo getTodo(long id) {
        return todoRepository.findById(id).get();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void editTodo(long id, Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(long id) {
        todoRepository.deleteById(id);
    }
}
