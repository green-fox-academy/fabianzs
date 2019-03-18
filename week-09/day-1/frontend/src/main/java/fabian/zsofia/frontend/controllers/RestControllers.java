package fabian.zsofia.frontend.controllers;

import fabian.zsofia.frontend.models.Doubling;
import fabian.zsofia.frontend.models.ErrorMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {

    @RequestMapping(path = "/doubling",  method = RequestMethod.GET)
    public Object getDouble(@RequestParam(name = "input", required = false) Integer received) {
        if (received != null) {
            return new Doubling(received);
        } else {
            return new ErrorMessage();
        }
    }
}
