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

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.http.HTTPException;


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

    @RequestMapping("/a/{alias}")
    public String findAlias(@PathVariable String alias) {
        if (aliasService.containsAlias(alias)) {
            Alias foundAlias = aliasService.findAliasByUrlAlias(alias);
            foundAlias.incrementHitCount();
            aliasService.updateAlias(foundAlias.getId(), foundAlias);
            return "redirect:" + foundAlias.getUrl();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
