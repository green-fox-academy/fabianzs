package fabian.zsofia.exampleexam.repositories;

import fabian.zsofia.exampleexam.models.Alias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository extends CrudRepository<Alias, Long> {
}
