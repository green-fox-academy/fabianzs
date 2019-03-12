package fabian.zsofia.connection.controllers;

import fabian.zsofia.connection.models.Todo;
import fabian.zsofia.connection.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/todo")
public class TodoController {

    private TodoRepository todoRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @RequestMapping(path = {"/", "/list"})
    public String list(Model model, @RequestParam(name = "isActive", required = false) String isActive) {
        List<Todo> todos = new ArrayList<>();
        List<Todo> orderedTodos = new ArrayList<>();
        if (isActive != null && isActive.equals("true")) {
            List<Todo> temp = new ArrayList<>();
            todoRepository.findAll()
                    .forEach(temp::add);
            orderedTodos = temp.stream()
                    .filter(todo -> !todo.isDone())
                    .sorted(Comparator.comparing(Todo::getId))
                    .collect(Collectors.toList());
        } else {
            todoRepository.findAll()
                    .forEach(todos::add);
            orderedTodos = todos.stream()
                    .sorted(Comparator.comparing(Todo::getId))
                    .collect(Collectors.toList());
        }
        model.addAttribute("todos", orderedTodos);
        return "todolist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("newtodo", new Todo());
        return "todolist_add";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(Todo newtodo) {
        todoRepository.save(newtodo);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/delete")
    public String delete(@PathVariable long id) {
        todoRepository.deleteById(id);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
    public String showEditForm(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "todolist_edit";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @ModelAttribute Todo todo) {
        todoRepository.save(todo);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/details", method = RequestMethod.GET)
    public String showDetails(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("todo", todoRepository.findById(id).get());
        return "todolist_todo";
    }
}
