using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace GreenFoxPractice
{
    class StarWars
    {
        public static void PlayMainTheme()
        {
            Console.Beep(300, 500);
            Thread.Sleep(50);
            Console.Beep(300, 500);
            Thread.Sleep(50);
            Console.Beep(300, 500);
            Thread.Sleep(50);
            Console.Beep(250, 500);
            Thread.Sleep(50);
            Console.Beep(350, 250);
            Console.Beep(300, 500);
            Thread.Sleep(50);
            Console.Beep(250, 500);
            Thread.Sleep(50);
            Console.Beep(350, 250);
            Console.Beep(300, 500);
            Thread.Sleep(50);
        }
    }
}
