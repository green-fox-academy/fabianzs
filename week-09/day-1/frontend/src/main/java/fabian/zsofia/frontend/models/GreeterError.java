package fabian.zsofia.frontend.models;

public class GreeterError {

    private String error;

    public GreeterError() {
        this.error = "Please provide a name and a title!";
    }

    public String getError() {
        return error;
    }

    public void setTitleError() {
        this.error = "Please provide a title!";
    }

    public void setNameError() {
        this.error = "Please provide a name!";
    }


}
