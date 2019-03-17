package fabian.zsofia.exampleexam.controllers;

import fabian.zsofia.exampleexam.models.Alias;
import fabian.zsofia.exampleexam.services.AliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AliasController {

    AliasService aliasService;

    @Autowired
    public AliasController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @RequestMapping
    public String getMainPage(Model model) {
        model.addAttribute("new_alias", new Alias());
        return "main";
    }
}
