using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectOrientation
{
    class SuperPerson : Person
    {
        public SuperPerson(string _firstName, string _lastName) : base(_firstName,_lastName)
        {
        }

        public void Fly()
        {
            Console.WriteLine("I am flying!");
        }
    }
}
