using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectOrientation
{
    class Person
    {
        private int _age;
        public int Age { get; set; }
        private string _firstName;
        public string FirstName { get; set; }
        private string _lastName;
        public string LastName { get; set; }

        public Person(string _firstName, string _lastName)
        {
            this._firstName = _firstName;
            this._lastName = _lastName;
            this._age = 25;
        }

        public void PrintFullname()
        {
            Console.WriteLine("My full name is {0} {1}.", FirstName, LastName);
        }

        public void Walk()
        {
            Console.WriteLine("I am walking.");
        }

        public void Talk()
        {
            Console.WriteLine("I am talking.");
        }

        public void Eat()
        {
            Console.WriteLine("I am eating.");
        }

        public void Sleep()
        {
            Console.WriteLine("I am sleeping.");
        }
    }
}
