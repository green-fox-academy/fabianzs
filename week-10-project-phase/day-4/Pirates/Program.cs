using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Pirates
{
    class Program
    {
        static void Main(string[] args)
        {
            Pirate pirate1 = new Pirate();
            Pirate pirate2 = new Pirate();

            pirate1.Brawl(pirate2);

            Console.ReadKey();
        }
    }
}
