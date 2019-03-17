package fabian.zsofia.todolist.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

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
    private String dueDate;
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Assignee assignee;

    public Todo() {
        this.urgent = false;
        this.done = false;
        this.dateOfCreation = new SimpleDateFormat("yyyy. MMMM dd.").format(new Date());
    }

    public Todo(String title) {
        this.title = title;
        this.urgent = false;
        this.done = false;
        this.dateOfCreation = new SimpleDateFormat("yyyy. MMMM dd.").format(new Date());
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
        assignee.addTodo(this);
    }

    public void removeAssignee() {
        this.assignee = null;
    }
}
