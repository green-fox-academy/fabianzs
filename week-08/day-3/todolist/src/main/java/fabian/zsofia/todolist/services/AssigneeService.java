package fabian.zsofia.todolist.services;

import fabian.zsofia.todolist.models.Assignee;
import fabian.zsofia.todolist.models.Todo;
import fabian.zsofia.todolist.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssigneeService {

    @Autowired
    AssigneeRepository assigneeRepository;

    public List<Assignee> getAllAssignees() {
        List<Assignee> assignees = new ArrayList<>();
        assigneeRepository.findAll()
                .forEach(assignees::add);
        return assignees.stream()
                .sorted(Comparator.comparing(Assignee::getId))
                .collect(Collectors.toList());
    }

    public Assignee getAssignee (long id) {
        return assigneeRepository.findById(id).get();
    }

    public void addAssignee(Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    public void editAssignee(long id, Assignee assignee) {
        assigneeRepository.save(assignee);
    }

    public void deleteAssignee(long id) {
        assigneeRepository.deleteById(id);
    }
}
