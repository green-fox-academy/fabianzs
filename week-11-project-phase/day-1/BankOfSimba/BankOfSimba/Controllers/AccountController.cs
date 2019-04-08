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
        //public AccountListViewModel AccountListViewModel { get; set; }
        public List<BankAccount> BankAccounts { get; set; }

        public AccountController()
        {
            BankAccounts = new List<BankAccount>();
            BankAccounts.Add(new BankAccount("Simba", 2000, "lion", true, true));
            BankAccounts.Add(new BankAccount("Timon", 200, "mungoose", false, true));
            BankAccounts.Add(new BankAccount("Pumba", 350, "wart-hog", false, true));
            BankAccounts.Add(new BankAccount("Ed", 800, "hyena", false, false));
            BankAccounts.Add(new BankAccount("Mufasa", 3000, "lion", true, true));
            BankAccounts.Add(new BankAccount("Zazu", 1000, "toucan", false, false));
            BankAccounts.Add(new BankAccount("Nala", 1500, "lion", false, true));
            BankAccounts.Add(new BankAccount("Shenzi", 900, "hyena", false, false));
        }

        [HttpGet("show")]
        public IActionResult List()
        {
            ViewBag.BankAccounts = BankAccounts;
            ViewBag.NewAccount = new BankAccount();
            return View("BankAccount_List");
        }

        [HttpGet("show/viewmodel")]
        public IActionResult ListWithViewModel()
        {
            return View("BankAccounts_List_ViewModel", new AccountListViewModel());
        }

        [HttpPost("add")]
        public void Add(BankAccount bankAccount)
        {
            BankAccounts.Add(bankAccount);
            Console.WriteLine(BankAccounts.Count());
        }
    }
}
