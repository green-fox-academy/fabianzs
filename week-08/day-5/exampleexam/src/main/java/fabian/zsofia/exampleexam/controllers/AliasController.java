package fabian.zsofia.exampleexam.controllers;

import fabian.zsofia.exampleexam.models.Alias;
import fabian.zsofia.exampleexam.services.AliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Controller
public class AliasController {

    AliasService aliasService;

    @Autowired
    public AliasController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @RequestMapping("/")
    public String getMainPage(Model model, @RequestParam(name = "exist", required = false) boolean exist, @RequestParam(name ="url_alias", required = false) String urlAlias, @RequestParam(name="url", required = false) String url) {
        if (urlAlias != null && exist) {
            model.addAttribute("exist", true);
            model.addAttribute("new_alias", new Alias(urlAlias, url));
        } else if (urlAlias != null && !exist) {
            model.addAttribute("exist", false);
            model.addAttribute("alias", aliasService.findAliasByUrlAlias(urlAlias));
            model.addAttribute("new_alias", new Alias());
        } else {
            model.addAttribute("new_alias", new Alias());
        }
        return "main";
    }

    @RequestMapping(path = "/save-link", method = RequestMethod.POST)
    public String addAlias(Alias alias) {
        if (!aliasService.containsAlias(alias.getUrlAlias())) {
            aliasService.addAlias(alias);
            return "redirect:/?exist=false&url_alias=" + alias.getUrlAlias() + "&url=" + alias.getUrl();
        } else {
            return "redirect:/?exist=true&url_alias=" + alias.getUrlAlias() + "&url=" + alias.getUrl();
        }
    }

    @RequestMapping(path = "/a/{alias}", method = RequestMethod.GET)
    public Object findAlias(@PathVariable String alias) {
        if (aliasService.containsAlias(alias)) {
            Alias foundAlias = aliasService.findAliasByUrlAlias(alias);
            foundAlias.incrementHitCount();
            aliasService.updateAlias(foundAlias.getId(), foundAlias);
            return "redirect:" + foundAlias.getUrl();
        } else {
            /*throw new ResponseStatusException(HttpStatus.NOT_FOUND);*/
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/api/links", method = RequestMethod.GET)
    @ResponseBody
    public Object showLinks() {
        return aliasService.findAll();
    }

    @RequestMapping(path = "/api/links/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteLink(@RequestBody(required = false) Map<String, String> secretCode, @PathVariable long id) {
        if (secretCode == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else if (secretCode != null && aliasService.findAliasBySecretCode(secretCode.get("secretCode")) == null) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        } else {
            aliasService.deleteAlias(secretCode.get("secretCode"), id);
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}
