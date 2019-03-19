package fabian.zsofia.frontend.repositories;

import fabian.zsofia.frontend.models.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<Log, Long> {
}
