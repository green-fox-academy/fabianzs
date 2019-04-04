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
            Ship ship1 = new Ship();
            ship1.IntroduceYourCaptainAndCrew();
            Ship ship2 = new Ship();
            ship2.IntroduceYourCaptainAndCrew();
            Console.WriteLine(ship1.Battle(ship2));
            ship1.IntroduceYourCaptainAndCrew();
            ship2.IntroduceYourCaptainAndCrew();
            ship2.Captain.HowsItGoingMate();

            Console.ReadKey();
        }
    }
}
