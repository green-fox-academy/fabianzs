using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LINQExercises
{
    class Program
    {
        static void Main(string[] args)
        {
            //Exercise1();
            //Exercise2();
            //Exercise3();
            //Exercise4();
            //Exercise5();
            //Exercise6();
            Exercise9();

            Console.ReadKey();
        }

        static void Exercise1()
        {
            //Write a LINQ Expression to get the even numbers from the following array:
            int[] numbers = { 1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14 };
            int[] even = numbers.Where(n => n % 2 == 0).ToArray();
            var even1 = numbers.Where(n => n % 2 == 0);
            var even2 = Enumerable.Select(Enumerable.Where(numbers, n => n % 2 == 0), n => n);
            var even3 = from number in numbers
                        where number % 2 == 0
                        select number;

            Array.ForEach(even, i => Console.WriteLine(i));
            Console.WriteLine();
            new List<int>(even1).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
            new List<int>(even2).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
            new List<int>(even3).ForEach(i => Console.WriteLine(i));
        }

        static void Exercise2()
        {
            //Write a LINQ Expression to get the average value of the odd numbers from the following array:
            int[] numbers = { 1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14 };
            double average = numbers.Where(n => Math.Abs(n % 2) == 1).Average();
            var average1 = numbers.Where(n => Math.Abs(n % 2) == 1).Average();
            var average2 = (from number in numbers
                            where number % 2 == 1 || number % 2 == -1
                            select number).Average();

            Console.WriteLine(average);
            Console.WriteLine();
            Console.WriteLine(average1);
            Console.WriteLine();
            Console.WriteLine(average2);
            Console.WriteLine();
        }

        static void Exercise3()
        {
            //Write a LINQ Expression to get the squared value of the positive numbers from the following array:
            int[] numbers = { 1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14 };
            int[] positiveSquares = numbers.Where(n => n > 0).Select(n => n * n).ToArray();
            var positiveSquares1 = from number in numbers
                                   where number > 0
                                   select number * number;

            new List<int>(positiveSquares).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
            new List<int>(positiveSquares1).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
        }

        static void Exercise4()
        {
            //Write a LINQ Expression to find which number squared value is more then 20 from the following array:
            int[] numbers = new[] { 3, 9, 2, 8, 6, 5 };
            int[] squareIsMoreThan20 = numbers.Where(n => n * n > 20).ToArray();
            var squareIsMoreThan201 = from number in numbers
                                      where number * number > 20
                                      select number;

            new List<int>(squareIsMoreThan20).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
            new List<int>(squareIsMoreThan201).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
        }

        static void Exercise5()
        {
            //Write a LINQ Expression to find the frequency of numbers in the following array:
            int[] numbers = new int[] { 5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2 };
            var frequency = numbers.GroupBy(n => n).Distinct().ToArray();
            int[] frequency1 = numbers.GroupBy(n => n).Select(g => g.Count()).ToArray();

            Console.WriteLine(frequency[0]);
            Console.WriteLine();
            new List<int>(frequency1).ForEach(i => Console.WriteLine(i));
            Console.WriteLine();
        }

        static void Exercise6()
        {
            //Write a LINQ Expression to find the frequency of characters in a given string.
            string stringToCheck = "I'm gonna tell you something you don't want to hear, I'm gonna show you where it's dark, but have no fear";
            Dictionary<char, int> charFrequency = stringToCheck.ToCharArray().Where(c => !c.Equals(' ')).GroupBy(n => char.ToLower(n)).ToDictionary(g => g.Key, g => g.Count());

            foreach (KeyValuePair<char, int> kvp in charFrequency)
            {
                Console.WriteLine("Key = {0}, Value = {1}", kvp.Key, kvp.Value);
            }
        }

        static void Exercise9()
        {
            // Write a LINQ Expression to convert a char array to a string.
            char[] charArray = { 'a', 'p', 'p', 'l', 'e' };

            string charsToString = new string(charArray.Select(p => p).ToArray());
            Console.WriteLine(charsToString);

            string charsToString1 = String.Join("", charArray.Select(p => p.ToString()).ToArray());
            Console.WriteLine(charsToString1);

            string charsToString2 = "";
            Array.ForEach(charArray, c => charsToString2 += c);
            Console.WriteLine(charsToString2);

            StringBuilder charsToString3 = new StringBuilder();
            Array.ForEach(charArray, p => charsToString3.Append(p));
            Console.WriteLine(charsToString3.ToString());
        }
    }
}
