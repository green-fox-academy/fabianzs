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
            Pirate pirate = new Pirate();
            pirate.LevelOfIntoxication = 24;
            Console.ReadKey();
        }
    }
}
