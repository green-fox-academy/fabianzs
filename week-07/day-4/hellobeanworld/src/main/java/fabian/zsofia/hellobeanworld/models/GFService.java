package fabian.zsofia.hellobeanworld.models;


import java.util.List;

public interface GFService {

    List<String> findAll();

    void save(String student);

    int count();
}
