package fabian.zsofia.hellobeanworld.controller;

import fabian.zsofia.hellobeanworld.models.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UsefulUtilityController {

    UtilityService utilityService;

    @Autowired
    public UsefulUtilityController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @RequestMapping("/useful")
    public String showUsefulUtilities() {
        return "index";
    }

    @RequestMapping("/useful/colored")
    public String showColor(Model model) {
        model.addAttribute("randomcolor", utilityService.randomColor());
        return "color";
    }

    @RequestMapping(value = "/useful/validemail", method = RequestMethod.GET)
    public String getEmail() {
        return "validemail";
    }

    @RequestMapping(value = "/useful/validemail", method = RequestMethod.POST)
    public String postEmail(Model model, @RequestParam String email) {
        model.addAttribute("email", email);
        model.addAttribute("validemail", utilityService.validateEmail(email));
        return "validemail";
    }


    @RequestMapping("/useful/email")
    public String email(Model model,@RequestParam String email){
        model.addAttribute("email", email);
        model.addAttribute("validemail", utilityService.validateEmail(email));
        return "email";
    }

    @RequestMapping("/useful/encode")
    public String caesarEncode(Model model, @RequestParam String text, @RequestParam int number) {
        model.addAttribute("encoded", utilityService.caesar(text, number));
        return "encode";
    }

    @RequestMapping("/useful/decode")
    public String caesarDecoder(Model model, @RequestParam String text, @RequestParam int number) {
        model.addAttribute("encoded", utilityService.caesar(text, -number));
        return "encode";
    }

    @RequestMapping(value="/useful/encoderdecoder", method = RequestMethod.GET)
    public String getCaesarEncoderDecoder() {
        return "encoderdecoder";
    }

    @RequestMapping(value="/useful/encoderdecoder", method = RequestMethod.POST)
    public String putCaesarEncoderDecoder(Model model, @RequestParam String text, @RequestParam int number) {
        model.addAttribute("encoded", utilityService.caesar(text, number));
        model.addAttribute("decoded", utilityService.caesar(text, -number));
        return "encoderdecoder";
    }

}
