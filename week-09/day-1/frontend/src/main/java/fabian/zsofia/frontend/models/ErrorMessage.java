package fabian.zsofia.frontend.models;

public class ErrorMessage {

    private String error;

    public ErrorMessage() {
        this.error = "Please provide an input!";
    }

    public String getError() {
        return error;
    }
}
