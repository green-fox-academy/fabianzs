package fabian.zsofia.todolist.controllers;

import fabian.zsofia.todolist.models.Todo;
import fabian.zsofia.todolist.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/todo")
public class TodoController {


    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(path = {"/", "/list"})
    public String list(Model model, @RequestParam(name = "isActive", required = false) String isActive) {
        List<Todo> todos = todoService.getAllTodos();
        if (isActive != null && isActive.equals("true")) {
            todos = todoService.getActiveTodos();
        }
        model.addAttribute("todos", todos);
        return "todolist";
    }

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String search(Model model, String search) {
        model.addAttribute("todos", todoService.getSearchedTodos(search));
        return "todolist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("newtodo", new Todo());
        return "todolist_add";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(Todo newtodo) {
        todoService.addTodo(newtodo);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/delete")
    public String delete(@PathVariable long id) {
        todoService.deleteTodo(id);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
    public String showEditForm(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("todo", todoService.getTodo(id));
        return "todolist_edit";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.POST)
    public String edit(@PathVariable long id, @ModelAttribute Todo todo) {
        todoService.editTodo(id, todo);
        return "redirect:/todo/";
    }

    @RequestMapping(path = "/{id}/details", method = RequestMethod.GET)
    public String showDetails(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("todo", todoService.getTodo(id));
        return "todolist_todo";
    }
}
