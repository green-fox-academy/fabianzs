package fabian.zsofia.hundredacrewood.controllers;

import fabian.zsofia.hundredacrewood.models.Gender;
import fabian.zsofia.hundredacrewood.models.Inhabitant;
import fabian.zsofia.hundredacrewood.models.InhabitantList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class InhabitantController {

    private InhabitantList inhabitantList;

    @Autowired
    public InhabitantController(InhabitantList inhabitantList) {
        this.inhabitantList = inhabitantList;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getMainPage() {
        return "index";
    }

    @RequestMapping(path = "/inhabitants", method = RequestMethod.GET)
    public String showInhabitants(Model model) {
        model.addAttribute("inhabitants", inhabitantList.getInhabitants());
        return "inhabitant_table";
    }

    @RequestMapping(path = "/inhabitants/{id}", method = RequestMethod.GET)
    public String getInhabitantById(Model model, @PathVariable int id) {
        Inhabitant inhabitant = inhabitantList.getInhabitantById(id);
        if (inhabitant != null) {
            model.addAttribute("inhabitant_by_id", inhabitant);
        } else {
            model.addAttribute("error", "No inhabitant found by id.");
        }
        return "inhabitant_id";
    }

    @RequestMapping(path = "/inhabitants/add", method = RequestMethod.GET)
    public String showInhabitantForm(Model model) {
        model.addAttribute("newinhabitant", new Inhabitant());
        model.addAttribute("genders", Gender.values());
        return "inhabitant_form";
    }

    @RequestMapping(path = "/inhabitants/add", method = RequestMethod.POST)
    public String addInhabitant(Inhabitant newinhabitant) {
        inhabitantList.addInhabitant(newinhabitant);
        return "redirect:/inhabitants";
    }
}
