package fabian.zsofa.bankofsimba.controllers;

import fabian.zsofa.bankofsimba.models.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class BankOfSimbaController {
    List<BankAccount> bankAccounts;

    public BankOfSimbaController() {
        this.bankAccounts = new ArrayList<>();
        this.bankAccounts.add(new BankAccount("Simba", 2000, "lion", true, "good"));
        this.bankAccounts.add(new BankAccount("Timon", 200, "mungoose", false, "good"));
        this.bankAccounts.add(new BankAccount("Pumba", 350, "wart-hog", false, "good"));
        this.bankAccounts.add(new BankAccount("Ed", 800, "hyena", false, "bad"));
        this.bankAccounts.add(new BankAccount("Mufasa", 3000, "lion", true, "good"));
        this.bankAccounts.add(new BankAccount("Zazu", 1000, "toucan", false, "good"));
        this.bankAccounts.add(new BankAccount("Nala", 1500, "lion", false, "good"));
        this.bankAccounts.add(new BankAccount("Shenzi", 900, "hyena", false, "bad"));
    }

    @RequestMapping("/bank")
    public String showBankAccount(Model model) {
        model.addAttribute("bankAccount", bankAccounts.get(0));
       return "bank";
    }

    @RequestMapping("/string")
    public String showString(Model model) {
        model.addAttribute("string", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
        return "string";
    }

    @GetMapping("/bank/accounts")
    public String showBankAccounts(Model model) {
        model.addAttribute("bankAccounts", bankAccounts);
        return "bankaccounts";
    }

    @PostMapping("/bank/accounts")
    public String incrementBankAccounts(Model model, @RequestParam("animalIndex") int index) {
        bankAccounts.get(index).raiseBalance();
        model.addAttribute("bankAccounts", bankAccounts);
        return "bankaccounts";
    }
}
