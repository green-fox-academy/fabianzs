package fabian.zsofia.hellobeanworld.models;


import java.util.List;

public interface GFService {

    List<String> getNames();

    void save(String student);

    int count();
}
