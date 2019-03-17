package fabian.zsofia.todolist.repositories;

import fabian.zsofia.todolist.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    @Query(value="SELECT * FROM todo LEFT JOIN assignee ON (todo.assignee_id = assignee.id) WHERE LOWER(todo.title) LIKE %:search% OR LOWER(todo.due_date) LIKE %:search% OR LOWER(todo.date_of_creation) LIKE %:search% OR LOWER(assignee.name) LIKE %:search%" , nativeQuery = true)
    public List<Todo> getSearchedTodos(@Param("search") String search);
}
