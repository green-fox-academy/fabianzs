using BankOfSimba.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BankOfSimba.ViewModels
{
    public class AccountListViewModel
    {
        public List<BankAccount> BankAccounts { get; set; }
        //public BankAccount NewBankAccount { get; set; }

        public AccountListViewModel()
        {
            this.BankAccounts = new List<BankAccount>();
            BankAccounts.Add(new BankAccount("Simba", 2000, "lion", true, true));
            BankAccounts.Add(new BankAccount("Timon", 200, "mungoose", false, true));
            BankAccounts.Add(new BankAccount("Pumba", 350, "wart-hog", false, true));
            BankAccounts.Add(new BankAccount("Ed", 800, "hyena", false, false));
            BankAccounts.Add(new BankAccount("Mufasa", 3000, "lion", true, true));
            BankAccounts.Add(new BankAccount("Zazu", 1000, "toucan", false, false));
            BankAccounts.Add(new BankAccount("Nala", 1500, "lion", false, true));
            BankAccounts.Add(new BankAccount("Shenzi", 900, "hyena", false, false));

            //this.NewBankAccount = new BankAccount();
        }

        public void AddBankAccount(BankAccount bankAccount)
        {
            //BankAccounts.Add(bankAccount);
        }
    }
}
