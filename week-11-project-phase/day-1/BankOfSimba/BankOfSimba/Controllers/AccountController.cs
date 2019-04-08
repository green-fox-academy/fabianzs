using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BankOfSimba.Models;
using BankOfSimba.ViewModels;
using Microsoft.AspNetCore.Mvc;

// For more information on enabling MVC for empty projects, visit https://go.microsoft.com/fwlink/?LinkID=397860

namespace BankOfSimba.Controllers
{
    [Route("")]
    public class AccountController : Controller
    {
        //public static AccountListViewModel AccountListViewModel = new AccountListViewModel();
        public static List<BankAccount> BankAccounts = new List<BankAccount>()
        {
            new BankAccount("Simba", 2000, "lion", true, true),
            new BankAccount("Timon", 200, "mungoose", false, true),
            new BankAccount("Pumba", 350, "wart-hog", false, true),
            new BankAccount("Ed", 800, "hyena", false, false),
            new BankAccount("Mufasa", 3000, "lion", true, true),
            new BankAccount("Zazu", 1000, "toucan", false, false),
            new BankAccount("Nala", 1500, "lion", false, true),
            new BankAccount("Shenzi", 900, "hyena", false, false)
        };

        [HttpGet("show")]
        public IActionResult List()
        {
            ViewBag.BankAccounts = BankAccounts;
            return View("BankAccount_List");
        }

        [HttpPost("show")]
        public IActionResult RaiseBalance(int animalIndex)
        {
            BankAccounts[animalIndex-1].RaiseBalance();
            return RedirectToAction("List");
        }

        [HttpGet("show/viewmodel")]
        public IActionResult ListWithViewModel()
        {
            return View("BankAccounts_List_ViewModel"/*, AccountListViewModel*/);
        }

        [HttpPost("add")]
        public IActionResult Add(/*AccountListViewModel accountListViewModel*/ BankAccount bankAccount)
        {
            BankAccounts.Add(bankAccount);
            //AccountListViewModel.BankAccounts.Add(accountListViewModel.NewBankAccount);

            return RedirectToAction("List");
        }
    }
}
