package fabian.zsofia.todolist.repositories;

import fabian.zsofia.todolist.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    /*@Query(value="SELECT todo FROM TODO todo WHERE LOWER(todo.title) LIKE ('*' + :search + '*')")
    public List<Todo> getSearchedTodosByQuery(@Param("search") String searh);*/
}
