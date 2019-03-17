package fabian.zsofia.todolist.controllers;

import fabian.zsofia.todolist.models.Assignee;
import fabian.zsofia.todolist.models.Todo;
import fabian.zsofia.todolist.services.AssigneeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/assignee")
public class AssigneeController {

    @Autowired
    AssigneeService assigneeService;

    @RequestMapping(path = {"/list", "/"}, method = RequestMethod.GET)
    public String listAssignees(Model model) {
        model.addAttribute("assignees", assigneeService.getAllAssignees());
        return "assigneelist";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String showAddForm(Model model) {
        model.addAttribute("new_assignee", new Assignee());
        return "assigneelist_add";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String add(Assignee newAssignee) {
        assigneeService.addAssignee(newAssignee);
        return "redirect:/assignee/";
    }

    @RequestMapping(path = "/{id}/delete", method = RequestMethod.DELETE)
    public String delete(@PathVariable long id) {
        List<Todo> todos = assigneeService.getAssignee(id).getTodos();
        for (Todo todo : todos) {
            todo.removeAssignee();
        }
        assigneeService.deleteAssignee(id);
        return "redirect:/assignee/";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.GET)
    public String showEditForm(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("assignee", assigneeService.getAssignee(id));
        return "assigneelist_edit";
    }

    @RequestMapping(path = "/{id}/edit", method = RequestMethod.PUT)
    public String edit(@PathVariable long id, @ModelAttribute Assignee assignee) {
        assigneeService.editAssignee(id, assignee);
        return "redirect:/assignee/";
    }

    @RequestMapping(path = "/{id}/details", method = RequestMethod.GET)
    public String showDetails(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("assignee", assigneeService.getAssignee(id));
        model.addAttribute("todos", assigneeService.getAssignee(id).getTodos());
        return "assigneelist_todos";
    }
}
