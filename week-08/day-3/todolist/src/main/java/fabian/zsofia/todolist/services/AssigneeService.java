package fabian.zsofia.todolist.services;

import fabian.zsofia.todolist.models.Assignee;
import fabian.zsofia.todolist.repositories.AssigneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssigneeService {

    @Autowired
    AssigneeRepository assigneeRepository;

    public List<Assignee> getAllAssignees() {
        List<Assignee> assignees = new ArrayList<>();
        assigneeRepository.findAll()
                .forEach(assignees::add);
        return assignees;
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
