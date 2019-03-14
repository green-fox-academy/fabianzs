package fabian.zsofia.todolist.models;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private boolean urgent;
    private boolean done;
    private String dateOfCreation;
    @ManyToOne (cascade = CascadeType.ALL)
    private Assignee assignee;

    public Todo() {
        this.urgent = false;
        this.done = false;
        this.dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd."));
    }

    public Todo(String title) {
        this.title = title;
        this.urgent = false;
        this.done = false;
        this.dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd."));
    }

    public Todo(String title, boolean urgent, boolean done) {
        this.title = title;
        this.urgent = urgent;
        this.done = done;
        this.dateOfCreation = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy. MMMM. dd."));
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public void setUrgent(boolean urgent) {
        this.urgent = urgent;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
        assignee.addTodo(this);
    }
}
