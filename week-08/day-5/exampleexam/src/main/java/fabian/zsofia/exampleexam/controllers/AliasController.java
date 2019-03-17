package fabian.zsofia.exampleexam.controllers;

import fabian.zsofia.exampleexam.models.Alias;
import fabian.zsofia.exampleexam.services.AliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class AliasController {

    AliasService aliasService;

    @Autowired
    public AliasController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @RequestMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("new_alias", new Alias());
        if (!model.asMap().containsKey("exist")) {
            model.addAttribute("first_load", true);
            model.addAttribute("exist", false);
        } else {
            model.addAttribute("first_load", false);
        }
        return "main";
    }

    @RequestMapping(path = "/save-link", method = RequestMethod.POST)
    public ModelAndView getMainPage(ModelMap model, @ModelAttribute("new_alias") Alias alias) {
        if (!aliasService.containsAlias(alias.getAlias())) {
            aliasService.addAlias(alias);
        }
        model.addAttribute("exist", aliasService.containsAlias(alias.getAlias()));
        return new ModelAndView("redirect:/", model);
    }
}
