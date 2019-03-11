package fabian.zsofia.connection.controllers;

import fabian.zsofia.connection.models.Todo;
import fabian.zsofia.connection.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
        if (isActive != null && isActive.equals("true")) {
            List<Todo> temp = new ArrayList<>();
            todoRepository.findAll()
                    .forEach(temp::add);
            todos = temp.stream()
                    .filter(todo -> !todo.isDone())
                    .collect(Collectors.toList());
        } else {
            todoRepository.findAll()
                    .forEach(todos::add);
        }
        model.addAttribute("todos", todos);
        return "todolist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAdd(Model model) {
        model.addAttribute("newtodo", new Todo());
        return "todolist_add";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Todo newtodo) {
        todoRepository.save(newtodo);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/delete")
    public String delete(@PathVariable long id) {
        todoRepository.deleteById(id);
        return "redirect:/todo/";
    }
}
