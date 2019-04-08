using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Threading.Tasks;

namespace BankOfSimba.Models
{
    public class BankAccount
    {
        private static int globalId = 1;
        public int Id { get; set; }
        public string Name { get; set; }
        public int Balance { get; set; }
        public string AnimalType { get; set; }
        public bool IsKing { get; set; }
        public bool IsGood { get; set; }

        public BankAccount()
        {
            Id = globalId++;
            IsKing = true;
            IsGood = true;
        }

        public BankAccount(string name, int balance, string animalType, bool isKing, bool isGood)
        {
            Id = globalId++;
            Name = name;
            Balance = balance;
            AnimalType = animalType;
            IsKing = isKing;
            IsGood = isGood;
        }
    }
}
