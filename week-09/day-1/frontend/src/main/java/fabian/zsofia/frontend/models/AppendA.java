package fabian.zsofia.frontend.models;

public class AppendA {

    private String appended;

    public AppendA(String appendable) {
        this.appended = appendable + "a";
    }

    public String getAppended() {
        return appended;
    }
}
