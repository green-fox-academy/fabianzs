using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GreenFoxPractice
{
    class Program
    {
        static void Main(string[] args)
        {
            Greet();

            Console.WriteLine(Sum(5, 4));
                       
            Console.WriteLine("");

            DrawDiamond.Diamond(11);

            Console.WriteLine("");

            Console.WriteLine(StringTest.ReverseString("string to reverse"));

            Console.WriteLine(StringTest.TakesLonger("Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law."));


            Console.ReadKey();

        }

     
        public static void Greet()
        {
            string name = "fzs";
            Console.WriteLine(name);
        }

        public static int Sum(int a, int b)
        {
            return a + b;
        }

        public static void ReadAndWriteLine()
        {
            int input = int.Parse(Console.ReadLine());
            Console.WriteLine(input);
        }

    }
}