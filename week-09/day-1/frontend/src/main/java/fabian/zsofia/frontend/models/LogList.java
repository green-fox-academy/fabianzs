package fabian.zsofia.frontend.models;

import java.util.List;

public class LogList {

    private List<Log> entries;
    private int entry_count;

    public LogList(List<Log> entries) {
        this.entries = entries;
        this.entry_count = entries.size();
    }

    public List<Log> getEntries() {
        return entries;
    }

    public void setEntries(List<Log> entries) {
        this.entries = entries;
    }

    public int getEntry_count() {
        return entry_count;
    }

    public void setEntry_count(int entry_count) {
        this.entry_count = entry_count;
    }
}
