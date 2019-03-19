package fabian.zsofia.groot.controllers;

import fabian.zsofia.groot.models.Groot;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class GuardianController {

    @RequestMapping(path = "/groot", method = RequestMethod.GET)
    public Object getMessage(@RequestParam(name = "message", required = false) String somemessage) {
        if (somemessage != null) {
            return new Groot(somemessage);
        } else {
            Map<String, String> error = new HashMap<>();
            error.put("error", "I am Groot");
            return error;
        }
    }
}
