package fabian.zsofia.exampleexam.services;

import fabian.zsofia.exampleexam.models.Alias;
import fabian.zsofia.exampleexam.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AliasService {

    AliasRepository aliasRepository;

    @Autowired
    public AliasService(AliasRepository aliasRepository) {
        this.aliasRepository = aliasRepository;
    }

    public void addAlias(Alias alias) {
        aliasRepository.save(alias);
    }

    public boolean containsAlias(String alias) {
        /*return aliasRepository.findAliasByAlias(alias);*/
        List<Alias> aliases = new ArrayList<>();
        aliasRepository.findAll()
                .forEach(aliases::add);
        Alias exist = aliases.stream()
                .filter(a -> a.getAlias().equals(alias))
                .findAny()
                .orElse(null);

        return exist != null;
    }
}
