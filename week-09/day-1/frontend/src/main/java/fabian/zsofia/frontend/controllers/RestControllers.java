package fabian.zsofia.frontend.controllers;

import fabian.zsofia.frontend.models.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllers {

    @RequestMapping(path = "/doubling",  method = RequestMethod.GET)
    public Object getDoubling(@RequestParam(name = "input", required = false) Integer received) {
        if (received != null) {
            return new Doubling(received);
        } else {
            return new DoublingError();
        }
    }

    @RequestMapping(path = "/greeter",  method = RequestMethod.GET)
    public Object getGreeter(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "title", required = false) String title) {
        GreeterError greeterError = new GreeterError();
        if (name == null && title == null) {
            return greeterError;
        } else if (name == null && title != null) {
            greeterError.setNameError();
            return greeterError;
        } else if (name != null && title == null) {
            greeterError.setTitleError();
            return greeterError;
        } else {
            return new Greeter(name, title);
        }
    }

}
