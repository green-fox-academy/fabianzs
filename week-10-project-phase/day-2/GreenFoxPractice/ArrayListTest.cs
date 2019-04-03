using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GreenFoxPractice
{
    class ArrayListTest
    {
        public static void ArraysAndLists()
        {
            List<int> numbers = new List<int>();
            numbers.Add(12);
            numbers.Add(8);
            numbers.Add(3);
            numbers.Add(4);
            numbers.Add(1);
            numbers.Add(53);

            foreach (var number in numbers)
            {
                Console.Write(number + " ");
            }
            Console.WriteLine("");

            numbers.RemoveAt(2);

            foreach (var number in numbers)
            {
                Console.Write(number + " ");
            }
            Console.WriteLine("");

            Console.WriteLine(numbers[1]);

            int[] array1 = new int[6] { 1, 2, 3, 4, 5, 6 };

            Array.Reverse(array1);
            Array.Sort(array1);

            Console.Write(string.Join(",", array1));
        }
    }
}
