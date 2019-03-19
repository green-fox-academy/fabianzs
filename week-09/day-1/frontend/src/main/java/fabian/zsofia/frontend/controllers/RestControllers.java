package fabian.zsofia.frontend.controllers;

import fabian.zsofia.frontend.models.*;
import fabian.zsofia.frontend.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
public class RestControllers {

    LogService logService;

    @Autowired
    public RestControllers(LogService logService) {
        this.logService = logService;
    }

    @RequestMapping(path = "/doubling",  method = RequestMethod.GET)
    public Object getDoubling(@RequestParam(name = "input", required = false) Integer received) {
        if (received != null) {
            logService.addLog(new Log("/doubling", "input=" + received));
            return new Doubling(received);
        } else {
            logService.addLog(new Log("/doubling", new DoublingError().getError()));
            return new DoublingError();
        }
    }

    @RequestMapping(path = "/greeter",  method = RequestMethod.GET)
    public Object getGreeter(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "title", required = false) String title) {
        GreeterError greeterError = new GreeterError();
        if (name == null && title == null) {
            logService.addLog(new Log("/greeter", greeterError.getError()));
            return greeterError;
        } else if (name == null && title != null) {
            greeterError.setNameError();
            logService.addLog(new Log("/greeter", greeterError.getError()));
            return greeterError;
        } else if (name != null && title == null) {
            greeterError.setTitleError();
            logService.addLog(new Log("/greeter", greeterError.getError()));
            return greeterError;
        } else {
            logService.addLog(new Log("/greeter", "name=" + name + "&title=" + title));
            return new Greeter(name, title);
        }
    }

    @RequestMapping(path = "/appenda/{appendable}", method = RequestMethod.GET)
    public Object getAppenda(@PathVariable String appendable) {
        logService.addLog(new Log("/appenda/" + appendable, "appendable=" + appendable));
        return new AppendA(appendable);
    }

    @RequestMapping(path = "/dountil/{action}", method = RequestMethod.POST)
    public Object postDoUntil(@PathVariable String action, @RequestBody(required = false) Until until) {
        if (until != null) {
            logService.addLog(new Log("/dountil/" + action, "action=" + action + "&{\"until\":" + until.getUntil() + "}"));
            return new DoUntil(action, until);
        } else {
            logService.addLog(new Log("/dountil/" + action, "action=" + action + "&" + new DoublingError().getError()));
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
        /*System.out.println(arrayHandlerJson);*/
        if (arrayHandlerJson != null && arrayHandlerJson.getWhat() != null && arrayHandlerJson.getNumbers() != null) {
            logService.addLog(new Log("/array", "{\"what\": \"" + arrayHandlerJson.getWhat() + "\", \"numbers\":" + Arrays.toString(arrayHandlerJson.getNumbers())));
            return new ArrayHandler(arrayHandlerJson.getWhat(), arrayHandlerJson.getNumbers());
        } else {
            return new ArrayHandlerError();
        }
    }

    @RequestMapping(path = "/log", method = RequestMethod.GET)
    public LogList getLogs() {
        return new LogList(logService.getLogs());
    }

    @RequestMapping(path = "/sith", method = RequestMethod.POST)
    public Object modifyTextByReverserOfTheSith(@RequestBody SithReverserText sithReverserText) {
        return new SithReverserSithText(sithReverserText);
    }
}
