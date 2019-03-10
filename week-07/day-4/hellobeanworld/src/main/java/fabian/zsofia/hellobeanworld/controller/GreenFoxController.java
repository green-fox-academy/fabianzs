package fabian.zsofia.hellobeanworld.controller;

import fabian.zsofia.hellobeanworld.models.GFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreenFoxController {

    GFService studentService;

    @Autowired
    public GreenFoxController(@Qualifier("file") GFService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/gfa", method = RequestMethod.GET)
    public String showIndex(Model model) {
        model.addAttribute("count", studentService.count());
        return "gftemplates/main";
    }

    @RequestMapping(value = "/gfa/list", method = RequestMethod.GET)
    public String showList(Model model) {
        model.addAttribute("students", studentService.getNames());
        return "gftemplates/list";
    }

    @RequestMapping(value = "/gfa/add", method = RequestMethod.GET)
    public String addStudent() {
        return "gftemplates/add";
    }

    @RequestMapping(value = "/gfa/save", method = RequestMethod.GET)
    public String saveStudent(@ModelAttribute("name") String name) {
        studentService.save(name);
        return "redirect:/gfa";
    }

    @RequestMapping(value = "/gfa/check", method = RequestMethod.GET)
    public String checkStudent() {
        return "gftemplates/check";
    }

    @RequestMapping(value = "/gfa/check", method = RequestMethod.POST)
    public String existStudent(Model model, @ModelAttribute("name") String name) {
        model.addAttribute("contains", studentService.getNames().contains(name));
        return "gftemplates/check";
    }
}
