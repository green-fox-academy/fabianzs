package fabian.zsofia.groot.models;

public class Groot {

    private String received;
    private String translated;

    public Groot(String received) {
        this.received = received;
        this.translated = "I am Groot";
    }

    public String getReceived() {
        return received;
    }

    public String getTranslated() {
        return translated;
    }
}
