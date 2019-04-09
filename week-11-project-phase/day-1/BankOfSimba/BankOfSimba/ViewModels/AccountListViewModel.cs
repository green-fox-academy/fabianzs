using BankOfSimba.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BankOfSimba.ViewModels
{
    public class AccountListViewModel
    {
        public List<BankAccount> BankAccounts = new List<BankAccount>()
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

        public void AddBankAccount(BankAccount bankAccount)
        {
            BankAccounts.Add(bankAccount);
        }
    }
}
