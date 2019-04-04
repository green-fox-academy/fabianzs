using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ObjectOrientation
{
    class Program
    {
        static void Main(string[] args)
        {

            List<Person> persons = new List<Person> { new Person("Adam", "Smith"), new Person("Till", "Lindemann"), new Person("Jonathan", "Davis") };
            Console.WriteLine(persons.ToString());
            
            Console.ReadKey();
        }
    }
}
