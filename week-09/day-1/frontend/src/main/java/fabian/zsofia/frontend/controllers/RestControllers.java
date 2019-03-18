package fabian.zsofia.frontend.controllers;

import fabian.zsofia.frontend.models.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @RequestMapping(path = "/appenda/{appendable}", method = RequestMethod.GET)
    public Object getAppenda(@PathVariable String appendable) {
        return new AppendA(appendable);
    }

    @RequestMapping(path = "/dountil/{action}", method = RequestMethod.POST)
    public Object postDoUntil(@PathVariable String action, @RequestBody(required = false) Until until) {
        if (until != null) {
            return new DoUntil(action, until);
        } else {
            return new DoUntilError();
        }
    }

    /*@RequestMapping(path = "/dountil/{action}", method = RequestMethod.POST)
    public Object postDoUntil(@PathVariable String action, @RequestBody(required = false)  Map<String, Integer> until) {
        if (until != null) {
            return new DoUntil(action, until);
        } else {
            return new DoUntilError();
        }
    }*/

    @RequestMapping(path = "/array", method = RequestMethod.POST)
    public Object postArrays (@RequestBody(required = false) ArrayHandlerJson arrayHandlerJson) {
        System.out.println(arrayHandlerJson);
        if (arrayHandlerJson != null && arrayHandlerJson.getWhat() != null && arrayHandlerJson.getNumbers() != null) {
            return new ArrayHandler(arrayHandlerJson.getWhat(), arrayHandlerJson.getNumbers());
        } else {
            return new ArrayHandlerError();
        }
    }
}
