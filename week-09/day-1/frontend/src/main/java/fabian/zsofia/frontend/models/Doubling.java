package fabian.zsofia.frontend.models;

public class Doubling {

    private int received;
    private int result;

    public Doubling(int received) {
        this.received = received;
        result = received * 2;
    }

    public int getReceived() {
        return received;
    }

    public int getResult() {
        return result;
    }
}
